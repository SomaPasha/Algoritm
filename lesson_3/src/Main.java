public class Main {


    public static void main(String[] args) {


        int[] arrayNumber1 = new int []{1,2,3,4,5,6,7,8,9,10,12,13,14,15} ;
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


}
//C:\Users\pavel\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\WhatsApp