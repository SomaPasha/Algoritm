import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TwoSideLinkedListImp<E> extends SimpleLinkedListImp<E>
        implements TwoSideLinkedList<E>,
                   Iterable<E>{
   protected Node<E> last;

    @Override
    public boolean insertLast(E value) {
        Node<E> newNode = new Node<>(value,null,last);

        if(isEmpty()){
            insertFirst(value);
            return false;
        }

        last.next = newNode;
        last= newNode;
        size++;
        return false;
    }

    @Override
    public boolean insertFirst(E value) {
        super.insertFirst(value);
        if(size==1){
            last = first;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        E removed = super.removeFirst();
        if(isEmpty()){
            last =null;
        }
        return  removed;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;
        while (current!=null){
            if(current.item.equals(value)){
                break;
            }
            prev = current;
            current= current.next;
        }
        if(current==null){
            return  false;
        } else
        if(current==first){
            removeFirst();
            return true;
        } else if (current==last){
            last=prev;
            last.next = null;
        }
        prev.next = current.next;
        current.next=null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }

    @Override
    public E removeLast() {
        Node<E> removeLastNode = last;
        last.prev.next=null;
        size--;
   return removeLastNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        @Override
        public boolean hasNext() {
            return  false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
