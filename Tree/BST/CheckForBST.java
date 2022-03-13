import java.util.*;

public class CheckForBST {
    /*
        Naive Algo:
            For every node:
                Find max in left subtree 
                Find min in right subtree
                Check if the current node is greater than the max of the left subtree and greater than the min of right subtree

            Main function: 
                If root == null
                    return 1
                For the curr node, if left or the right subtree doesn't follow the BST property 
                    if left != null and left val of current root > root => return 0
                    if right != null and right val of current root < root => return 0
                
                If any of the left or right child of the current node doesn't follow BST property 
                    if left subtree returned 0 || right subtree returned 0 => return 0
                
                ow return 1

        O(n2) 
    */
    public static int naive(Node root) {
        if (root == null) {
            return 1;
        }
        if (root.left != null && maxVal(root.left) > root.data) {
            return 0;
        }
        if (root.right != null && minVal(root.right) < root.data) {
            return 0;
        }

        if (naive(root.left) == 0 || naive(root.right) == 0) {
            return 0;
        }
        return 1;
    }
    // maxVal
    public static int maxVal(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maxVal(root.left), maxVal(root.right)));
    }
    // minVal
    public static int minVal(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minVal(root.left), minVal(root.right)));
    }


    /*
        Efficient 1:
            Pass a range for every node
            For root, range is -inf to +inf
            For left child of a node, V change the upper bound as the node's values
            For right child of a node, V change the lower bound as the node's values

        Algo:
            For every node must follow the above logic and it's left and right subtree must follow also
        This is simple inorder TR => O(n)
    */
    public static boolean effiOne(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        return ((root.data > min && root.data < max) &&
                effiOne(root.left, min, root.data) && 
                effiOne(root.right, root.data, max));
        
    }
    
    public static void main(String[] args) {
        // Node root = new Node(15);

        // root.left = new Node(5);
        // root.left.left = new Node(3);

        // root.right = new Node(20);

        // root.right.left = new Node(18);
        // root.right.left.left = new Node(16);

        // root.right.right = new Node(80);

        Node root = new Node(20);

        root.left = new Node(8);

        root.right = new Node(30);

        root.right.left = new Node(18);
        root.right.left.left = new Node(35);

        // printBST(root);
        // int res = naive(root);
        // if (res == 1) {
        //     System.out.println("true");
        // } else {
        //     System.out.println("False");
        // }
        System.out.println("Is BST: " + effiOne(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
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


