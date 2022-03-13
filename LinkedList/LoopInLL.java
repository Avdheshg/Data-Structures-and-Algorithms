public class LoopInLL{ 

	// M-5: Floyd cycle finding algo
	public static Node findCycle(Node head) {

		Node slow = head, fast = head;

		System.out.println("Finding loop");

		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			System.out.println("slow: " + slow.data +  " fast " + fast.data);

			if (slow == fast) {
				System.out.println("Has loop");
				break;
			}
		}

		System.out.println("\nHas loop, finding starting of loop");

		slow = head;

		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;

			if (slow == fast) {
				System.out.println("Loop is starting from " + slow.data);
				return slow;
			}
		}

		System.out.println("No loop exists");
		return head;

	}

	// M-4: Use the HM, go through the LL and find if the current element present in the HM (will not work for dups)

	// M-3: Using the dummy node and point each node's next to this dummy node

	// M-2: Define a new parameter in each node(modify the definition of LL) which contains info about, is it visited or not

	// M-1: Naive
	public static Node hasLoopNaive(Node head) {

		if (head == null) return head;

		if (head.next == head) {
		 	System.out.println("Loop at head");
		 	return head;
		}

		Node curr = head;

		while (curr != null ) {
			Node nextNode = curr.next;
			Node startNode = head;

			while (startNode != curr) {
				System.out.println("nextnode: " + nextNode.data +  " startNode " + startNode.data);
				if (startNode.next == nextNode) {
					 System.out.println("Loop found at " + startNode.next.data);
					 return startNode.next;
				}
				startNode = startNode.next;
			}

			curr = curr.next;
		}

		System.out.println("No loop exists");
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
		item8.next = item2;

		// printLL(head);

		// hasLoopNaive(head);
		findCycle(head);

		// printLL(head);
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

	// Last node
	public static Node getLast(Node head) {
		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
			// System.out.println("******");
		}

		System.out.println("Last node is " + curr.data);
		return curr;
	}

}


class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}