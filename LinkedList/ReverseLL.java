import java.util.*;

public class ReverseLL {

	public static Node reverseLL(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        // Node next = curr.next;

        // while (next != null) {
        //     // curr.next = prev;
            
        //     // prev = curr;
        //     // curr = next;
        //     // next = curr.next;

        // }

        while (curr != null) {
        	Node next = curr.next;

        	curr.next = prev;

        	prev = curr;
        	curr = next;
        }

        // curr.next = prev;
        // return curr;

        return prev;
    }

    public static Node reverseLLNaive(Node head) {
    	ArrayList<Integer> list = new ArrayList<>();

    	Node curr = head;

    	while (curr != null) {
    		list.add(curr.data);
    		curr = curr.next;
    	}

    	curr = head;
    	while (curr != null) {
    		curr.data = list.remove(list.size()-1);
    		curr = curr.next;
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
		Node item6 = new Node(95);

		// Connecting nodes
		head.next = item2;
		item2.next = item3;
		item3.next = item4;
		item4.next = item5;
		item5.next = item6;

		printLL(head);

		head = reverseLL(head);
		// head = reverseLLNaive(head);

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