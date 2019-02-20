class LinkedSymbolTable<K,V> {

    //What is a Node?: https://docs.oracle.com/javase/7/docs/api/org/w3c/dom/Node.html
    // http://www.cs.williams.edu/JavaStructures/doc/structure5/structure5/Node.html
    // A class supporting a singly linked list element. Each element contains a value and maintains a single reference to the next node in the list.

    private Node first;

    private class Node {

        K word;
        V val;
        Node next;

        Node(K key, V val, Node next) {
            this.word = key;
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return word + " - " + val;
        }

    }

    public void put(K word, V val) {
        for (Node x = first; x != null; x = x.next)
        {
            if (word.equals(x.word))
            {
                x.val = val;
                return;
            }
        }
        first = new Node(word, val, first);
    }

    public V get(K word) {
        for (Node x = first; x != null; x = x.next) {
            if (word.equals(x.word)) {
                return x.val;
            }
        }
        return null;
    }

    public boolean contains(K word){
        return get(word) != null;
    }

    public void print(){
        for(Node x = first; x != null; x = x.next){
            System.out.println(x.toString());
        }
    }
}
