public class ChildernSumProperty {
    
    public static void main(String[] args) {
        Node root = new Node(20);

        // left subtree
        root.left = new Node(8);
    
        root.left.left = new Node(3);
        root.left.right = new Node(5);
    
        root.left.right.left = new Node(2);
        root.left.right.right = new Node(3);
    
        // right subtree
        root.right = new Node(12);
    
        root.right.left = new Node(6);
        root.right.right = new Node(6);

        System.out.println("Does follow: " + doesFollow(root));
    }

    public static boolean doesFollow(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean isLeft = doesFollow(root.left);
        boolean isRight = doesFollow(root.right);

        // int leftData = 0, rightData = 0;
        int sum = 0;

        // V need to use these if to check for a root which have only 1 child, either left or right
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        
        boolean res =  ( (root.data == sum) && isLeft && isRight );
        System.out.println("Follows for, " + root.data + " : " + res);
        return res;
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
















