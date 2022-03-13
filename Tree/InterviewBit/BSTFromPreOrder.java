import java.util.*;

public class BSTFromPreOrder {

    /*
    https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
        Naive:
            The first element of preorder traversal is always root.
            We first construct the root. 
            Then we find the index of the first element which is greater than the root. Let the index be "i". 
            The values between root and "i" will be part of the left subtree, and the values between ‘i'(inclusive) and "n-1" will be part of the right subtree. Divide given pre[] at index "i" and recur for left and right sub-trees.

        Algo:
            check if pIdx must not >= arr.length and low not > high
                if yes, return null
            Build the root from pIdx
            V can also add a case(to improve the algo that if the array has only 1 ele) then return the root
            find the index of the first greater element than root, i

            call for left with (pIdx, i-1) and connect the returned value as left child 
            calll for right with (i, high) and connect the returned value as right child 
    */
    static int pIdx = 0;
    static Node constructTreeUtil(int pre[], int low, int high) {
        // Base case
        if (pIdx >= pre.length || low > high) {
            return null;
        }

        Node root = new Node(pre[pIdx]);
        pIdx = pIdx + 1;
 
        // If the current subarray has only one element, no
        // need to recur
        if (low == high) {
            return root;
        }
 
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(pre, pIdx, i - 1);
        root.right = constructTreeUtil(pre, i, high);
 
        return root;
    }
    
    
    /*  
    Efficient: 
        https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
    */
    static int i = 0;
    public static Node bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public static Node bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) { 
            return null;
        }
        
        Node root = new Node(A[i++]);
        
        root.left = bstFromPreorder(A, root.data);
        root.right = bstFromPreorder(A, bound);
        
        return root;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{8,3,1,6,4,10};
        // int arr[] = new int[]{8,3,1,6,4,7,10,14,13};
        
        Node root = null;

        // root = constructTreeUtil(arr, 0, arr.length-1, arr.length);
        root = constructTreeUtil(arr, 0, arr.length-1);

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

