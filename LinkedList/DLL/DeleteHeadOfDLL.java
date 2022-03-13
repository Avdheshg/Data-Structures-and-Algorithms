public class DeleteHeadOfDLL {

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

		head = deleteHead(head);
		System.out.println("After deleting the 1st Node, new Head is " + head.data);

		// System.out.println("New list is ");
		printList(head);

	}

	public static Node deleteHead(Node head) {
		System.out.println("Deleting the 1st Node");

		// Base cases 
		if (head == null) {
			System.out.println("No list exists, head is null => Nothing to delete");
			return head;
		}

		// for 1 node
		if (head.next == null) {
			System.out.println("Only 1 node present and deleted. Now no list available");
			// head = null;
			return null;
		}


		// Deleting the head
		// Node prevOfNextNode = head.next.prev;

		// M-2
		head = head.next;
		head.prev = null;

		return head;


		// M-1
		// Node nextNode = head.next;
		// Node prevOfNextNode = nextNode.prev;

		// head.next = null;
		// prevOfNextNode = null;

		// return nextNode;



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

}