import java.util.*;

public class CeilingInBST {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(5);
        // root.left.left = new Node(3);

        root.right = new Node(15);

        root.right.left = new Node(12);
        root.right.left.left = new Node(30);

        // root.right.right = new Node(80);

        // printBST(root);
        Node ceil = ceil(root, 40);

        if (ceil != null) {
            System.out.println("Ceil: " + ceil.data);
        } else {
            System.out.println("Not found");
        }
    }

    /*  
        Ceil: Node with the smallest data larger than or equal to the key value

        Naive: O(n): Use any traversal and find the required Node

        Efficient: O(h) || O(1)
    */
    public static Node ceil(Node root, int x) {
        Node par = null;

        while (root != null) {
            if (root.data == x) {
                return root;
            } else if (root.data > x) {
                par = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return par;
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


