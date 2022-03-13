public class Tree2DLL {

    /*
        here prev = left child and root.left=root.prev   root.right=root.next
        Here "prev" holds the tail of the build LL
        
        A concept of recursion: here "head" will only change for left call and throughout the whole recursion it will be set to the head of the LL and then it will never be changed again and the whole recursion returns this as the main head of LL

    Algo:
        check for null
        call for left and save the returned res into a var "head"

        check if this is the 1st node i.e head of the DLL
            this will be told by the prev ptr
        operate on curr root
            connect root's left to prev
            connect prev's right to root
        update the prev
        call for right 
        
        return the res returned by the left call as the main res

    */

    private static Node prev = null;
    public static Node toDll(Node root) {
        if(root==null)return root;
        
        Node head=toDll(root.left);
        
        if (prev==null) {
            head=root;
        }
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        toDll(root.right);
        return head;
    }
    
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
    
        root.left.left = new Node(8);
        root.left.right = new Node(5);
    
        // root.left.right.left = new Node(70);
        // root.left.right.right = new Node(80);
    
        // right subtree
        root.right = new Node(2);
    
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root = toDll(root);
        printDLL(root);
    }

    public static void printDLL(Node head) {
        if (head == null) {return;}

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "---");
            curr = curr.right;
        }
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


















