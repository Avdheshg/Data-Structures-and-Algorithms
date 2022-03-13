import java.util.*;

public class validPreOrderArray {
    /*
    https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
    
        Method 1 ( O(n2) time complexity ) 
            The first element of preorder traversal is always root. We first construct the root. Then we find the index of the first element which is greater than the root. Let the index be "i". The values between root and "i" will be part of the left subtree, and the values between ‘i'(inclusive) and ‘n-1’ will be part of the right subtree. Divide given pre[] at index "i" and recur for left and right sub-trees.
            
            Find the first greater value on right side of current node. 
                Let the index of this node be j
            Return true if following conditions hold true:
                    (i)  All values after the above found greater value are 
                        greater than current node.
                    (ii) Recursive calls for the subarrays pre[i+1..j-1] and 
                        pre[j+1..n-1] also return true.

    */
    static int pIdxNaive = 0;
    public static boolean naive(int arr[], int min, int max) {
        // int currNode = arr[pIdxNaive++];

        int i = min;
        for (; i <= max; i++) {
            if (arr[i] > arr[pIdxNaive]) {
                break;
            }
        }

        boolean hasAllGreater = true;

        for (int j = i; j <= max; j++) {
            if (arr[j] < arr[pIdxNaive]) {
                hasAllGreater = false;
            }
        }
        pIdxNaive++;

        return hasAllGreater && naive(arr, min, i-1) && naive(arr, i+1, max);
    }

    /*
    Efficient 1: O(n) || O(h or n): 
        Algo:
            Def a stack and a "root" var = -infi
            Loop the arr
                check if root > arr[i] i.e is there any element in the left ST including the root is greater any node present in the right ST
                    return false
                
                loop through the stack until st != empty and peek < arr[i]
                    pop and save to the "root"
                
                add current ele, arr[i] to the stack

        Logic: 
            In this algo when V go into the left side of the root, 
                V insert nodes(all left ST nodes and root node) into the stack
                When V R going into the left side only c-3 will execute
            When V go to the right side of the node
                V pop all the elements present into the stack
                These R the elements which were present in the left ST of root(including the root)
                V hold the root of the tree into a var "root" (X)
                When V go to the right only c-2 and c-3 will execute

            According to BST property, left < root < right. If V R going into the right and V have hold the root, if V find that the "root" > curr element of the right ST then V return false. This is c-1

    */
    public int efficient1(ArrayList<Integer> al) {

        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < al.size(); i++) {

            // Condition 1
            if (al.get(i) < root) {
                return 0;
            }

            // C-2
            while (!st.isEmpty() && st.peek() < al.get(i)) {
                root = st.pop();
            }
            // C-3
            st.push(al.get(i));
        }

        return 1;
    }

    /*
    Most Efficient: O(n) || O(1)
        Similar to the efficient algo of validating a BST.
        Here V will TR the BST with min and max values for each node and if V see voilation of BST property at that point V will not increment pIdx and in this way V have not TR the whole array. By this V will conclude that the given array is not correct repreentation of preOrder TR of a BST 
    Algo:
        Main function:
            for the given array call the helper
        Helper:
            check if pIdx in less than length of array, if not then return 

            check if the current element at idx(i.e considering current [pIdx] as root of new BST), pIdx lies between min and max
                if yes, save the val if [pIdx] into a var "root"
                call for left with (min, root)
                call for right with (root, max)
    */
    static int pIdx = 0;
    public static boolean efficient2(int preOrder[]) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        validPreOrder(preOrder, min, max);

        return pIdx == preOrder.length;
    }

    public static void validPreOrder(int preOrder[], int min, int max) {
        if (pIdx >= preOrder.length) {
            return;
        }

        if (min < preOrder[pIdx] && preOrder[pIdx] < max ) {
            int root = preOrder[pIdx++];

            validPreOrder(preOrder, min, root);
            validPreOrder(preOrder, root, max);
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{8,3,1,6,4,10};
        // int arr[] = new int[]{8,3,1,6,2,10};
        // int arr[] = new int[]{8,3,1,6,4,7,10,14,13};

        // System.out.println(efficient2(arr));
        System.out.println(naive(arr, 0, arr.length-1));
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
