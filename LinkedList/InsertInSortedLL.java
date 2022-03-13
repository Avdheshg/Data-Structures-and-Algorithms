public class InsertInSortedLL {

	public static Node InsertInSorted(Node head, int data) {

		System.out.println("Inserting: " + data + " Before inserting, LL:");
		printLL(head);

		Node temp = new Node(data);

		// if LL is null
		if (head == null) {
			return temp;
		}

		// if data is smallest
		if (data <= head.data) {
			temp.next = head;
			return temp;
		}

		// Node prevNode = getPos(head, data);
		// System.out.println("Prev Node returned is " + prevNode.data);
		Node prev = null, curr = head;
		while (curr != null &&  curr.data < data) {
			prev = curr;
			curr = curr.next;
		}
		temp.next = prev.next;
		prev.next = temp;

		printLL(head);
		return head;

	}

	public static Node getPos(Node head, int data) {
		Node prevNode = null, curr = head;

		// It is must to check the curr node before comparing it's data 
		while (curr.next != null && data > curr.next.data) {
			// prevNode = curr;
			curr = curr.next;
		}

		return curr;	
	}


	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		Node head = new Node(20);
		Node item2 = new Node(39);
		Node item3 = new Node(41);
		Node item4 = new Node(48);
		Node item5 = new Node(87);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;

		printLL(head);

		head = InsertInSorted(head, 40);

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
