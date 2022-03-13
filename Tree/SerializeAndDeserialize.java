import java.util.*;

public class SerializeAndDeserialize {

    private static ArrayList<Integer> al = new ArrayList<>();
    private static int index = 0;

    // M-1: 
    /*
        Serialize: Save the Inorder and one of the other traversals of BT (preorder, postOrder, levelOrder)
        DeSerialize: Construct the tree from Inorder and one of the other traversal
    */

    public static void serialize(Node root, ArrayList<Integer> al) {
        /*  
            V R using PreOrder traversal
            Here the number of calls made will be O(n)
            Number of null will be n+1 , n=> number of nodes
            total AL size will be n + (n+1). n => for total nodes, n+1 for total nulls
        */

        if (root == null) {
            al.add(-1);
            return;
        }

        al.add(root.data);
        serialize(root.left, al);
        serialize(root.right, al);

    }

    /*
        check if the index == size of the al
        get the value of the index from al
        check the val
        Make the root node from the val
        call rec and connect it as left node
        call rec and connect it as right node
    */
    // public static Node deSerialize(ArrayList<Integer> al) {
    public static Node deSerialize(ArrayList<Integer> al, int i) {
        // if (index == al.size() ) {
        //     return null;
        // }

        // int val = al.get(index);
        // index++;

        // if (al.get(index) == -1) {
        //     return null;
        // }

        // // Build the root node
        // Node root = new Node(val);

        // root.left = deSerialize(al);
        // root.right = deSerialize(al);

        // return root;

        if (i == al.size() || al.get(i) == -1) {
            return null;
        }

        Node root = new Node(al.get(i));
        root.left = deSerialize(al, i++);
        root.right = deSerialize(al, i++);

        return root;
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

        serialize(root, al);

        System.out.println("Preorder serialzation of the tree: " + al);

        System.out.println("Deserialize Tree");

        Node newRoot = deSerialize(al, 0);

        printPreOrder(newRoot);
    }

    public static void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node (int data) {
        this.data = data;
    }
}

































