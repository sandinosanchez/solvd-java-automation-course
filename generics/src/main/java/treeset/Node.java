package treeset;

import java.util.Comparator;

public class Node<T> implements Comparator<T> {
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private boolean visited;
    private T data;

    public Node() {
        this.left = null;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }


    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int compare(T t, T t1) {
        Integer tToInteger = (Integer) t;
        Integer t1ToInteger = (Integer) t1;
        return tToInteger.compareTo(t1ToInteger);
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
