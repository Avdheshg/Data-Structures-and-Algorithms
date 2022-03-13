import java.util.*;

public class TopView {

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
    public static void verticalOrderNaive(Node root) {

        findMinMaxHD(root, val, val, 0);

        for (int lineNo = val.min; lineNo <= val.max; lineNo++) {
            boolean firstNode = false;
            printVerticalLine(root, lineNo, 0, firstNode);
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

    public static void printVerticalLine(Node root, int lineNo, int hd, boolean firstNode) {
        if (root == null) {
            return;
        }
        
        if (lineNo == hd) {
            if (!firstNode) {
                System.out.print(root.data + " ");
                firstNode = true;
            } else {
                return;
            }
        }

        printVerticalLine(root.left, lineNo, hd-1, firstNode);
        printVerticalLine(root.right, lineNo, hd+1, firstNode);
    }

    /*
        M-2:
        Level Order TR with hd
        Using Vertical TR = means = level order + hd 
            TR the tree with
    */
    
    public static void topView(Node root){
        Map<Integer,Integer> mp=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(root, 0));
        
        while (q.isEmpty() == false) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if(mp.containsKey(hd) == false){
                mp.put(hd, curr.data);
            }

            if(curr.left != null)
                q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right,hd+1));
        }

        for(Map.Entry<Integer,Integer> x:mp.entrySet()){
                System.out.print(x.getValue()+" ");
        }
    }

    /*
        M-3: Using preOrder + TreeMap : O(n) || O(Logn + hd). O(logn): for tree height in recursion call stack and O(hd): for TreeMap
    */
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static void topViewRec(Node root) {
        preOrder(root, 0);

        for (Map.Entry<Integer, Integer> x: map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
    public static void preOrder(Node root, int hd) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(hd)) {
            map.put(hd, root.data);
        }

        preOrder(root.left, hd-1);
        preOrder(root.right, hd+1);
    }

    
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(20);
        root.left.left = new Node(30);
        root.left.right = new Node(40);

        root.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        // root.right.right = new Node(80);

        // printBST(root);
        System.out.println("\n===========");
        // verticalOrderNaive(root);
        // topView(root);
        topViewRec(root);
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

class Pair {
    Node node;
    int hd;
    Pair (Node n, int h) {
        node = n;
        hd = h;
    }
}

class HDValues {
    int min, max;
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
    }
}




