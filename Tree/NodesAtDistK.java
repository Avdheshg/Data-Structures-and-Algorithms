public class NodesAtDistK {

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

        nodeAtK(root, 2);

    }

    public static void nodeAtK(Node root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
        }
        System.out.println("k = " + k);
        nodeAtK(root.left, k-1);

        nodeAtK(root.right, k-1);
    }



}




  

	// ===================
class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {

        this.data = data;
    }
}