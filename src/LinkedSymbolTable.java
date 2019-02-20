import java.util.Iterator;

class LinkedSymbolTable<V> implements Iterable<V> {

    private Node first;
    private Node last;

    private class Node {
        V val;
        Node next;

        Node(V val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void add(V value) {
        if (last == null) {
            first = last = new Node(value, null);
        } else {
            Node newNode = new Node(value, null);
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<V> {
        private Node currentNode;

        public ArrayIterator() {
            this.currentNode = first;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public V next() {
            Node returnedNode = currentNode;
            currentNode = currentNode.next;
            return returnedNode.val;
        }
    }
}