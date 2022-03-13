public class RemoveLoopFromLL {

	public static Node deleteLoop(Node head) {

		if (head == null) {
			return head;
		}

		Node slow = head, fast = head;

		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;

			// System.out.println("slow: " + slow.data +  " fast " + fast.data);

			if (slow == fast) {
				// System.out.println("Finding loop, slow: " + slow.data +  " fast " + fast.data);
				System.out.println("Has loop");
				break;
			}
		}

		if (fast.next == null || fast == null) {
			System.out.println("No loop exists");
			return head;
		}

		slow = head;

		while (slow != null && fast != null) {

			System.out.println("slow: " + slow.data +  " fast " + fast.data);

			if (slow.next == fast.next) {
                // System.out.println("Loop is starting from " + slow.next.data);
                System.out.println("Starting point of loop, slow.next " + slow.next.data + " fast.next " + fast.next.data);
				fast.next = null;

				System.out.println("After removing the loop, list is ");
				printLL(head);
				return head;
			}

			slow = slow.next;
			fast = fast.next;
		}

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

		// item8.next = head;      // interesting case
		item8.next = item4;
		// deleteLoop(head);

		// printLL(head);
		
        int a = 98, b = 56;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
	}

	static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
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