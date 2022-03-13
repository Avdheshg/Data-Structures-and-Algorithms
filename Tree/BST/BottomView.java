import java.util.*;

public class BottomView {

    /*
        M-1: Naive method of Vt TR of BT
            find the min and max val of hd for the given tree
            TR in the range of hd
                print all the node present at the current hd

        In the above algo V have added 1 boolean var which will only print the 1st Node at each level and at the 2nd node it will make the function return

        O(hd * n) or O(n2)
    */
    static HDValues val = new HDValues();
    // main function
    // static Node lastNode = null;    // V can do this question by using only this var but it is not working
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static void verticalOrderNaive(Node root) {

        findMinMaxHD(root, val, val, 0);

        for (int lineNo = val.min; lineNo <= val.max; lineNo++) {
            // lastNode = null;
            printVerticalLine(root, lineNo, 0);
            // System.out.print("For hd: " + lineNo );
            // System.out.println();
        }

        for (Map.Entry<Integer, Integer> x: map.entrySet()) {
            System.out.println("For " + x.getKey() + ": " +  x.getValue());
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
            // lastNode = root;
            // System.out.print(lastNode.data + " ");
            map.put(hd, root.data);
        }

        printVerticalLine(root.left, lineNo, hd-1);
        printVerticalLine(root.right, lineNo, hd+1);
    }

    /*
        Efficient:
        Level Order TR with hd
        Using Vertical TR = means = level order + hd 
            TR the tree with    
    */
    
    public static void bottomView(Node root){
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> mp=new TreeMap<>();
        q.add(new Pair(root, 0));

        while (q.isEmpty() == false) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // if(mp.containsKey(hd) == false)
                mp.put(hd, curr.data);
            if(curr.left != null)
                q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right,hd+1));
        }
        for(Map.Entry<Integer,Integer> x:mp.entrySet()){
                System.out.print(x.getValue()+" ");
        }
    }


    public static void main(String[] args) {
        // Node root = new Node(15);

        // root.left = new Node(5);
        // root.left.left = new Node(3);

        // root.right = new Node(20);

        // root.right.left = new Node(18);
        // root.right.left.left = new Node(16);

        // root.right.right = new Node(80);
        Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(30);  
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        printBST(root);
        System.out.println("\n========");
        // verticalOrderNaive(root);
        bottomView(root);
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
