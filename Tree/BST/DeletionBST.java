import java.util.*;

public class DeletionBST {

    /*
        https://www.techiedelight.com/deletion-from-bst/
        O(h) , O(n) worst case 
        || O(h)
        There are three possible cases to consider deleting a node from BST:
            Case 1: Deleting a node with no children: remove the node from the tree.
            Case 2: Deleting a node with two children: call the node to be deleted N. Do not delete N. Instead, choose either its inorder successor node or its inorder predecessor node, R. Copy the value of R to N, then recursively call delete on R until reaching one of the first two cases. If we choose the inorder successor of a node, as the right subtree is not NULL (our present case is a node with 2 children), then its inorder successor is a node with the least value in its right subtree, which will have at a maximum of 1 subtree, so deleting it would fall in one of the first 2 cases.
            Case 3: Deleting a node with one child: remove the node and replace it with its child.

        Algo:
            if root is null
            if root is > x
                recur and connect the returned res to the left of the curr root
            if root is < x
                recur and connect the returned res to the right of the curr root
            if root == x
                * if left child of the root is null => return the right child as a new root of this subtree
                * if right child is null => return the left child as a new root if this subtree
                The above 2 will handle for both, if root has a single child or it is a leaf node
                * if root has both the child
                    - get the inorder successor for the current root
                    - replace the val of the root with the successor
                    - delete the successor from the tree. How ?
                        call recursively for the deletion of the successor i.e in the recursive call pass the successor

    */
    public static Node delete(Node root, int x) {
        
        if (root == null) {
            return null;
        }

        if (root.data > x) {
            root.left = delete(root.left, x);
        } else if (root.data < x) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node succ = getSucc(root);
                root.data = succ.data;
                root.right = delete(root.right, succ.data);
            }
        }
        return root;
    }

    public static Node getSucc(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void iterative(Node root, int x) {

    }









    /*  
        Iterative: Problem in deleteRootNode()
        Find the node to be removed and its parent using binary search
        then use deleteRootNode to delete the root node of the subtree and return the new root node
    */
    // find the node to be deleted. This is similar to iterative insert
    public static Node deleteNode(Node root, int key) {
        Node cur = root;
        Node pre = null;
        while(cur != null && cur.data != key) {
            pre = cur;
            if (key < cur.data) {
                cur = cur.left;
            } else if (key > cur.data) {
                cur = cur.right;
            }
        }
        // if 1st node is the node to be deleted => delete the 1st node Or the root is null
        if (pre == null) {
            return deleteRootNode(cur);
        }
        // checking if the required node is present on the left or the right of the prev node. 
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }
    // delete the found node
    private static Node deleteRootNode(Node root) {
        if (root == null) {
            return null;
        }
        // if root is a leaf node or has a single child
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        
        // Now it is confirmed that root has 2 child
        Node next = root.right;
        Node pre = null;

        while (next.left != null) {
            pre = next;
            next = next.left;
        }
        next.left = root.left;

        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }

        return next;
    }




    















    















    

    
    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        printBST(root);

        // delete(root, 15);
        root = deleteNode(root, 15);
        System.out.println("\n===============================================");
        printBST(root);
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
