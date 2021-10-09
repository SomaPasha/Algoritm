package space.kuz.myapplication;

import java.util.Objects;
import java.util.Random;

public class MyArray {

    public static Integer[] getArray( int gapElement, int min , int max){
         int size = (max-min)/gapElement;
        Integer[] arr = new Integer[size+1];
        arr[0]=min;
        for (int i = 1; i <size+1 ; i++) {
            arr[i]= arr[i-1]+ gapElement;
        }

        return arr;
    }

    public static  int getRandomElement(Object[] arr){
        Random random = new Random();
        return random.nextInt(arr.length);
    }


}
