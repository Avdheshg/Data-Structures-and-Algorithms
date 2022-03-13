import java.util.*;

public class SegregateEvenOdd {

	public static void swapData(Node curr, Node nextNode) {

		int temp = curr.data;
		curr.data = nextNode.data;
		nextNode.data = temp;

	}

	public static void swap(ArrayList<Integer> al, int idx, int from) {

		System.out.println("swapping " + al.get(idx) + " from " + al.get(from));

		int temp = al.get(idx);
		al.add(idx,al.get(from));
		al.add(from, temp);
	}

	public static void hoare(ArrayList<Integer> al) {

		int size = al.size();
		int i = -1, j = al.size();

		while (true) {

			do {
				i++;
			} while (i < size && (al.get(i) % 2 == 0) );

			do {
				j--;
			} while (j >= 0 && (al.get(j) % 2 != 0) );

			if (i >= j) {
				return;
			}

			swap(al, i, j);

		}

	}
	// Not working
	public static Node segregateNaive(Node head) {
		if (head == null ) {
			return null;
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		
		Node curr = head;
		while (curr != null ) {
			al.add(curr.data);
			curr = curr.next;
		}
		hoare(al);
		System.out.println("After swapping, al: " + al);

		curr = head;
		int i = 0;
		while (curr != null) {
			System.out.println("i: " + i + " " + al.size());
			curr.data = al.get(i++);
			curr = curr.next;
		}

		return head;

	}

	public static Node segregate(Node head) {

		if (head == null) {
			return null;
		}

		Node curr = head;

		while (curr != null) {

			if (curr.data % 2 == 0) {
				curr = curr.next;
			} else {

				Node nextNode = curr.next;

				while (nextNode != null && nextNode.data % 2 != 0) {
					nextNode = nextNode.next;
				}

				if (nextNode != null) {
					System.out.println("Before sapping, curr: " + curr.data + ", nextNode " + nextNode.data);
					swapData(curr, nextNode);
					System.out.println("After sapping, curr: " + curr.data + ", nextNode " + nextNode.data);
				} else {
					System.out.println("nextNode is null");
					return head;
				}
			}

		}

		return head;

	}

	public static Node segregateEfficient(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node eSt = null, oSt = null, eEnd = null, oEnd = null;
		Node curr = head;

		while (curr != null ) {

			int x = curr.data;

			if (x % 2 == 0 ) {
				if (eSt == null) {
					eSt = curr;
					eEnd = eSt;
				} else {
					eEnd.next = curr;
					eEnd = eEnd.next;
				}
			} else {
				if (oSt == null) {
					oSt = curr;
					oEnd = oSt;
				} else {
					oEnd.next = curr;
					oEnd = oEnd.next;
				}
			}
			System.out.println("curr: " + curr.data);
			curr = curr.next;
			// System.out.println("curr: " + curr.data +  "\n");
		}

		// if all are even || all are odd
		if (oSt == null || eSt == null) {
			return head;
		}

		eEnd.next = oSt;
		// oEnd.next = null;
		return eSt;

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

		// Node item2 = new Node(32);
		// Node item3 = new Node(42);
		// Node item4 = new Node(12);
		// Node item5 = new Node(82);
		// Node item6 = new Node(52);
		// Node item7 = new Node(72);
		// Node item8 = new Node(92);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;
		item6.next = item7;
		item7.next = item8;
		printLL(head);

		// Function call
		// segregate(head);
		// segregateNaive(head);
		segregateEfficient(head);

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







































