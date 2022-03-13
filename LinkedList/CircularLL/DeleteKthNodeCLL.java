public class DeleteKthNodeCLL {


	public static Node deleteKthNode(Node head, int k) {

		if (head == null || ((head.next == head) && k == 1) ) {
			return null;
		}

		if (k == 1) {
			int temp = head.next.data;
			head.next = head.next.next;
			return head;
		}

		Node kthNode = getKthNode(head, k);
		System.out.println(k + " node is, returned node is " + kthNode.data);
		
		kthNode.next = kthNode.next.next;

		return head;

	}

	public static Node getKthNode(Node head, int k) {
		int idx = 1;
		Node curr = head;

		while (curr.next != head) {
			System.out.println("In loop curr  is " + curr.data);	
			if ((idx+1) == k) {
				// System.out.println(k + " node is " + curr.data);
				return curr;
			}
			idx++;
			curr = curr.next;
		}

		return curr;
	}

	public static void main(String[] args) {

		
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

		head = deleteKthNode(head, 5);
		printCLL(head);
		// System.out.println("Circular " + getLast(head).next.data);
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