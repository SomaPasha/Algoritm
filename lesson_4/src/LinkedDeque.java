public class LinkedDeque<E> implements DequeInit<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedDeque() {
        this.data = new TwoSideLinkedListImp<>();
    }

    @Override
    public boolean insertLeft(E number) {
        return data.insertFirst(number);
    }

    @Override
    public boolean insertRight(E number) {
        return data.insertLast(number);
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public E peekHead() {
        return data.getFirst();
    }

    @Override
    public E peekTail() {
        return data.getLast();
    }

    @Override
    public boolean isEmply() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void display() {
    data.display();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" +
                "data=" + data +
                '}';
    }
}
