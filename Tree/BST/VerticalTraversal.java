import java.util.*;

public class VerticalTraversal {

    /*
        Naive: O(n2)

        The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root. 

        Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root, and for each vertical line traverse the tree and print the nodes which lie on that vertical line.

        Find the max and min hd values for a given tree
        Loop through this hd range, i
            for each i again TR the tree starting from root(which has hd=0) and print those nodes which during the iteration has hd equals to i
            
        Algo:
            V need a pair of min and max, So def a class "HDValues" which has min and max as insatnce var. Instead of defining a new class "HDValues" V can also make min and max as global var

            Method 1: findMinAndMax() : for finding the min and max values of hd for a given tree
                check for null => return
                check if current hd is less than global "min"
                    update the min
                check if current hd is greater than global "max"
                    update the max
                
                recur for left ST with hd-1
                recur for right ST with hd+1

            After finding the min and max hd for the given tree V need to loop in the range of hd and starting from the root print all those nodes whose hd becomes eqauls to the loop hd        

            Method 2: printVerticalLine(): for printing the hd nodes equal to "i" of the loop
                check for null => return
                check if the hd of given by the loop = hd of the tree
                    print the node
                recur for left ST with hd-1
                recur for right ST with hd+1

            Main function: will be called by main
                call method 1
                loop through the range of hd
                    for each iteration, call method 2 with "i" and "0" for the root (bcoz each time V need to start from the root)    

    */

    static HDValues val = new HDValues();
    // main function
    public static void verticalOrderNaive(Node root) {

        findMinMaxHD(root, val, val, 0);

        for (int lineNo = val.min; lineNo <= val.max; lineNo++) {
            printVerticalLine(root, lineNo, 0);
            System.out.print("For hd: " + lineNo + "\n");
        }

    }

    public static void findMinMaxHD(Node root, HDValues min, HDValues max, int hd) {
        if (root == null) {
            return;
        }

        if (hd < min.min) {
            min.min = hd;
        } else if (hd > max.max) {
            max.max = hd;
        }

        findMinMaxHD(root.left, min, max, hd-1);
        findMinMaxHD(root.right, min, max, hd+1);
    }

    public static void printVerticalLine(Node root, int lineNo, int hd) {
        if (root == null) {
            return;
        }
        
        if (lineNo == hd) {
            System.out.print(root.data + " ");
        }

        printVerticalLine(root.left, lineNo, hd-1);
        printVerticalLine(root.right, lineNo, hd+1);
    }




    /*  
    Efficient:
        Why can't V use any TR other than LeveOrder TR ?
            Bcoz V need to print all the nodes present at a particular hd from top to bottom i.e suppuse there is a node in the left ST of the root which has same hd as root then if V will use inOrder TR then that left node will be printed 1st which V don't want
            And LeveOrder TR takes care of left and right automatically. So all the topmost nodes present on the same hd will be printed first

            Now the main question is how do V maintain hd during LeveOrder TR ?
                V will add a pair(pair of node and it's hd) when adding into the Q during LeveOrder TR
            
        Algo:
            Def a new class "Pair" for adding a pair of hd and node into the Q
                This class will have 2 var, node and hd and a constructor
            
            Function:
                Def a Q which will hold elements of type class "Pair"
                Def a map of type Integer and AL
                (From here it is only LeveOrder TR and only need to care about the Q elements)
                add root and it's hd to the Q buy making it a new instance of class "Pair"

                Loop while q is not empty
                    Take out the ele(pair) from the Q (X)
                    Def 2 var which will hold the node address and hd of node extracted from X
                    
                    check if map contains hd
                        get the AL at hd and add the node to the hd
                    if not
                        Def a new AL at hd
                        add the node to AL
                        add AL to map at hd

                    check if left node of the curr node is not null
                        add the left node to the Q as a type of Pair
                    check if right node of the curr node is not null
                        add the right node to the Q as a type of Pair
    */




    public static void traversal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node currNode = curr.node;
            int hd = curr.hd;

            if (map.containsKey(hd)) {
                map.get(hd).add(currNode.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(currNode.data);
                map.put(hd, al);
            }

            if (currNode.left != null) {
                q.add(new Pair(currNode.left, hd-1));
            } 
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, hd+1));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> unit : map.entrySet()) {
            ArrayList<Integer> al = unit.getValue();
            System.out.print("For hd: " + unit.getKey() + ": " );
            for (int x: al) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    /*
        O()?
            Time: O(nlog(hd) + hd)
            Space: O(hd+n)
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
        // traversal(root);
        verticalOrderNaive(root);
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

class HDValues {
    int min, max;
}

class Pair {
    Node node;
    int hd;
    Pair(Node n, int h) {
        node = n;
        hd = h;
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
