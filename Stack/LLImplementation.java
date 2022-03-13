public class LLImplementation {
	// System.out.println();

	private static Node head;
	private static int size;

	// constructor
	public LLImplementation() {
		size = 0;
	}

	public static void main(String[] args) {
		head = push(20);
		printLL(head);	
		printLL(push(40));
		printLL(push(90));

		pop();
		printLL(head);

		System.out.println("Size: " + getSize());
		System.out.println("isEmpty " + isEmpty());
		System.out.println("peek " + peek());
	}

	// push
	public static Node push(int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
		size++;
		return head;
	}

	// pop
	public static int pop() {
		if (head == null) {
			return -1;
		}
		head = head.next;
		size--;
		return head.data;
	}

	// isEmpty
	public static boolean isEmpty() {
		return (head == null);
	}

	// peek
	public static int peek() {
		if (head == null) {
			return -1;
		}
		return head.data;
	}

	public static int getSize() {
		return size;
	}

	public static void printLL(Node head){
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
	}

	// push, pop,peek, isEmpty, size



}

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

































