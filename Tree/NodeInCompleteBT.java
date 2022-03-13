public class NodeInCompleteBT {

    // naive: Simple counting
    public static int naive(Node root) {
        if (root == null) {
            return 0;
        }

        return naive(root.left) + naive(root.right) + 1;
    }

    //  efficient
    /*
        this works similar to BS
        if the left and right height of the tree is same => it is a complete BT and V can count the total nodes in it and can ignore it and go to the other side 
    */
    public static int efficient(Node root) {
        if (root == null) {
            return 0;
        }

        Node curr = root;
        int leftHt = 0;

        while (curr != null) {
            leftHt++;
            curr = curr.left;
        }

        curr = root;
        int rtHt = 0;

        while (curr != null) {
            rtHt++;
            curr = curr.right;
        }

        if (leftHt == rtHt) {
            return (int)Math.pow(2, leftHt) - 1;
        }

        return efficient(root.left) + efficient(root.right) + 1;
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

        // System.out.println("Total nodes: " + naive(root));
        System.out.println("Total nodes: " + efficient(root));
    }

}
