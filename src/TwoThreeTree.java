// not working
// not used

public class TwoThreeTree <V extends Comparable> {
    Node root;

    class Node{
        V leftValue;
        V rightValue;
        Node leftNode;
        Node middleNode;
        Node rightNode;
        Node parent;

        public Node() {
        }

        public Node(V leftValue) {
            this.leftValue = leftValue;
        }

        public void insert(V newValue) {

            if (rightValue == null && noChilds()) { // single leaf node
                if (newValue.equals(leftValue)) {
                    return;
                }

                if (newValue.compareTo(leftValue) < 0) {
                    rightValue = leftValue;
                    leftValue = newValue;
                } else {
                    rightValue = newValue;
                }

                return;
            }


        }

        private boolean noChilds() {
            return leftNode == null || middleNode == null || rightNode == null;
        }
    }

    public void insert(V newValue) {
        if (root == null) {
            root = new Node(newValue);
            return;
        }
        root.insert(newValue);
    }

    public static void main(String[] args) {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();

        tree.insert(8);
        tree.insert(4);
        tree.insert(46);
    }
}
