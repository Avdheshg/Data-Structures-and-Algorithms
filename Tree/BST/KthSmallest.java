import java.util.*;

/*
    This can solved using
        - array
        - Linked list
        - Hashing
        - BST (this will be most efficient for finding the kth smallest)

    All 3 soltuions, 
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
*/

public class KthSmallest {

    /*  
    Approach 1: Recursive Inorder Traversal
        Time complexity : O(N)O(N) to build a traversal.
        Space complexity : O(N)O(N) to keep an inorder traversal.
        
        Algo: V will use inorder travesal and increment the count when V process the node
            def a count as a global var
            if curr is not null
                call for left
                increment the count
                if count == k, print the node
                call for right
        Why inorder traversal ?
            Bcoz V will only increment the count when V R processing the current node. If V will use any other TR like preOrder, V need to start incrementing the count from the root itself.
            And as BST is ordered according to smaller on left and larger on right, inorder will be good to use        

    */
    private static int count = 0;
    public static void naive(Node root, int k) {
        if (root != null) {
            naive(root.left, k);

            count++;
            if (count == k) {
                System.out.println("kth node is: " + root.data);
                return; // bcoz of this return statement, the time complexity becomes O(h+k) and if V will not use it then the time complexity will become O(n)
            }
            naive(root.right, k);
        }
        
    }

    /*
        Approach 2: Iterative Inorder Traversal

        Time complexity: O(H + k)O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H + kH+k elements, since before starting to pop out one has to go down to a leaf. This results in O(\log N + k)O(logN+k) for the balanced tree and O(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
        Space complexity: O(H)O(H) to keep the stack, where HH is a tree height. That makes O(N)O(N) in the worst case of the skewed tree, and O(\log N)O(logN) in the average case of the balanced tree.
    */
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
    
        while (true) {
          while (root != null) {
            stack.push(root);
            root = root.left;
          }
          root = stack.pop();
          if (--k == 0) return root.data;
          root = root.right;
        }
      }

    /*
        How can V imporve O() ?
            V can change the strucutre of the BST. This tree is ka Augmented BST
        
        The idea is to store the count of each node in the left subtree, "lcount". "lcount" means the count of nodes in the left subtree

        This algo is similar to the search function

        Efficient Algo:
            compare (lCount + 1) with k for each node
                if same, return root
                if greater, recur for the left subtree with some k
                if smaller, recur for right subtree with k as ( k - (lCount+1) )

    */
    // public static void efficient(Node root, int k) {
    //     if (root == null) return;

    //     if (root.lCount+1 == k) {
    //         return root;
    //     } else if (root.lCount + 1 > k) {
    //         efficient(root.left, k);
    //     } else {
    //         efficient(root.right, k-(lCount+1));
    //     }
    // }

    
    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        // printBST(root);
        naive(root, 5);
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

/*  // Definition for efficient algo
class Node {
    int data;
    Node left, right;
    int lCount;

    Node (int x) {
        data = x;
        lCount = 0;
    }
}

// insert function

public static Node insert(Node root, int x) {
    if (root == null) {
        return new Node(x);
    }
    if (root.data > x) {   // going left
        root.left = insert(root.left, x);
        root.lCount++;

    } else if (root.data < x) {    // going right
        root.right = insert(root.right, x);
    }
    return root;
}

*/

