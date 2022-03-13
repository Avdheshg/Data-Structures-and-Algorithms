public class SizeOfBT {
    
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

        System.out.println("Size: " + size(root));
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
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
