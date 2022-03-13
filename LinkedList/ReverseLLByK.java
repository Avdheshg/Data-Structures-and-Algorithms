public class ReverseLLByK {

	// recursive
	public static Node reverseKRecursive(Node head, int k) {
		Node curr = head, prev = null;

		int count = 0;
		while (curr != null && count < k) {
			Node nextNode = curr.next;

			curr.next = prev;
			prev = curr;
			curr = nextNode;

			count++;
		}
		if (curr != null ) {
			Node newHead = reverseKRecursive(curr, k);
			head.next = newHead;
		}
		return prev;
	}

	// Iterative
	/*
		store the head in curr var (for traversing purpose)
		prevFirst: var which will hold the first element of LL of dize k before reversed
		a var which will tell that this is the 1st pass of the LL (so that V can mark the currect head for the whole LL)


		TR the LL until tail
			define a var which will hold the 1st node (of the non-reversed LL), which after reversing will become the tail of the reverse LL. V R storing this bcoz then V will cnnect this node with the next reversed LL

			reverse K nodes

			check if this is the 1st pass 
				mark the head 
			if not
				connect the tail(prev1st) of previous reversed LL to the 1st node of the reversed LL (prev)
			update prevFirst with the tail of the current reverse LL
	*/
	public static Node reverseKIterative(Node head, int k) {
		if (head == null) return null;

		Node curr = head, prevFirst = null;
		boolean isFirstPass = true;

		while (curr != null) {
			Node first = curr, prev = null;
			int count = 0;

			while (curr != null && count < k) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next; 
				count++;
			}

			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else {
				prevFirst.next = prev;
			}

			prevFirst = first;
		}

		return head;
	}

	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		Node head = new Node(20);
		Node item2 = new Node(39);
		Node item3 = new Node(41);
		Node item4 = new Node(48);
		Node item5 = new Node(87);
		Node item6 = new Node(32);
		Node item7 = new Node(73);
		Node item8 = new Node(95);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;
		item6.next = item7;
		item7.next = item8;

		printLL(head);

		// head = reverseKRecursive(head, 3);
		head = reverseKIterative(head, 3);	

		printLL(head);
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

}


class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}






































