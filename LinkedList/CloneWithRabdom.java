import java.util.*;

public class CloneWithRabdom {

	// M-1: O(n) & O(n)
	/*
		Using a HM, 
			Define a HM which will save current node and it's next node  
			TR the LL and save current and next node of current into the HM
			Again TR the LL
				build a new LL from the map using "curr" as a key for map
				connect next node of curr to the map.get(curr.next) i.e as map contains the the next node and random node of current  
	*/
	public static Node cloneWithHM(Node head) {
		if (head == null) {
			return null;
		}

		HashMap<Node, Node> map = new HashMap<>();

		Node curr = head;
		while (curr != null ) {
			map.put(curr, new Node(curr.data));
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			Node clone = map.get(curr);
			clone.next = map.get(curr.next);
			clone.random = map.get(curr.random);
		}

		return map.get(head);
	}

	public static Node cloneLL(Node head) {
		if (head == null) {
			return head;
		}

		Node curr = head;
		while (curr != null) {
			Node next = curr.next;

			Node newNode = new Node(curr.data);
			curr.next = newNode;
			newNode.next = next;

			curr = curr.next.next;
		}

		curr = head;
		while (curr != null && curr.next != null) {
			curr.next.random = (curr.random != null) ? curr.random.next : null;

			curr = curr.next.next;
		}

		Node original = head, copy = head.next;

		while (original != null && copy != null) {

			original.next = original.next!=null? original.next.next : original.next; 
            copy.next = copy.next!=null?copy.next.next:copy.next; 

			original = original.next; 
            copy = copy.next;
		}

		System.out.println("New list is");
		System.out.println("New list is");
		// printLL(newHead);		

		return head;
	}	

	public static void main(String[] args) {
		// System.out.println();
		
		// Creating nodes
		Node head = new Node(10);
		Node item2 = new Node(5);
		Node item3 = new Node(20);
		Node item4 = new Node(15);
		Node item5 = new Node(25);
		// Node item6 = new Node(32);
		// Node item7 = new Node(73);
		// Node item8 = new Node(95);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		// item5.next = item6;
		// item6.next = item7;
		// item7.next = item8;

		// connecting random
		head.random = item3;
		item2.random = item4;
		item3.random = item2;
		item4.random = head;
		item5.random = item4;

		printLL(head);

		head = cloneLL(head);

		printLL(head);
	}

	public static void printLL(Node head) {

		if (head == null) {
			System.out.println("No list exists");
		}

		Node curr = head;
		while (curr != null) {
			System.out.println("Data " + curr.data + "  Random: " + curr.random.data);
			// if (curr.random != null) {
			// 	System.out.println()
			// }
			curr = curr.next;
		}
		System.out.println();

	}

	// public static void printRandom(Node head) {

	// 	if (head == null) {
	// 		System.out.println("No list exists");
	// 	}

	// 	Node curr = head;
	// 	while (curr != null) {
	// 		System.out.print(curr.data + " -> ");
	// 		curr = curr.next;
	// 	}
	// 	System.out.println();

	// }

}


class Node {
	Node next;
	Node random;
	int data;

	public Node(int data) {
		this.data = data;
	}
}




























