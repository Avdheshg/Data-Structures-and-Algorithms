public class InsertAtBegCLL {

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

		int newData = 19;
		System.out.println("Inserting " + newData + " at the beginning of the LL. After insertion LL => ");

		head = insertAtBeg(head, newData);

		printCLL(head);

		System.out.println("Last" + "Is circular " + getLast(head).next.data);
	}


	public static Node insertAtBeg(Node head, int newData) {

		Node newNode = new Node(newData);

		// head is null
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}	
		
		newNode.next = head.next;
		head.next = newNode;

		// swap the data of head and new head
		int temp = head.data;
		head.data = newNode.data;
		newNode.data = temp;

		return head;

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








