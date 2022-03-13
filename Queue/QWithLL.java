public class QWithLL {

	// private static int size;
	private static Node front, rear;
	// private static Node head;

	public QWithLL(int data) {
		front = rear = null;
	}

	public static void main(String[] args) {
		Node head = enQ(4);
		enQ(8);
		enQ(81);
		enQ(31);

		deQ();
	}

	public static Node enQ(int x) {
		Node newNode = new Node(x);
		if (front == null ){
			front = rear = newNode;
			return front;
		}
		
		rear.next = new Node(x);
		rear = rear.next;

		System.out.println("After ENQ, " + x + ", LL: ");
		printLL(front);

		return rear;
	}

	public static Node deQ() {
		if (front == null ) {
			System.out.println("Empty LL");
			return null;
		}

		System.out.println("Before DQ, LL: ");
		printLL(front);

		if (front.next == null) {
			System.out.println("Only 1 node present");
			return null;
		}

 		Node res = front;
		front.data = front.next.data;
		front.next = front.next.next;

		System.out.println("After DQ, " + res.data + " from LL: ");
		printLL(front);

		return res;
	}

	public static void printLL(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}

	// public static Node getRear() {
	// 	return rear;
	// }

	// public static Node getFront() {
	// 	return head;
	// }

	// public static int size() {
	// 	return size;
	// }

}

class Node {
	Node next;
	int data;

	public Node() {}

	public Node(int data) {
		this.data = data;
	}
}




























