import java.util.*;

public class minDepthOfBT {

    /*  This is not just a simple opposite of question "finding max depth of BT". Although in the end V return the min but it has 3 important base cases for which changing the solution  of "finding max depth of BT" from "max" to "min" wil not work. Taking the min of both left and right calls will only work if the current node has both the children present

    The minimum depth means the number of nodes along the shortest path from the root node down to the nearest leaf node.
    minimum depth means finding the 1st leaf node or closest leaf node

    M-1: Simple recursion of Tree
    Base cases:
        1. if the root == null
        2. if root is the leaf
        3. if the tree is skewed BT (either left skewed or right skewed)
        4. if root has both the childrens

    Algo:
        check for null 
            return 0

        check for leaf
            return 1 => it means that V have counted the curr node in the sum
        check for skewed tree
            left skewed tree => means has no right side
                add the curr node into the sum and call for the left side and return
            right skewed tree => means has no left side
                add the curr node into the sum and call for the right side and return
        
        V R here means that the current node is not leaf, not a skewed tree => take the min and max of both left and right calls

    O(n) || O(h or n)

    */
    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /*
        M-2: Using Level order TR 
        Idea: When V find the 1st leaf node => return the depth value maintained throughout

        Algo: Simple Level Order TR
            Here the only changes are:
                1. Maintain a maxDepth var
                2. Check for leaf node
    */
    public static int levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int maxDepth = 1;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr != null) {
                if (curr.left == null && curr.right == null) {
                    return maxDepth;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            } else {
                if (!q.isEmpty()) {
                    maxDepth++;
                    q.add(null);
                }
            }
        }
        return maxDepth;
    }
    

    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        printBST(root);
        // System.out.println(minDepth(root));
        System.out.println(levelOrder(root));
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
        System.out.println("\n=============== ");
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
