package space.kuz.myapplication;

public class BubbleSort {

    public static MyComputer[] sort(MyComputer[] arr){
        boolean isChange;
        int limit = arr.length;

    do{
            limit--;
         isChange=false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1].getCent()+arr[i + 1].getMind() +arr[i + 1].getProInt() < arr[i].getCent()+arr[i].getMind()+arr[i].getProInt()) {
                    MyComputer temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isChange=true;
                }
            }

        } while (isChange);
        return arr;
    }
}
