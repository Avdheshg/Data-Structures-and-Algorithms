import java.util.*;

public class Merge2SortedLL {

	public static Node mergeNaive(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return head1;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		ArrayList<Integer> al = new ArrayList<>();

		Node curr = head1, prev = null;

		while (curr != null) {
			al.add(curr.data);
			prev = curr;
			curr = curr.next;
		}

		System.out.println("Last node of LL1: " + prev.data);

		curr = head2;
		while (curr != null) {
			al.add(curr.data);
			curr = curr.next;
		}

		prev.next = head2;
		System.out.println("Combine LL: ");
		printLL(head1);

		Collections.sort(al);
		System.out.println("Sorted AL: " + al);

		curr = head1;
		int i = 0;
		while (curr != null) {
			curr.data = al.get(i++);
			curr = curr.next;
		}

		return head1;
	}

	public static Node mergeEff(Node a, Node b) {
		if (a == null && b == null) {
			return a;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		Node head, tail;

		if (a.data <= b.data) {
			head = a;
			a = a.next;
		} else {
			head = b;
			b = b.next;
		}
		tail = head;

		while (a != null && b != null) {
			if (a.data <= b.data) {
				System.out.println("Connecting " + tail.data + " with " + a.data);
				tail.next = a;
				tail = a;
				a = a.next;
			} else {
				System.out.println("Connecting " + tail.data + " with " + b.data);
				tail.next = b;
				tail = b;
				b = b.next;
			}
			System.out.println();
		}

		if (a == null) {
			tail.next = b;
		} else {
			tail.next = a;
		}

		System.out.println("Combined LL");
		printLL(head);

		return head;
	}

	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		Node head = new Node(10);
		Node item2 = new Node(15);
		Node item3 = new Node(20);
		Node item4 = new Node(25);
		Node item5 = new Node(35);
		Node item6 = new Node(42);
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

		System.out.println("LL 1");
		printLL(head);

		Node head2 = new Node(11);
		Node LL2item2 = new Node(12);
		Node LL2item3 = new Node(31);
		Node LL2item4 = new Node(35);
		Node LL2item5 = new Node(55);

		head2.next = LL2item2;
		LL2item2.next = LL2item3;
		LL2item3.next = LL2item4;
		LL2item4.next = LL2item5;
		System.out.println("LL 2");
		printLL(head2);

		// head = mergeNaive(head, head2);
		head = mergeEff(head, head2);

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
	Node random;
	int data;

	public Node(int data) {
		this.data = data;
	}
}
