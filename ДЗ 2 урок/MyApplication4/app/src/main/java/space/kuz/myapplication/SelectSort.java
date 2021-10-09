package space.kuz.myapplication;

public class SelectSort {

    public static MyComputer[] sort(MyComputer[] arr){
        int out, in, mark;
        for(out=0;out<arr.length;out++){
            mark = out;
            for(in = out+1;in<arr.length;in++){
                if (arr[in].getCent()+arr[in].getMind() +arr[in].getProInt()< arr[mark].getCent()+arr[mark].getMind() +arr[mark].getProInt()){
                    mark = in;
                }
            }
            change(out, mark,arr);
        }
return arr;
    }

    private static void change(int a, int b, MyComputer[] arr){
        int tmp = arr[a].getCent();
        int tmp2 = arr[a].getMind();
        int tmp3 = arr[a].getProInt();
        arr[a].setCent(arr[b].getCent());
        arr[a].setMind(arr[b].getMind());
        arr[a].setProInt(arr[b].getProInt());
        arr[b].setCent(tmp);
        arr[b].setMind(tmp2);
        arr[b].setProInt(tmp3);
    }
    }

