public class TwoSideLinkedListImp<E> extends SimpleLinkedListImp<E> implements TwoSideLinkedList<E>{
   protected Node<E> last;

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value,null);

        if(isEmpty()){
            insertFirst(value);
            return;
        }
        last.next = newNode;
        last= newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if(size==1){
            last = first;
        }
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
}
