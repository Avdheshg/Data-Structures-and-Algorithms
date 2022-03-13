import java.util.*;

public class SumRootToLeaf  {

    public static void main(String[] args) {
        Node root = new Node(3);

        root.left = new Node(1);
        // root.left.left = new Node(3);

        root.right = new Node(6);

        root.right.left = new Node(4);
        // root.right.left.left = new Node(16);

        // root.right.right = new Node(80);

        printBST(root);
        System.out.println("\n======");
        rootToLeaf(root);
    }

    /*
        Idea: 
            The idea is to do a preorder traversal of the tree. 
            In the preorder traversal, keep track of the value calculated till the current node, let this value be val. 
            For every node, we update the val as val*10 plus node’s data. 

        Algo:
            check for null => return 0
            calculate the val = sum * 10 + root
            check for leaf node

            call left and save it
            call right and save it

            return left + right

        Time Complexity: O(n): The above code is a simple preorder traversal code which visits every exactly once. Therefore, the time complexity is O(n) where n is the number of nodes in the given binary tree.

    */
    public static void rootToLeaf(Node root) {
        System.out.println(sum(root, 0));
    }
    public static int sum(Node root, int sum) {
        if (root == null) {
            return 0;
        }

        int val = sum * 10 + root.data;
        System.out.println("root: " + root.data + " val: " + val);

        if (root.left == null && root.right == null) {
            return val;
        }

        int left = sum(root.left, val);
        int right = sum(root.right, val);

        return left + right;
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
