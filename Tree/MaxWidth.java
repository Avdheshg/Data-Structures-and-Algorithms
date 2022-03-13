import java.util.*;

public class MaxWidth {
   
    public static int width(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int maxWidth = 1;
        q.offer(null);

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
                    maxWidth = Math.max(maxWidth, q.size());
                    System.out.println("Size of Q: " + q.size());
                    q.offer(null);
                }
            }
        }
        return maxWidth;
    }

     
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

        System.out.println("Max width: " + width(root));
        // System.out.println("Max width: " + mw(root));
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































