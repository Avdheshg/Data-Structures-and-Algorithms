import java.util.*;

public class PalindromeLL {

	public static boolean isPalindromeNaive(Node head) {

		if (head == null) {
			return true;
		}
		if (head.next == null) {
			return true;
		}

		ArrayList<Integer> al = new ArrayList<>();

		Node curr = head;
		while (curr != null) {
			al.add(curr.data);
			curr = curr.next;
		}

		System.out.println("Al: " + al);

		int low = 0, high = al.size()-1;
		while (low < high) {
			if (al.get(low) != al.get(high)) {
				System.out.println("Not a palindrom ");
				return false;
			} else {
				low++;
				high--;
			}
		}		
		System.out.println("LL is a palindrom ");
		return true;

	}

	// return the 1st middle for even
	public static Node findMiddle(Node head) {
		Node slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Middle = " + slow.data);
		return slow;
	}

	public static Node reverseLL(Node head) {
		Node curr = head, prev = null;

		while (curr != null) {
			Node nextNode = curr.next;

			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}

		System.out.println("Head of reverseLL = " + prev.data);
		System.out.println("reverseLL:  ");
		printLL(prev);
		return prev;
	}

	public static boolean isPalindromeEfficient(Node head) {

		if (head == null) {
			return true;
		}
		if (head.next == null) {
			return true;
		}

		Node middle = findMiddle(head);

		Node newHead = reverseLL(middle.next);

		Node curr = head;
		curr = head;
		while (newHead != null) {
			System.out.println("Checking " + curr.data + " " + newHead.data);
			if (curr.data != newHead.data) {
				System.out.println("Not a palindrom ");
				return false;
			} else {
				curr = curr.next;
				newHead = newHead.next;
			}
		}

		System.out.println("LL is a palindrom ");
		return true;
	}

	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		Node head = new Node(20);
		Node item2 = new Node(39);
		Node item3 = new Node(41);
		Node item4 = new Node(48);
		Node item5 = new Node(48);
		Node item6 = new Node(41);
		Node item7 = new Node(39);
		Node item8 = new Node(20);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;
		item6.next = item7;
		item7.next = item8;

		printLL(head);

		// isPalindromeNaive(head);
		isPalindromeEfficient(head);

		printLL(head);     // this is interesting, not printing the whole list
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