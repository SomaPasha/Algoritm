import java.util.Stack;

public class LinkedListStack<E> implements StackImp<E>{
    private final LinkedList<E> data;

    public LinkedListStack(){
        this.data = new SimpleLinkedListImp<>();
    }
    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
         return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
    data.display();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "data=" + data +
                '}';
    }
}
