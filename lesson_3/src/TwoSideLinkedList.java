public interface TwoSideLinkedList<E> extends LinkedList<E> {
    boolean insertLast(E value);
    E getLast();
    E removeLast();
}
