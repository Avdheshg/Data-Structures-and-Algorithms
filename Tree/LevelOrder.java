import java.util.*;

public class LevelOrder {
    
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

        // naiveLevelOrder(root);
        effLevelOrder(root);
    }

    public static void effLevelOrder(Node root) {

        // M-1
        // Queue<Node> q = new LinkedList<>();

        // q.offer(root);
        // q.offer(null);

        // while (!q.isEmpty()) {
        //     Node curr = q.poll();

        //     if (curr != null) {
        //         System.out.print(curr.data + " ");

        //         if (curr.left != null) {
        //             q.offer(curr.left);
        //         }
        //         if (curr.right != null) {
        //             q.offer(curr.right);
        //         }
        //     } 
        //     else {
        //         if (!q.isEmpty()) {
        //             q.offer(null);
        //             // curr
        //             System.out.println();
        //         }
        //     }
        // }

        // M-2: Using while and a for loop 
        // List<List<Integer>> main = new ArrayList<>();
        // ArrayList<Integer> subList = new ArrayList<>();
        
        // if (root == null) {
        //     return ;
        // }
        
        // Queue<Node> queue = new LinkedList<>();
        // queue.offer(root);
        
        // while (!queue.isEmpty()) {
        //     int currSizeOfQ = queue.size();
            
        //     for (int i = 0; i < currSizeOfQ; i++) {
        //         Node curr = queue.poll();
                
        //         System.out.print(curr.val + " ");
        //         subList.add(curr.val);
                
        //         if (curr.left != null) {
        //             queue.offer(curr.left);
        //         }
        //         if (curr.right != null) {
        //             queue.offer(curr.right);
        //         }
        //     }
        //     System.out.println();
        //     main.add(subList);
        //     subList = new ArrayList<>();
        // }
        
        // return main;

    }

    public static void naiveLevelOrder(Node root) {

        int height = getHeight(root);
        System.out.println("Total height of the tree: " + height);

        for (int i = 0; i <= height; i++) {
            printNodeAtK(root, i);
            System.out.println();
        }

    }

    public static void printNodeAtK(Node root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
        }

        printNodeAtK(root.left, k-1);
        printNodeAtK(root.right, k-1);
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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
