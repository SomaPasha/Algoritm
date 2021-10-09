package space.kuz.myapplication;

public class InsertionSort {
    public static MyComputer[] sort(MyComputer[] arr){
       for(int i=1 ;i <arr.length;i++){
           int value= arr[i].getCent()*10000+arr[i].getMind()*100+arr[i].getProInt();
           int j=i-1 ;
           while (j>=0 && arr[j].getCent()*10000+arr[j].getMind()*100+arr[j].getProInt()>value){
               arr[j+1].setCent(arr[j].getCent()) ;
               arr[j+1].setMind(arr[j].getMind()); ;
               arr[j+1].setProInt(arr[j].getProInt());
               j--;
           }
          arr[j+1].setProInt(value % 10);
          arr[j+1].setMind((value % 10000)/100);
          arr[j+1].setCent(value/10000);
       }
        return arr;
    }

}
