import java.util.*;

public class PreviousGreaterElement {

	public static void main(String[] args) {
			
		int arr[] = new int[]{15,10,18,12,4,6,2,8};

		// naive(arr);
		efficient(arr);
	}

	public static void efficient(int arr[]) {
		int len = arr.length;

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(arr[0]);
		System.out.println("for " + arr[0] + ": -1");

		for (int i = 1; i < len; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}

			int res = (stack.isEmpty())? -1 : stack.peek();
			System.out.println("for " + arr[i] + " previous greater is " + res);

			stack.push(arr[i]);
		}
	}

	public static void naive(int arr[]) {
		System.out.println("arr: " + Arrays.toString(arr));
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int j = -1;

			for (j = i-1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					System.out.println("for " + arr[i] + " previous greater is " + arr[j]);
					break;
				}
			}

			if (j == -1) {
				System.out.println(arr[i] + " is the greatest element => " + -1);
			}
		}
	}
}