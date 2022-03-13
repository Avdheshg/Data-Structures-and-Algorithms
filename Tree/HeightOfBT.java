	// ===================
class Node {

    int key;
    Node left;
    Node right;

    public Node(int key) {

        this.key = key;
    }
}

public class HeightOfBT {
    
    public static void main(String[] args) {
        Node root = new Node(10);

	    // left subtree
        root.left = new Node(8);

        // root.left.left = new Node(40);
        // root.left.right = new Node(50);

        // root.left.right.left = new Node(70);
        // root.left.right.right = new Node(80);

        // right subtree
        root.right = new Node(30);

        root.right.left = new Node(40);
        root.right.right = new Node(50);

        root.right.right.left = new Node(70);

        System.out.println("Height of BT: " + heightOfBt(root));
    }

    public static int heightOfBt(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfBt(root.left), heightOfBt(root.right));

    }


}






















