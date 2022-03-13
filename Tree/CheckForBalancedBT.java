import java.util.*;

public class CheckForBalancedBT {
    
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
    
        root.left.left = new Node(3);
        root.left.right = new Node(5);
    
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
    
        // right subtree
        root.right = new Node(2);
    
        root.right.left = new Node(1);
        root.right.right = new Node(2);

        // System.out.println("Tree is Balanced: " + naive(root));
        System.out.println("Tree is Balanced ");
        int height = efficient(root);
        if (height >= 0) {
            System.out.println("Balanced: True" );
        } else {
            System.out.println("Balanced: False" );
        }
    }

    // HashMap<Node, Boolean> map = new HashMap<>();
    // public static void makeHeight(Node root) {
    //     if (root == null) {
    //         return ;
    //     }
        
    // }

    // public static boolean isBalanced(Node root) {

    // }

    // ========= Naive
    public static boolean naive(Node root) {
        if (root == null) {
            return true;
        }

        int leftHt = getHeight(root.left);
        int rightHt = getHeight(root.right);

        return ( (Math.abs(leftHt-rightHt) <= 1) && 
                naive(root.left) &&
                (naive(root.right)) );
    }
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // ================ Efficient
    /*
        In the naive sol the only thing that is increasing the O() is that V R calling the height function for each node
        To reduce the O() V need to find a way of defined a function which will tell us that the current node is balanced or not but also tell the height of current node 
        Algo:
            call left
            call right
            check if this node is not balanced. It can be checked by 2 conditions
                1. left or right ht =-1
                2. diff b/w left and right > 1
            if current node is balanced than return the height of the current node

            In a Nutshell: write the normal height function and add conditions of current node id balanced or not to it

    */
    public static int efficient(Node root) {
        if (root == null) {
            return 0;
        }

        int left = efficient(root.left);
        int right = efficient(root.right);

        // conditions checking for the current node is balanced or not
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left-right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

























