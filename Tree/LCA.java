import java.util.*;

public class LCA {

    /*  Algo:   2 traversals (1 for left child and 1 for right) and O(n+n) space for 2 Al
            O(n) || O(n)
            Main function: this will call the sub function(findPath) for 2 times 
                1st time: for the n1 node and the findPath() will save the path to AL if it n1 is an descendant of the root node
                2nd time: for the 2nd node and the findPath() will save the path to AL if it is available as the child node of the current root
                
                if 1st and 2nd returns false => Both of the given node are not present in the tree of the given root

                but if present then V will iterate to both the paths and returns the last common node present in the both AL
            findPath(): This will call recursively itself for the left and right child
                this function will take the root, al(to save the path for the queried Node) and the queried Node
                it will save those nodes which are in the path of the queried Node, if the nodes are not in the path of the queried Node then it will remove them

                At the end either will return the complete path to the queried Node or will return false indicating that the queried Node is not present

        lcaNaive()
            * Define 2 Al
            * check if current node as root and all of it's descendants doesn't contains any one of the given nodes then return false 
            * If the above condition was not satisfied means both are present, then TR both AL and return the last common node

        findPath()
            * check if root is null
            * if current node is required node
            * add the current root in the AL
            * check if the descendants of the current node contains the required node
            * if not then remove the current root from the AL
            
    */

    public static Node lcaNaive(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (findPath(root, path1, n1) == false || findPath(root, path2, n2) == false) {
            return null;
        }

        System.out.println("Both path Al:");
        for (Node x: path1) {
            System.out.print(x.data + " ");
        }
        System.out.println();
        for (Node x: path2) {
            System.out.print(x.data + " ");
        }

        Node lcaNode = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                lcaNode = path1.get(i);
            }
        }

        return lcaNode;
    }
    public static boolean findPath(Node root, ArrayList<Node> path, int n) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        if (findPath(root.left, path, n) == true || findPath(root.right, path, n) == true) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    /*
        Algo: Mathod 2: this algo assumes that both the keys are present if not(anyone of them is absent) then it will return the the key which is present => here it needs to return null saying that the both the keys are not present
        
            It has 4 cases
                c1: current node is the node which is equal to either of the keys 
                    => return the node
                c2: current node is the node which has both the keys on the left and right
                    => only 1 node will fall in this condition and that is the answer
                c3: both left and right are present on either left or on right of the current node
                    => return that side which contains both nodes
                c4: both are not present

    */
    public static Node efficient(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // c1
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node hasOnLeft = efficient(root.left, n1, n2);
        Node hasOnRight = efficient(root.right, n1, n2);

        // c2
        if (hasOnLeft != null && hasOnRight != null) {
            return root;
        }

        // c3 and c4: If both are present on 1 side then that side will be returned and if both are not present then other side will be returned 
        if (hasOnLeft != null) {
            return hasOnLeft;
        }
        else {
            return hasOnRight;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        // left subtree
        root.left = new Node(20);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);

        // right subtree
        root.right = new Node(30);

        root.right.left = new Node(60);
        root.right.right = new Node(90);  

        // Node firstCommon = lcaNaive(root, 30, 90);
        // System.out.println("FirstCommon: " + firstCommon.data);
        
        // Node firstCommon = efficient(root, 30, 90);
        // Node firstCommon = efficient(root, 70, 90);
        // Node firstCommon = efficient(root, 60, 90);
        Node firstCommon = efficient(root, 20, 80);
        System.out.println("FirstCommon: " + firstCommon.data);

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
