public interface LinkedList<E> {
    boolean insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E valnue);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E>{
        E item;
        Node<E> next;

        public Node(E item,Node<E> next){
            this.item = item;
            this.next = next;
        }
    }
}
