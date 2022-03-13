import java.util.*;

public class StackWithQ {

	// Defining 2 queue
	private static Queue<Integer> q1;
	private static Queue<Integer> q2;

	public StackWithQ() {
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
	}

	public static void push(int x) {

		/*
			1. move all items to q2
			2. add x to q1
			3. move all item to q1
		*/

		if (q1.isEmpty()) {
			q1.offer(x);
		} else {

			while (!q1.isEmpty()) {
				q2.offer(q1.poll());
			}

			System.out.println("After copying from q1, q2: " + q2);
			q1.offer(x);

			while (!q2.isEmpty()) {
				q1.offer(q2.poll());	
			}
		}
		System.out.println("Final q1 after adding " + x +  " is: " + q1);
	}
	public static int pop() {
	
		if (q1.isEmpty()) {
			System.out.println("q1 is empty");
			return -1;
		}
		System.out.println("popped item: " + q1.peek());
		return q1.poll();
	}

	public static int top() {
		return q1.peek();
	}

	public static int size() {
		return q1.size();
	}

	
	public static void main(String[] args) {
		StackWithQ stack = new StackWithQ();
		stack.push(3);
		stack.push(5);

		stack.pop();
	}
}









































