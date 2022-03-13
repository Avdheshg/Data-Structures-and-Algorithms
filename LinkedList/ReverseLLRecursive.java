public class ReverseLLRecursive {

    // M-1: Naive:  This will 1st go to the last node and then it will start reversing from last to head
    public static Node recNaive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*     Algo:
            LL: 5 -> 6 -> 7
            6 and 7 are reversed and now the LL is: 5  6 <- 7

            head = 5
            restHead = 7 : last node of unreversed LL
            restTail = 6
            6.next = 5
            5.next = null
            return 7
        */

        Node restHead = recNaive(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;

        return restHead;
    }

    // M-2: Efficient: this will start reversing from the current node itself to the end
    public static Node rec2(Node head, Node prev) {
        if (head == null) {
            return prev;
        }

        Node next = head.next;
        head.next = prev;

        return rec2(next, head);  
        // When V return the rec call itself the the whole recursion process will  retunr the result of base case(or last call, here: when curr==null, prev(means last node) will be returned by whole recursive call)
    } 
    
    public static void printLL(Node head) {

		if (head == null) {
			System.out.println("No list exists");
		}

		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();

	}

    public static void main(String[] args) {
        // Creating nodes
		Node head = new Node(20);
		Node item2 = new Node(39);
		Node item3 = new Node(41);
		Node item4 = new Node(48);
		Node item5 = new Node(87);
		Node item6 = new Node(95);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;

        System.out.println("Before reversing");
		printLL(head);
        
        head = recNaive(head);
        // head = rec2(head, null);

        System.out.println("After reversing");
		printLL(head);
    }

}




class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}
