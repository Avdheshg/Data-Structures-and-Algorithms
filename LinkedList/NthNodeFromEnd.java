public class NthNodeFromEnd {

	// Naive: 2 traversal
	public static void nthNodeFromEnd(Node head, int k) {

		Node curr;
		int size = 0;

		for (curr = head; curr != null; curr = curr.next) {
			size++;
		}

		if (k > size) {
			return;
		}

		curr = head;

		while (curr != null) {
			if (size == k) {
				System.out.println(k + "th Node is " + curr.data);
			}
			size--;
			curr = curr.next;
		}

	}
	/*
		Move the 1st pointer till =k pos ahead 
		Define a new pointer and this pointer will start from =k pos and mark the prev pointer to start from head
		Move both the pointers simultaneously until the fast != null

	*/
	// Efficient:  1 traversal
	public static void nthNodeEfficient(Node head, int k) {

		if (head == null ){
			return;
		}

		Node curr = head;
		int count = 1;

		while (count <= (k) ) {
			if (curr == null) {
				System.out.println("k is > size()");
			}
			count++;
			curr = curr.next;
			System.out.println("curr: " + curr.data + " count: " + count + " k: " + (k));
		}

		Node fastPtr = curr;
		curr = head;
		System.out.println("fastPtr: " + fastPtr.data);

		while (fastPtr != null) {
			fastPtr = fastPtr.next;
			curr = curr.next;
		}

		System.out.println(k + "th node from end: " + curr.data);
	}

	public static void main(String[] args) {
		// System.out.println();
		
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

		printLL(head);

		// nthNodeFromEnd(head, 4);
		nthNodeEfficient(head, 3);

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