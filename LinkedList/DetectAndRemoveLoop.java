public class DetectAndRemoveLoop {

    public static Node removeLoop(Node head) {
        if (head == null ) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Loop found at " + slow.data);
                break;
            }
        }

        // if there is no loop present
        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            if (slow.next == fast.next) {
                // System.out.println(slow.next.data + " equals " + fast.next.data);
                System.out.println("Removing the loop present at " + fast.next.data);
                fast.next = null;
                return head;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }
    
    public static void main(String[] args) {
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
		item8.next = item2;

        head = removeLoop(head);

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




