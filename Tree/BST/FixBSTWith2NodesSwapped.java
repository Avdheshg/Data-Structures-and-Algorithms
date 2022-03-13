import java.util.*;

public class FixBSTWith2NodesSwapped {

    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(16);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(3);

        root.right.right = new Node(80);

        // printBST(root);
        // fixBST(root);
        // System.out.println("First: " + first.data + " second: " + second.data);

        findInArray(new int[]{4,60,10,20,8,80,100});
    }

    /*  
    GFG
        Method 1:
            The inorder traversal of a BST produces a sorted array. 
            So a simple method is to store inorder traversal of the input tree in an auxiliary array. 
            Sort the auxiliary array. 
            Finally, insert the auxiliary array elements back to the BST, keeping the structure of the BST same. 

            The time complexity: O(nLogn) and the auxiliary space: O(n).
    */

    /*
        This method is similar to the CheckBST sol.
        Idea: Do the InOrder TR, save it to an array and find the 2 nodes which can make the arr sorted

        We can solve this in O(n) time and with a single traversal of the given BST
        Since inorder traversal of BST is always a sorted array, the problem can be reduced to a problem where two elements of a sorted array are swapped.

        There are two cases that we need to handle:
            1. The swapped nodes are not adjacent in the inorder traversal of the BST.
            2. The swapped nodes are adjacent in the inorder traversal of BST.

        Now 1st V will solve for an array
    */

    /*
        Question: Finding the 2 nodes which can make the array sorted

        Algo: 
            Def 3 var, "prev", "first", "sec". "prev" for holding the prev ele of each ele, "first" and "sec" are for holding the 2 unordered ele
            TR the array
                check if arr[i] < prev i.e the current element is less than the prev ele
                    check "first" has set or not
                        set the "first" with "prev"
                    set the "sec" with arr[i] i.e current ele
                set prev to arr[i] so that for the next ele arr[i+1] "prev" will behave as the prev ele of arr[i+1]

        [4,60,10,20,8,80,100]
    */
    public static void findInArray(int arr[]) {
        int prev = Integer.MIN_VALUE, first = -1, second = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < prev) {
                if (first == -1) {
                    first = prev;
                }
                second = arr[i];
            }
            prev = arr[i];
        }
        System.out.println("First: " + first + " second: " + second);
    }

    /*
        Solution for Tree
        V will follow the array idea and do the inorder TR of the tree
        Why Inorder TR?
            Bcoz during ITR V TR in the sorted order
    */
    static Node prev = null, first = null, second = null;
    public static void fixBST(Node root) {
        if (root == null) return;

        fixBST(root.left);

        /*
            Here "prev != null" will save from 2 things
                1. V will not check for the left most node as this will be the 1st iteration of the function and for that node prev will be null
                2. V R accessing the data of prev node i.e "prev.data". V will get error if V don't use this
        */ 
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        fixBST(root.right);
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


