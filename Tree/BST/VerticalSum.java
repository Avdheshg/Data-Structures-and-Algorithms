import java.util.*;

public class VerticalSum {

    /*
    Naive
        O(n*n):
            O(n): for TR bw the range of hd
            O(n): for each hd V R TR the whole tree
    */
    static int min = 0, max = 0, vtSum = 0;
    public static void vtSumNaive(Node root) {
        if (root == null) {
            return;
        }

        getMinMax(root, 0);

        System.out.println("Min: " + min + " max: " + max);

        for (int lineNo=min; lineNo <= max; lineNo++) {
            vtSum = 0;
            printNodes(root, lineNo, 0);
            System.out.println("For hd: " +  lineNo + " vtSum: " + vtSum);
        }
    }

    public static void getMinMax(Node root, int hd) {
        if (root == null) {
            return;
        }
        min = Math.min(min, hd);
        max = Math.max(max, hd);

        getMinMax(root.left, hd-1);
        getMinMax(root.right, hd+1);
    }

    public static void printNodes(Node root, int lineNo, int hd) {
        if (root == null) {
            return;
        }
        if (lineNo == hd) {
            vtSum += root.data;
        }

        printNodes(root.left, lineNo, hd-1);
        printNodes(root.right, lineNo, hd+1);
    }


    /*
    Efficient:
        Nodes which R on the same Vt line means that their Hz distance from the root is same

        We need to check the Horizontal Distances from the root for all nodes. 
        If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line. 
        The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance

        V shouldn't be using HM. Why?
            Bcoz V need to print the sum values from left to right fashion as they appear when V print in the tree. 
            So instead of HM V will use TS bcoz they store the values in sorted order(according to keys) as they R self balancing BSTs 
    */
    public static void sum(Node root) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        buildMap(tm, root, 0);

        for (Map.Entry<Integer, Integer> x: tm.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
    public static void buildMap(TreeMap<Integer, Integer> tm, Node root, int hd) {
        if (root == null) {
            return;
        }
        buildMap(tm, root.left, hd-1);

        // Find the vSum and add it to TM
        int vSum = tm.get(hd) == null ? 0 : tm.get(hd);
        tm.put(hd, vSum + root.data);

        buildMap(tm, root.right, hd+1);

    }
    /*
        O()?
            Time: O(nlog(hd) + hd)
                o(n) => for TR
                For each node V R finding it into the TM and finding in TM costs, log(n) time. Here TM will contain total items equlas to "hd" i.e if hd is from -3 to 2 then TM will have 6 entries.
                O(hd) for printing the TM

            Space: O(hd)
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
        // sum(root);
        vtSumNaive(root);
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
