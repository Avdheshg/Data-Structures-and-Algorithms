

public static void main(String[] args) {
		
		// Make a LL
		Node head = new Node(10);
		Node item2 = new Node(20);
		Node item3 = new Node(30);
		Node item4 = new Node(40);

		// Node head = new Node(500);
		// Node item2 = new Node(10);
		// Node item3 = new Node(340);
		// Node item4 = new Node(740);

		// Connect them
		head.next = item2;

		// for 20
		item2.prev = head;
		item2.next = item3;

		// for 30
		item3.prev = item2;
		item3.next = item4;

		// for 40
		item4.prev = item3;

		printList(head);

		reverse(head);

		// System.out.println();

}

public static void printList(Node head) {

		if (head ==  null) {
			System.out.println("No list available, Can't print ");
		}

		System.out.println("Current list is ");
		Node curr = head;

		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
}	


class Node {
	Node next;
	Node prev;
	int data;

	Node(int data) {
		this.data = data;
	}
}

// Last node
public static Node getLast(Node head) {

	Node curr = head;
	while (curr.next != null) {
		curr = curr.next;
	}

	System.out.println("Last node is " + curr.data);
	return curr;
}

// 2nd Last node
public static Node getSecondLast(Node head) {

	Node curr = head;

	while (curr.next.next != null) {
		curr = curr.next;
	}

	System.out.println("2nd last node is " + curr.data);
	return curr;
}
























