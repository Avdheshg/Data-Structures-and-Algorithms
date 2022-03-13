public class PairwiseSwapNodes {

	public static void swapData(Node curr, Node secNode) {
		int temp = curr.data;
		curr.data = secNode.data;
		secNode.data = temp;
	}
	public static Node pairwiseSwap(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node curr = head;
		while (curr != null && curr.next != null) {
			Node secNode = curr.next;
			swapData(curr, secNode);
			curr = secNode.next;
		}

		return head;
	}

	public static Node pairwiseSwapEff1(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		// swap the 1st node
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;

		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;

			Node nextNode = curr.next.next;
			curr.next.next = curr;

			curr = nextNode; 
		}

		prev.next = curr;
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

		printLL(head);

		head = pairwiseSwapEff1(head);

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

}


class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}















