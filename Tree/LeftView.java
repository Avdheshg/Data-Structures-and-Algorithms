import java.util.*;

public class LeftView {

    //  ========= for Right View ===============
    private static Node lastNodeOfThisLevel = null;
    public static void rightViewIterative(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);
        // System.out.println(root.data);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr != null) {
                lastNodeOfThisLevel = curr;

              if (curr.left != null) {
                  q.offer(curr.left);
              }  
              if (curr.right != null) {
                  q.offer(curr.right);
              }
            } else {
                if (!q.isEmpty()) {

                    // Whatever operation V wan't to do here, that operation will miss the last iteration value bcoz, at last iteration "lastNodeOfThisLevel" will have the correct value but as the Q is now empty so it will not able to pass the above condition
                    System.out.println(lastNodeOfThisLevel.data);
                    q.offer(null);
                }
            }
        }
        System.out.println(lastNodeOfThisLevel.data);
    }

    // ======== For LEFT VIEW   ==============
    private static int maxLevel = 0;
    public static void leftViewRec(Node root) {
        if (root == null) {
            return;
        }
        printRec(root, 1);
    }
    public static void printRec(Node root, int level) {
        if (root == null) {
            return;
        }

        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }
        printRec(root.left, level+1);
        printRec(root.right, level+1);
    }



    public static void leftViewIterative(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);
        System.out.println(root.data);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr != null) {
              if (curr.left != null) {
                  q.offer(curr.left);
              }  
              if (curr.right != null) {
                  q.offer(curr.right);
              }
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.peek().data);
                    q.offer(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Node root = new Node(10);

        // left subtree
        root.left = new Node(20);
    
        root.left.left = new Node(40);
        root.left.right = new Node(50);
    
        // root.left.right.left = new Node(70);
        // root.left.right.right = new Node(80);
    
        // right subtree
        root.right = new Node(30);
    
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        root.right.right.right = new Node(3);

        root.right.right.right.left = new Node(9);

        System.out.println("Left view is: ");
        // leftViewRec(root);
        leftViewIterative(root);

        // System.out.println("Right view is: ");
        // rightViewIterative(root);
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






















