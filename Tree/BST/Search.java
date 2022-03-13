import java.util.*;

public class Search {

    public static void main(String[] args) {

        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        printBST(root);
    }

    /*
        Search is similar to BS
        O(h) || O(h) for recursion
        if skew tree : Time: O(n)
    */
    public static Node searchBST(Node root, int data) {

        // REcursive
        // if (root == null) {
        //     return null;
        // }
        // if (root.data == data) {
        //     return root;
        // } else if (root.data > data) {
        //     return searchBST(root.left, data);
        // } else {
        //     return searchBST(root.right, data);
        // }

        // Iterative
        while (root != null ) {
            if (root.data == data) {
                return root;
            } else if (root.data > data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;

    }

    public static void printBST(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.add(null);
                }
            }
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
    }
}
