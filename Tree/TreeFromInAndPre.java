import java.util.*;

public class TreeFromInAndPre {

    /*
        V can contruct the tree from inOrder and preOrder/posrOrder only 
        Inorder:   left Root right
        PreOrder:  Root left right
        Idea:
            find the root from preOrder[]
            for this root find the left and right children from inOrder[]
        Algo:
            Def a IV pIdx = 0
            Method:
                check if iSt > iEnd
                    return null
                Build a node from pre[] with pIdx
                find the current node in inOr[], so that the current node can be connected to it's correct childs, i

                recur for left (with i-1) and connect the returned node as the left ST of curr node
                recur for right (with i+1) and connect the returned node as the right ST of the curr node
    */
    private static int preIdx = 0;
    public static Node cTree(int in[], int pre[], int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        Node root = new Node(pre[preIdx++]);

        int inIdx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.data) {
                inIdx = i;
                break;
            }
        }
        root.left = cTree(in, pre, inStart, inIdx-1);
        root.right = cTree(in, pre, inIdx+1, inEnd);

        return root;
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);


        // Queue<Node> q = new LinkedList();
        // q.offer(root);

        // while (!q.isEmpty()) {     
        //     Node newNode = q.poll();
        //     System.out.print(newNode.data + " " );

        //     if (newNode.left != null) {
        //         q.offer(root.left);
        //     }
        //     if (newNode.right != null) {
        //         q.offer(root.right);
        //     }
        // }

    }
    
    public static void main(String[] args) {
        
        int in[] = new int[]{40,20,60,50,70,10,80,100,30};
        int pre[] = new int[]{10,20,40,50,60,70,30,80,100};
        // int in[]={20,10,40,30,50};
    	// int pre[]={10,20,30,40,50};

        Node root = cTree(in, pre, 0, in.length-1);

        printTree(root);

    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
































