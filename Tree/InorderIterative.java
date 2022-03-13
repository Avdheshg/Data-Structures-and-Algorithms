import java.util.*;

public class InorderIterative {

    public static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();

        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);

	// left subtree
        root.left = new Node(20);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);

        // right subtree
        root.right = new Node(30);

        root.right.left = new Node(60);
        root.right.right = new Node(70);
   
        inorder(root);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node (int data) {
        this.data = data;
    }
}






