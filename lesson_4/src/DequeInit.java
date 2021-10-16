public interface DequeInit<E> {

    boolean insertLeft(E number);
    boolean insertRight(E number);
    E removeLeft();
    E removeRight();
    E peekHead();
    E peekTail();
    boolean isEmply();
    boolean isFull();
    int size();
    void  display();

}
