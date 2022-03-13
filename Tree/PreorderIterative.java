import java.util.*;

public class PreorderIterative {

    public static void preorder(Node root) {
        Stack<Node> stack = new Stack<>();

        // M-1: Move to the left most leaf then intentionally chnage the root to point to the right side of the node  
        //  O(n) || O(n) => 
        Node curr = root;        

        // while (curr != null || !stack.isEmpty()) {
        //     while (curr != null) {
        //         System.out.print(curr.data + " ");
        //         stack.push(curr);
        //         curr = curr.left;
        //     }

        //     curr = stack.pop();
        //     curr = curr.right;
        // }
        // just putting the right node will also work
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.right != null) {

                    stack.push(curr.right);
                }
                curr = curr.left;
            }

            curr = stack.pop();
            // curr = curr.right;
        }

        // M-2 : for every node push the right and left :   O(n) || O(n)
        // 1st push the right child then left becoz V wants the left child to be at the top of the stack
        // Node curr = root;
        // stack.push(root);

        // while (!stack.isEmpty()) {
        //     curr = stack.pop();
        //     System.out.print(curr.data + " ");

        //     if (curr.right != null) {
        //         stack.push(curr.right);
        //     }
        //     if (curr.left != null) {
        //         stack.push(curr.left);
        //     }
        // }

        // M-3: Space optimised: O(n) || O(h) => V R going to push only the left child

        // if (root == null) {
        //     return;
        // }
        
        // Node curr = root;
        // stack.push(curr);

        // while (!stack.isEmpty()) {

        //     while (curr != null) {
        //         System.out.print(curr.data + " ");

        //         if (curr.right != null) {
        //             stack.push(curr.right);
        //         }
        //         curr = curr.left;
        //     }

        //     // storing the right child || making the current node to point to the right child 
        //     curr = stack.pop();

        // }

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

        preorder(root);
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








