import java.util.LinkedList;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
      //  DequeInit linkedDeque = new LinkedDeque<>();
        TwoSideLinkedList linkedList = new TwoSideLinkedListImp<>();
      /*  linkedDeque.insertLeft(32);
        linkedDeque.insertLeft(2);
        linkedDeque.insertLeft(5);
        linkedDeque.insertLeft(65);
        linkedDeque.insertLeft(8);
        linkedDeque.insertRight(1111);
      System.out.println(  linkedDeque.removeRight());
        linkedDeque.insertRight(2222);*/

        linkedList.insertFirst(12);
        linkedList.insertFirst(4334);
        linkedList.insertFirst(1);
        linkedList.insertLast(34);
        linkedList.display();
     System.out.println("Delete " +  linkedList.removeLast());
      //  System.out.println("Delete " +  linkedList.removeFirst());
       // System.out.println("Delete 65 :" + linkedList.remove(65));
        //System.out.println("Delete 32 :" +  linkedList.remove(2222));

        linkedList.display();
LinkedList<Integer> l = new LinkedList<>();
    l.add(11);
    l.add(13);
    l.toString();


        for(Integer value:l){
            System.out.println("value: " + value);
        }
    /*    StackImp<Integer> stack = new LinkedListStack<>();
        if(!stack.isEmpty()){
            stack.pop();
        }

       stack.push(12);
        stack.push(16);
        stack.push(22);
        stack.push(5);
        stack.push(1);
        stack.push(32);
        stack.push(3);
        stack.display();
        stack.pop();
       System.out.println("Peek = " +stack.peek());
        stack.display();
*/




    }
}
     /*   int[] arrayNumber1 = new int []{1,2,3,4,5,6,7,8,9,10,12,13,14,15} ;
        int[] arrayNumber2 = new int []{1,2,4,5,6} ;
        int[] arrayNumber3 = new int []{} ;
        System.out.println(findNumber(arrayNumber1)+"");
        System.out.println(findNumber(arrayNumber2)+"");
        System.out.println(findNumber(arrayNumber3)+"");


        Deque<Integer> deque = new Deque<>(5);

        System.out.println("add element: " + deque.insertLeft(1));
        System.out.println("add element: " + deque.insertLeft(2) );
        System.out.println("add element: " + deque.insertLeft(4) );
        System.out.println("add element: " + deque.insertLeft(5) );
        System.out.println("add element: " + deque.insertLeft(6) );
       // System.out.println(deque.removeRight());
      //  deque.display();
       System.out.println("add element: " + deque.insertLeft(5) );
   //   System.out.println(deque.removeRight());
       // System.out.println("add element: " + deque.insertRight(5) );
        deque.display();
    }

    public static int findNumber(int[] arr){
        int answer =0;
       int  midArray = arr.length/2;
       int mid = arr.length;
       while (true) {
           if (arr.length==0){ answer = 1; break;}
           if (midArray == arr[midArray - 1]) {
               mid = mid/2;
               midArray = midArray +  (mid/2);
           } else {
               midArray = midArray - mid / 2;
           }
           if(arr[midArray]-arr[midArray-1] == 2){
               answer =arr[midArray]-1;
               break;
           }
       }
       return answer;
    }


}*/
