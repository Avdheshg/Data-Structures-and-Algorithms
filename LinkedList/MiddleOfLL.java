public class MiddleOfLL {

	public static void findMiddle(Node head) {

    	// M-2: Floyd cycle finding algo
        Node slow, fast;
        slow=fast=head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
         System.out.println("Middle is " + slow.data);

		// M-1
		// int size = getSize(head);

		// int middle = size/2 +1;
		// System.out.println("Total size " + size + " middle " + middle);

		// Node middleNode = getKthNode(head, middle);

		// System.out.println("Middle node found is " + middleNode.data);
	}

	public static Node getKthNode(Node head, int idx) {
		int count = 1;
		Node curr = head;

		while (curr != null) {
			if (count == idx) {
				return curr;
			}
			curr = curr.next;
			count++;
		}

		return null;
	}

	public static int getSize(Node head) {

		Node curr = head;
		int count = 0;

		while (curr != null) {
			// System.out.println(curr.data + " " + count);
			curr = curr.next;
			++count;
			// System.out.println(count);
		}
		return count;

	}

	public static void main(String[] args) {

		
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

		findMiddle(head);

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
