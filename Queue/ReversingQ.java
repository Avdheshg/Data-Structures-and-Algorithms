import java.util.*;

public class ReversingQ {

	public static void main(String[] args) {
		
		// Defining a Q
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(3);
		q.offer(13);
		q.offer(41);
		q.offer(81);
		q.offer(39);

		// iterative(q);
		System.out.println("Before reverse, q: " + q);
		rec(q);
		System.out.println("After reverse, q: " + q);
	}

	public static void iterative(Queue<Integer> q) {

		// Defining a Stack
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		System.out.println("Before reverse, q: " + q);

		while (!q.isEmpty()) {
			stack.push(q.poll());
		}

		while (!stack.isEmpty()) {
			q.offer(stack.pop());
		}

		System.out.println("After reverse, q: " + q);
	}

	public static void rec(Queue<Integer> q) {
		if (q.isEmpty()) {
			return;
		}
		int x = q.poll();
		rec(q);
		q.offer(x);
	}

}



































