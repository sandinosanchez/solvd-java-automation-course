package treeset;

public class TreeSet<T> {
    private Node<T> root;
    private Node<T> leftChild;

    public TreeSet() {
        root = null;
        leftChild = null;
    }

    public void add(T data) {
        Node<T> nodeToAdd = new Node<T>(data, null);
        if (root == null) {
            root = nodeToAdd;
        } else {
            addRecursive(nodeToAdd, root);
        }
    }

    public void addRecursive(Node<T> nodeToAdd, Node<T> current) {
        int order = current.compare(current.getData(), nodeToAdd.getData());
        if (order > 0) {
            if (current.getLeft() == null) {
                current.setLeft(nodeToAdd);
                nodeToAdd.setParent(current);
            } else {
                addRecursive(nodeToAdd, current.getLeft());
            }
        } else if (order < 0) {
            if (current.getRight() == null) {
                current.setRight(nodeToAdd);
                nodeToAdd.setParent(current);
            } else {
                addRecursive(nodeToAdd, current.getRight());
            }
        }
    }

    public void remove(T data) {
        deleteRecursive(data, root);
    }

    public Node<T> deleteRecursive(T data, Node<T> current) {
        if (current == null) return null;
        if (current.compare(current.getData(), data) > 0)
            current.setLeft(deleteRecursive(data, current.getLeft()));
        else if (current.compare(current.getData(), data) < 0)
            current.setRight(deleteRecursive(data, current.getRight()));
        else {
            if (current.getLeft() == null && current.getRight() == null)
                return null;
            else if (current.getLeft() == null)
                return current.getRight();
            else if (current.getRight() == null)
                return current.getLeft();
            else {
                current.setData(current.getLeft().getData());
                current.setRight(deleteRecursive(data, current.getRight()));
            }
        }
        return current;
    }

    public void reverse() {
        reverseRecursive(root);
    }
    
    public void reverseRecursive(Node<T> node) {
        if (node == null) return;
        Node<T> temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);

        reverseRecursive(node.getLeft());
        reverseRecursive(node.getRight());
    }

    public void ascendantOrder(StringBuilder result, Node<T> node){
        if (node == null) return;
        ascendantOrder(result, node.getLeft());
        result.append(node.getData().toString());
        result.append(",");
        ascendantOrder(result, node.getRight());
    }
    
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        ascendantOrder(result, root);
        return result.append("]").toString();
    }
    
    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }
    
   public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        
        tree.add(22);
        tree.add(21);
        tree.add(10);
        tree.add(2);
        tree.add(212);
        tree.add(102);
        tree.add(25);
        tree.add(27);
        tree.add(1);
        tree.add(28);
        tree.add(66);
        tree.add(43);

        System.out.println("TreeSet before removing element: 25 -> " + tree.toString());
        tree.remove(25);
        System.out.println("TreeSet after removing element: 25 -> " + tree.toString());
        tree.reverse();
        System.out.println("Reverse TreeSet: " + tree.toString());
    }
}
