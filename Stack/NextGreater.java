import java.util.*;

public class NextGreater {

	public static void main(String[] args) {
		int arr[] = new int[]{5,15,10,8,6,12,9,18};

		// naive(arr);
		efficient(arr);	
	}

	public static void naive(int arr[]) {
		System.out.println("arr: " + Arrays.toString(arr));
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			boolean hasGreater = false;

			for (int j = i+1; j < len; j++) {
				if (arr[j] > arr[i]) {
					System.out.println("for " + arr[i] + " next greater is " + arr[j]);
					hasGreater = true;
					break;
				} 
			}

			if (!hasGreater) {
				System.out.println(arr[i] + " is the greatest element => " + -1);
			}
		}

		// System.out.println("for " + arr[len-1] + " => " + -1);
	}

	 // V R using an AL reversing it bcoz the o/p of this program will be in the reverse order bcoz V R traversing from the end of the array i.e it will print the next greater element for last of the array but V need to start printing the next greater ele for the 1st item of the array. That's why V store outputs in an AL and after that V reverse and return it
	public static void efficient(int arr[]) {
		System.out.println("arr: " + Arrays.toString(arr));
		int len = arr.length;
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		// Defining an AL as the OP will be in reverse order
		ArrayList<Integer> al = new ArrayList<>();

		// stack.push(arr[len-1]);
		// System.out.println("for " + arr[len-1] + ": -1");

		for (int i = len-1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}

			// if (stack.isEmpty()) {
			// 	System.out.println(arr[i] + " is the greatest element => " + -1);
			// } else {
			// 	System.out.println("for " + arr[i] + " previous greater is " + stack.peek());
			// }

			int res = stack.isEmpty() ? -1 : stack.peek();
			System.out.println("For " + arr[i] + " next greater: " + res);

			al.add(res);

			stack.push(arr[i]);
		}

		Collections.reverse(al);
		al.set(al.size()-1, -1);
		System.out.println("AL: " + al);
	}

}



































