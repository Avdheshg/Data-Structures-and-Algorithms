import java.util.*;

public class DiameterOfBT {

    private static int dia = 0;
    /*
        Algo: O(n2)
            Find the dia for the root
                Dia for current root: 1 + leftHeight and rightHeight
            Dia for the left and right child 
            return the max among all(rootDia, leftDia, rightDia)
    */
    // public static int getDia(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int rootDia = 1 + height(root.left) + height(root.right);

    //     int leftDia = getDia(root.left);
    //     int rightDia = getDia(root.right);

    //     return Math.max(rootDia, Math.max(leftDia, rightDia));

    // }
    // public static int height(Node root) {
    //     if (root == null) return 0;

    //     return 1 + Math.max(height(root.left), height(root.right));
    // }

    // M-2: Using a HM: Not working
    // store the height of each node in HM and then while traversing in the naive solution get the height from the map and compute the diameter of the tree
    // static HashMap<Node, Integer> map = new HashMap<>();
    // public static int height(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int leftHt = height(root.left);
    //     int rightHt = height(root.right);

    //     int currHt = 1 + Math.max(leftHt, rightHt);
    //     map.put(root, currHt);
    //     return currHt;
    // }
    // public static int effi1(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     height(root);
    //     System.out.println("after height filled, map: " + map);

    //     int maxDia =  getDia(root);
    //     System.out.println("Max dia: " + maxDia);
    //     return maxDia;
    // }

    // public static int getDia(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int leftDia = getDia(root.left);
    //     int rightDia = getDia(root.right);

    //     return Math.max(map.get(root), Math.max(leftDia, rightDia));
    // }

    // M-3: Best sol
    static int res = 0;
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        res = Math.max(res, 1+lh+rh);

        return 1 + Math.max(lh, rh);
    }


    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
    
        root.left.left = new Node(8);
        root.left.right = new Node(5);
    
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
    
        // right subtree
        root.right = new Node(2);
    
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        // System.out.println("Max dia: " +  getDia(root));
        // System.out.println("Max dia: " +  effi1(root));
        System.out.println("Max dia: " +  height(root));
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


































