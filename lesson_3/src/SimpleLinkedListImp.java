public class SimpleLinkedListImp<E>  implements  LinkedList<E>{
    protected  Node<E> first;
    protected int size;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value,first);
        size++;
    }

    @Override
    public E removeFirst() {
      if(isEmpty()){
          return null;
      }
      Node<E> removerNode = first;
      first = first.next;
      removerNode.next = null;
      size--;
      return  removerNode.item;

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
        }
        if(current==first){
            removeFirst();
            return true;
        }
        prev.next = current.next;
        current.next=null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
      Node<E> current =first;
      while (current!=null){
          if(current.item.equals(value)){
              return true;
          }
          current=current.next;
      }
      return false ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
   StringBuilder stringBuilder = new StringBuilder("[");
    Node<E> current = first;
   while (current!=null){
       stringBuilder.append(current.item);
       if(current.next!=null){
           stringBuilder.append("->");
       }
       current = current.next;
   }
        stringBuilder.append("]");
        return  stringBuilder.toString();
    }

    @Override
    public void display() {
     System.out.println(this);
    }

    @Override
    public E getFirst() {
        return first.item;
    }
}
