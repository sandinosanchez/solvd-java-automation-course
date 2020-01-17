package linkedlist;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(Node<T> node) {
        this.head = node;
        this.tail = node;
    }

    public LinkedList() {
        head = new Node<T>();
        tail = head;
    }

    public int size() {
        Node<T> temp;
        int count = 1;
        if (head.equals(tail)) {
            return 1;
        } else {
            temp = head;
            while (temp.getNext() != null) {
                count++;
                temp = temp.getNext();
            }
        }
        return count;
    }

    public T get(int idx) {
        int cont = 0;
        for (T t : this) {
            if (cont == idx) {
                return t;
            }
            cont++;
        }
        return null;
    }
    public LinkedList<T> reverse() {
        LinkedList<T> reverse = new LinkedList<T>();
        ListIterator<T> itr = iterator();
        while (itr.hasPrevious()) {
            reverse.add(itr.previous());
        }
        return reverse;
    }

    public void remove(T dataToRemove) {
        Node<T> temp = head;
        while (temp.getNext() != null) {
            if (dataToRemove.equals(temp.getData())) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
            }
            temp = temp.getNext();
        }
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (Objects.isNull(head.getData())) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    public void add(int idx, T data) {
        Node<T> temp = head;
        int count = 0;
        while (Objects.nonNull(temp)) {
            if (count == idx) {
                Node<T> n = new Node<>(data);
                temp.getPrev().setNext(n);
                temp.setPrev(n);
                n.setPrev(temp.getPrev());
                n.setNext(temp);
                break;
            }
            temp = temp.getNext();
            count++;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public ListIterator<T> iterator() {
        return new GenericIterator<T>(head, tail);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> itr = iterator();
        while (itr.hasNext()) {
            result.append(itr.next().toString());
            if (itr.hasNext()) result.append(",");
        }
        return result.append("]").toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();

        myList.add(25);
        myList.add(55);
        myList.add(250);
        myList.add(55);
        myList.add(89);
        myList.add(88);
        myList.add(98);

        myList.add(5,10);
        myList.remove(89);
        myList.add(44);

        System.out.println("Normal List: " + myList.toString());
        System.out.println("Reverse List: " + myList.reverse().toString());
        System.out.println("Size List: " + myList.size());
    }
}
