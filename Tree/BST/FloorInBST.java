import java.util.*;

public class FloorInBST {

    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        // printBST(root);
        Node floor = floor(root, 15);
        if (floor != null) {
            System.out.println("Floor: " + floor.data);
        } else{
            System.out.println("Not found");
        }
    }

    /*
        Floor: Closest smaller or equal val than the root. If this val is present then return it and if it is not present then return the largest val which is smaller than the given val and if there is no smaller val present then return null

        Naive sol:
            Traverse the tree using (Inorder or Preorder or Postorder) and keep track of closest smaller or same element. Time complexity of this solution is O(n) where n is total number of Nodes in BST.
            O(n) || O(h) (for both iterative and recursive) In case of iterative V will use a stack which will us O(h) space

        Efficient:  
            We can efficiently find closest smaller or same element in O(h) time where h is height of BST. It is based on simple BS of a tree
            Algorithm to find the floor of a key in a binary search tree (BST), it has 3 cases:
                1 Start at the root Node.
                2 If root == key, 
                    floor of the key is equal 
                    to the root.
                3 Else if root > key, then 
                    floor of the key must lie in the
                    left subtree.
                4 Else floor may lie in the right subtree 
                but only if there is a value lesser than 
                or equal to the key.If not, then root is
                the key. 

        O(h) || O(1)
    */
    public static Node floor(Node root, int x) {
        Node res = null;

        while (root != null) {
            if (root.data == x) {
                return root;
            } else if (root.data > x) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public static void printBST(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.add(null);
                }
            }
        }
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
    }
}

