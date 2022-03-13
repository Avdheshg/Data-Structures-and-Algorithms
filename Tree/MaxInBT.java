public class MaxInBT {
    
    public static void main(String[] args) {
        Node root = new Node(110);

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

        System.out.println("Max: " + findMax(root));
    }

    public static int findMax(Node root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // int max1 = findMax(root.left);
        // int max2 = findMax(root.right);

        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
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
