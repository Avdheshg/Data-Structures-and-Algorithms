public class RemoveDupsFromSortedLL {

	// Ex: 1 1 1 1 1 2
	public static void removeDups(Node head) {
		
		Node curr = head;

		while (curr != null && curr.next != null) {
			Node nextNode = curr.next;

			if (curr.data == nextNode.data) {
				curr.next = nextNode.next;
			} else {
				curr = curr.next;
			}
		}

		// return head;

	}

	
	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		// Node head = new Node(20);
		// Node item2 = new Node(39);
		// Node item3 = new Node(41);
		// Node item4 = new Node(48);
		// Node item5 = new Node(87);
		// Node item6 = new Node(95);

		Node head = new Node(20);
		Node item2 = new Node(39);
		Node item3 = new Node(39);
		Node item4 = new Node(48);
		Node item5 = new Node(87);
		Node item6 = new Node(87);

		// Node head = new Node(20);
		// Node item2 = new Node(20);
		// Node item3 = new Node(20);
		// Node item4 = new Node(20);
		// Node item5 = new Node(20);
		// Node item6 = new Node(20);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;

		printLL(head);

		removeDups(head);

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