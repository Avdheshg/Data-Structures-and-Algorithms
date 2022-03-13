public class CLL {
	
	/*
		We generally have 2 base cases in LL:
			1. head is null
			2. have only 1 item
	*/

	public static void main(String[] args) {
		System.out.println();
		
		// Creating nodes
		Node head = new Node(20);
		Node item2 = new Node(89);
		Node item3 = new Node(91);
		Node item4 = new Node(418);
		Node item5 = new Node(87);

		// head.next = head;

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;

		// // making circular
		item5.next = head;

		printCLL(head);

		System.out.println("Circular " + getLast(head).next.data);
	}

	public static void printCLL(Node head) {

		if (head == null) {
			System.out.println("No list exists");
		}

		// Printing the head and then will start from the 2nd element
		System.out.print(head.data + " -> ");

		Node curr = head.next;
		while (curr != head) {
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





































