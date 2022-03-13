import java.util.*;

public class PairWithGivenSum {

    /*
        Method 1: Inorder TR + 2PA
            Time: O(n) => or precise, Theta(n)
            Space: O(n+h), (h) for the recursion call stack

        In this algo V R doing 2 steps:
            Finding the Inorder and saving it to an array
            Finding the pair

        This question is completely similar to "Finding sum" in searching Track. Only the DS used is different, there it is array and here it is trees 

    */
    public static void hasSumNaive(Node root, int sum) {
        ArrayList<Node> al = new ArrayList<>();

        findSorted(al, root);

        int low = 0, high = al.size()-1;

        for (Node x: al){
            System.out.print(x.data + " ");
        }
        System.out.println();
        
        while (low < high) {
            int cSum = al.get(low).data + al.get(high).data;

            if (cSum > sum) {
                high--;
            } else if (cSum < sum) {
                low++;
            } else {
                System.out.println("Sum found at: " + low + " and " + high);
                return;
            }
        }
        System.out.println("No sum found");
    }
    public static void findSorted(ArrayList<Node> al, Node root) {
        if (root == null) {
            return;
        }
        findSorted(al, root.left);
        al.add(root);
        findSorted(al, root.right);
    }

    /*
        Now V need to find an algo which will find the sum while TR the Tree. this will be O(n) and goes Theta(n) in worst case
    */
    static HashSet<Integer> set = new HashSet<>();
    public static boolean hasSumHashing(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (hasSumHashing(root.left, sum) == true) {
            return true;
        }
        if (set.contains(sum-root.data)) {
            System.out.println("Sum Found ");
            return true;
        } else {
            set.add(root.data);
        }

        return hasSumHashing(root.right, sum);
        
    }

    /*
        https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
        How to do this in O(n) time and O(logn) space

        M-3: V know that the height of BST is O(logn). So While traversing the node V can save it to the HS and if for the current node V R not able to find any such pair then V will remove the node from the HS
        By this way HS will have height as O(logn) which is the height of the Tree

        M-4: Tree to DLL
            Convert the Tree to LL, in place
            TR the LL and find the pair

            Here time: O(n): for TR the BST
            Space: O(logn): The auxiliary space is needed only for function call stack in recursive function convertBSTtoDLL(). Since given tree is balanced (height is O(Logn)), the number of functions in call stack will never be more than O(Logn).
            This sol will modify the BST
    */

    
    public static void main(String[] args) {
        Node root = new Node(15);

        root.left = new Node(5);
        root.left.left = new Node(3);

        root.right = new Node(20);

        root.right.left = new Node(18);
        root.right.left.left = new Node(16);

        root.right.right = new Node(80);

        // printBST(root);
        // hasSumNaive(root, 35);
        hasSumHashing(root, 35);
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
