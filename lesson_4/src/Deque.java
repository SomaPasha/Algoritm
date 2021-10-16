import java.util.Arrays;

public class Deque<E> implements DequeInit<E> {
    private int maxSize;
    private E[] deque;
    private int head;
    private int tail;
    int items;

    public  Deque(int size){
        maxSize =size;
        deque = (E[])new Object[maxSize];
        head =-1;
        tail = -1;
        items = 0;
    }

    @Override
    public  boolean insertLeft(E number) {
        if (items != maxSize) {
            if (head == -1|| head==0) {
                head = maxSize;
            }
            deque[--head] = number;
            items++;
            return true;
        } else {
            return  false;
        }
    }

    @Override
    public boolean insertRight(E number) {
        if (items != maxSize) {
        if(tail == maxSize-1){
            tail = -1;
        }
        deque[++tail] = number;
        items++;
        return true;
        } else {
            return  false;
        }
    }

    @Override
    public E removeLeft() {
        if ((head== -1 && items > 0) ) {
            head = 0;
        }
        E temp = deque[head++];
        deque[head-1] = null;
        if(head == maxSize && items > 0){
            head=0;
        }
        items--;
        return temp;
    }

    @Override
    public E removeRight() {
        if ((tail == -1 && items > 0)) {
            tail= maxSize-1;
        }
        E temp  = deque[tail--];
        deque[tail+1]= null;
        if (tail == 0 && items > 0) {
            tail= maxSize-1;
        }
        items--;
            return temp;
    }

    @Override
    public E peekHead() {
        return deque[head];
    }

    @Override
    public E peekTail() {
        return deque[tail];
    }


    @Override
    public boolean isEmply() {
        return (items==0);
    }

    @Override
    public boolean isFull() {
        return (items==maxSize);
    }

    @Override
    public int size() {
        return items;
    }

    @Override
    public String toString() {
        boolean isT = false;
        boolean isH = false;
        StringBuilder sb = new StringBuilder("[");
        if (items>0 && tail==-1){
             isT= true;
            tail =items+head-1;
        }
        if (items>0 && head==-1){
            isH= true;
            head =0;
        }
        if(head<tail){
            writeDeque1(head,tail,sb);
        }else{
            writeDeque2(tail,head,sb);
        }
        if (isT==true){
            tail=-1;
            isT =false;
        }
        if (isH==true){
            head=-1;
            isH =false;
        }

        sb.append("]");
       return sb.toString();
    }

    private void writeDeque1(int start, int end, StringBuilder sb) {
        if (deque[start+1] == null ||   start== end){
            for (int i = 0; i <=start; i++) {
                if(!(sb.toString().equals("["))){
                    sb.append(", ");
                }
                sb.append(deque[i]);
            }
            for (int i = end; i <maxSize; i++) {
                if(!(sb.toString().equals("["))){
                    sb.append(", ");
                }
                sb.append(deque[i]);
            }
        } else{
            for (int i = start; i <=end; i++) {
                if(!(sb.toString().equals("["))){
                    sb.append(", ");
                }
                sb.append(deque[i]);
            }
        }
    }


    private  void writeDeque2(int start, int end, StringBuilder sb){
      if (deque[start+1] == null ||   start+1 == end){
          for (int i = 0; i <=start; i++) {
             if(!(sb.toString().equals("["))){
              sb.append(", ");
          }
              sb.append(deque[i]);
          }
          for (int i = end; i <maxSize; i++) {
              if(!(sb.toString().equals("["))){
                  sb.append(", ");
              }
              sb.append(deque[i]);
          }
      } else{
          for (int i = start; i <=end; i++) {
              if(!(sb.toString().equals("["))){
                  sb.append(", ");
              }
              sb.append(deque[i]);
          }
      }

  }
    @Override
    public void display() {
        System.out.println(this);
    }
}
