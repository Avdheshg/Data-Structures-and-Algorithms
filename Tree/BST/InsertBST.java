/*
import java.util.*;

public class InsertBST {

    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

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
        
        System.out.println("\n=============== ");
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

*/

import java.util.*;

public class InsertBST {

    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        // insertRec(root, 10);
        insertIterative(root, 19);
        printBST(root);
    }

    /*
        Insertion only happens at the bottom of the tree
        Base cases:     
            if the node to be inserted is already present => return the root
            if tree is empty => def a new node and return it
            
        Algo Recursive:   
            Find the position and insert the node

    */
    
    public static Node insertRec(Node root, int data) {
        // Recursive : // O(h) || O(h)
        if (root == null) {
            return new Node(data);
        }
        // if (root.data == data) {
        //     return root;
        // }
        else if (root.data > data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }

        return root;
        // this statement will handle the case when the node to be inserted is equal to the root itself

    }

    /*
        
        Def 2 nodes, "par" and "curr"
        After finding the correct pos of the node "par" will hold the ref to the node at which V will attach the new child and "curr" will hold the curr node for curr iteration
        After the end of the loop, V will be having 2 conditions
            Either the tree is empty
            or V have found the correct pos for the node
        
        Algo:
            Loop through the tree
                update par 
                Decide where to go (left or right)
            check if the tree is empty
            if not, then attach the required node to it's correct position
    */
    public static Node insertIterative(Node root, int data) {
        Node temp = new Node(data);
        Node par = null, curr = root;

        while (curr != null) {
            par = curr;
            
            if (curr.data > data) {
                curr = curr.left;
            } else if (curr.data < data) {
                curr = curr.right;
            } else {
                // This means that a node with the same value as data is already present
                return root;
            }
        }

        if (par == null) {
            return temp;
            // this will handle the case when tree is empty as the code will not go into loop
        }
        if (par.data > data) {
            par.left = temp;
        } else {
            par.right = temp;
        }
        return root;
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