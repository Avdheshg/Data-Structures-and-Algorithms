import java.util.*;

public class IntersectionPointOf2LL {

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

		// Connecting nodes LL1
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		// item4.next = item5;
		// item5.next = item6;
		// item6.next = item7;
		// item7.next = item8;
		System.out.println("LL1");
		printLL(head);

		Node head2 = new Node(11);
		Node LL2item2 = new Node(12);
		Node LL2item3 = new Node(31);
		Node LL2item4 = new Node(15);
		Node LL2item5 = new Node(55);

		head2.next = LL2item2;
		LL2item2.next = LL2item3;
		LL2item3.next = LL2item4;
		LL2item4.next = LL2item5;
		LL2item5.next = item2;
		System.out.println("LL2");
		printLL(head2);
		

		// Function call
		// findIntersectionNaive(head, head2);
		findIntersectionEff(head, head2);

		// printLL(head);
		// System.out.println();
	}

	// O(n+m)
	public static Node findIntersectionEff(Node head, Node head2) {
		/*
			Make both the list of same length (by traversing the larger list by the abs diff of both the lists)
			traverse both the lists simultaneously and return if they are pointing to the same address
		*/
		int len1 = 0, len2 = 0;

		Node curr = head;
		while (curr != null) {
			len1++;
			curr = curr.next;
		}

		curr = head2;
		while (curr != null) {
			len2++;
			curr = curr.next;
		}

		int diff = Math.abs(len1 - len2);

		// finding the larger list
		if (len1 < len2) {
			Node temp = head;
			head = head2;
			head2 = temp;
		}

		System.out.println("Bigger list is");
		printLL(head);
		printLL(head2);

		int count = 0;
		curr = head;
		while (count < diff) {
			count++;
			curr = curr.next;
		}

		System.out.println("Curr stopped at: " + curr.data);

		Node curr2 = head2;
		while (curr != null && curr2 != null) {
			if (curr.next == curr2.next) {
				System.out.println("Intersection point is " + curr.next.data);
				return curr.next;
			}
			curr = curr.next;
			curr2 = curr2.next;
		}

		System.out.println("No Intersection found");
		return null;
	}

	// O(m+n) || O(n)
	public static Node findIntersectionNaive(Node head, Node head2) {

		HashSet<Node> set = new HashSet<>();

		Node curr = head;
		while (curr != null) {
			set.add(curr);
			curr = curr.next;
		}

		System.out.println("Set: " + set);

		curr = head2;
		while (curr != null) {
			if (set.contains(curr)) {
				System.out.println("Intersectio point is " + curr.data);
				return curr;
			}
			curr = curr.next;
		}
		return head;
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




























