import java.util.*;

public class BSTIterator {

    /*
    https://www.youtube.com/watch?v=D2jMcmxU4bs
        M-1: Usign an Al
        M-2: Stack:
            Whenever asked for O(h) space complexity, V will use recursion and before processing the nodes V will save to the stack and after node is processed V will remove it from the stack => this way the O() of the question will remain O(h)
        
        M-3: Augmented BST
            In each node define a IV for storing the address of the next node
    */

    /*
    M-1: Using an Al
        Algo: 
            Define an Al, a var, pIdx, which will point to the next element

            Inside the constructor:
                initialise the AL
                Do the inOrder TR of Tree and save it into the Al

            next():
                get the ele present at pIdx
                Update pIdx
                return the ele
        O(n) || O(n) 
        next(): O(1)       

    */
    ArrayList<Integer> al;
    int pIdx = 0;
    
    public BSTIterator(Node root) {
        al = new ArrayList<>();
        inOrder(root);
    }
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        
        al.add(root.data);
        
        inOrder(root.right);
    }
    
    public int next() {
        int ans = al.get(pIdx++);
        return ans;
    }
    
    public boolean hasNext() {
        return !(pIdx == al.size());
    }

    /*
    M-2: Using the stack
        Each time V will insert the whole subtree of the current root, by this way V will be able to store only the O(h) elements
        
        Algo:
            Def a stack

            Constructor():
                initialize the stack
                call pushAll(root), for pushing all the nodes of the left ST of the current node

            next():
                pop from the stack, "ans"
                call pushAll(root.right). Why root.right ?
                    Bcoz as V R doing InOrder TR so that each time V will get the next smaller element and for doing that V also need to check if the current root has a right child or not
                    When V call for the right child the pushAll() will push all the elements present in the left ST of the right child (in increasing order)
                    By this way our stack wlll remain sorted, 
                    This logic is similar to the Iteration Inorder TR 

    */
    Stack<Node> stack;
    public BSTIterator(Node root) {
        stack = new Stack<>();
        pushAll(root);
    }
    public void pushAll(Node root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        Node ans = stack.pop();
        pushAll(ans.right);
        return ans.data;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class Node {
    Node left, right;
    int data;
    Node (int d) {
        data = d;
    }
}

