import java.util.*;

public class QWithCircularArray {
	// Haven't checked the running code, 1st check and then learn

	/*
		This will give front, front = (front+1) % cap
		This will give rear, rear = (front+ (size-1) ) % cap
	
		enQ() => 
			check for full
			(In enQ() V add to the rear)
			get the rear
			update the rear by 1 for x and insert x
			update size

		deQ() =>
			check for empty
			increment the front by 1(bcoz V need to delete the ele present at curr front)
			decrease the size

	*/

	private static int front, capacity, size;
	private static int arr[];

	

	public QWithCircularArray(int capacity) {
		this.capacity = capacity;
		front = size = 0;
		arr = new int[capacity];
	}

	public static void enQ(int x) {
		if (isFull()) {
			System.out.println("Q is full, so can't make enQ()");
			return;
		}

		int rear = getRear();
		rear = (rear + 1) % capacity;
		arr[rear] = x;
		size++;
		System.out.println(x + " is inserted at: " + rear + " and new arr is: \n" + Arrays.toString(arr));
	}

	public static void deQ() {
		if (isEmpty()) {
			System.out.println("Q is empty, so can't make deQ()");
			return;
		}

		// int res = 
		front = (front + 1) % capacity;
		size--;
	}

	public static int getRear() {
		if (isEmpty()) {
			return -1;
		}
		return (front + (size-1)) % capacity;
	}

	public static int getFront() {
		if (isEmpty()) {
			return -1;
		}

		return front;
	}

	public static boolean isFull() {
		return (size == capacity);
	}

	public static boolean isEmpty() {
		return size == 0;
	}


}