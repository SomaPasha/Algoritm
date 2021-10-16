public class TwoSideLinkedListImp<E> extends SimpleLinkedListImp<E> implements TwoSideLinkedList<E>{
   protected Node<E> last;

    @Override
    public boolean insertLast(E value) {
        Node<E> newNode = new Node<>(value,null);

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
        Node<E> removeLastNode = first;
        Node<E> endNode = null;
        if(isEmpty()){
          return null;
        }
        while (removeLastNode!=null){
            if(removeLastNode.equals(last)){
                break;
            }
            endNode=removeLastNode;
            removeLastNode=removeLastNode.next;
        }
        endNode.next=null;
        last=endNode;
        size--;
   return removeLastNode.item;
    }
}
