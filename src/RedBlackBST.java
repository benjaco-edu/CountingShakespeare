public class RedBlackBST<Key extends Comparable, Val> {
    public Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class KeyValue {
        Key key;
        Val val;

        public KeyValue(Key key, Val val) {
            this.key = key;
            this.val = val;
        }
    }

    class Node {
        Key key;
        Val val;
        Node left;
        Node right;
        boolean color;

        public Node(Key key, Val val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    public Val get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void insert(Key key, Val val) {
        root = put(root, key, val);
    }

    private Node put(Node h, Key key, Val val) {
        if (h == null) return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }


    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print("X" + node.val + " " + node.key + ", ");

        /* now recur on right child */
        printInorder(node.right);
    }

}
