import java.util.*;

public class TreeInSpiralForm {
    /*
        Q: will hold the next level
        stack: will hold the current level i.e if "isRev=true" then curr will be filled with the current level and when a null is encountered then all the elements will be printed in reverse order from the stack

        Algo:  O(n) || O(n) How the Time complexity is O(n)
            Normal level order
            if "isRev" is true then instead of printing add elements to the stack and if false then print them 
            In this algo V R doing extra work bcoz every item goes into the q and when "isRev" is true then those items also goes into the stack
    */
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        boolean isReverse = false;

        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr != null) {
                if (isReverse) {
                    stack.push(curr);
                } else {
                    System.out.print(curr.data + " ");
                }
                
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            } else {
                if (!q.isEmpty()) {

                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop().data + " ");
                    }

                    isReverse = !isReverse;
                    q.offer(null);
                }
            }
            System.out.println("==");
        }

        // Bcoz if the q is emoty and isRev=true then then loop will break but stack may have some elements left
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    /*
        Algo: define 2 stacks 
            TR until both stacks have some element left
            while traversing in non reverse order add elements to st2 and o/w in st1
    */
    public static void printInSpiral(Node root) {
        ArrayDeque<Node> stack1 = new ArrayDeque<>();
        ArrayDeque<Node> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                Node curr = stack1.pop();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    stack2.push(curr.left);
                }
                if (curr.right != null) {
                    stack2.push(curr.right);
                }
            }
            System.out.println();

            while (!stack2.isEmpty()) {
                Node curr = stack2.pop();
                System.out.print(curr.data + " ");
                if (curr.right != null) {
                    stack1.push(curr.right);
                }
                if (curr.left != null) {
                    stack1.push(curr.left);
                }
            }
            System.out.println();
        }
    } 


    public static void main(String[] args) {
        Node root = new Node(10);

        // left subtree
        root.left = new Node(20);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);

        // right subtree
        root.right = new Node(30);

        root.right.left = new Node(60);
        root.right.right = new Node(90);

        printInSpiral(root);
        // levelOrder(root);
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














