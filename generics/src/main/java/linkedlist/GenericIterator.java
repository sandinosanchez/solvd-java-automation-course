package linkedlist;

import java.util.ListIterator;
import java.util.Objects;

public class GenericIterator<T> implements ListIterator<T> {
    private Node<T> currentFromStart;
    private Node<T> currentFromEnd;

    public GenericIterator(Node<T> head, Node<T> tail) {
        this.currentFromStart = head;
        this.currentFromEnd = tail;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(currentFromStart);
    }

    @Override
    public T next() {
        Node<T> temp = currentFromStart;
        currentFromStart = currentFromStart.getNext();
        return temp.getData();
    }

    @Override
    public boolean hasPrevious() {
        return Objects.nonNull(currentFromEnd);
    }

    @Override
    public T previous() {
        Node<T> temp = currentFromEnd;
        currentFromEnd = currentFromEnd.getPrev();
        return temp.getData();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }

    public Node<T> getCurrentFromStart() {
        return currentFromStart;
    }

    public void setCurrentFromStart(Node<T> currentFromStart) {
        this.currentFromStart = currentFromStart;
    }

    public Node<T> getCurrentFromEnd() {
        return currentFromEnd;
    }

    public void setCurrentFromEnd(Node<T> currentFromEnd) {
        this.currentFromEnd = currentFromEnd;
    }
}
