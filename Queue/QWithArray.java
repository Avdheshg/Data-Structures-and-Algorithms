import java.util.*;

public class QWithArray {

	private static int rear = -1;
	private static int arr[];
	private static int capacity;

	public QWithArray(int cap) {
		// size
		this.capacity = cap;
		arr = new int[cap];
	}

	public static void main(String[] args) {
		QWithArray queue = new QWithArray(5);

		enQ(3);
		enQ(6);
		enQ(13);

		deQ();
		getRear();
		getFront();

		isFull();
		isEmpty();
	}

	public static void enQ(int x) {
		if (isFull()) {
			System.out.println("Q is full, so can't make enQ()");
			return;
		}

		arr[++rear] = x;
		System.out.println(x + " is inserted at: " + rear + " and new arr is: \n" + Arrays.toString(arr));
	}

	public static int deQ() {
		if (isEmpty()) {
			System.out.println("Q is empty, so can't make deQ()");
			return -1;
		}

		int res = arr[0];
		reArr(arr);
		rear--;
		System.out.println("After deQ(), rear: " + rear + " and returned element: " + res);
		return res;
	}

	public static void reArr(int arr[]) {
		System.out.println("Before re-Arr, arr: " + Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			arr[i-1] = arr[i];
		}
		System.out.println("After re-Arr, arr: " + Arrays.toString(arr));
	}

	public static int getFront() {
		if (isEmpty()) {
			System.out.println("Q is empty, so don't have any rear");
			return -1;
		}
		System.out.println("front: " + arr[0]);
		return arr[0];
	}

	public static int getRear() {
		if (isEmpty()) {
			System.out.println("Q is empty, so don't have any rear");
			return -1;
		}
		System.out.println("rear: " + arr[rear]);
		return arr[rear];
	}

	public static boolean isEmpty() {
		System.out.println("isEmpty: " + (rear == -1));
		return rear == -1;
	}

	public static boolean isFull() {
		System.out.println("isFull: " + ((rear+1) == capacity));
		return (rear+1) == arr.length;
	}

}







































