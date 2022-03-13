import java.util.*;

public class LongestSubArrayWithEqual1And0 {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{1, 0, 1, 1, 1, 0, 0};
		int arr[] = new int[]{0, 0, 1, 1, 1, 1, 1, 0};

		naive(arr);
		// efficient(arr);
	}
	
	// Naive: O(n2)
	public static void naive(int arr[]) {
		int maxSize = 0;
		for (int i = 0; i < arr.length; i++) {

			int zero = 0, one = 0, curCount = 0;
			if (arr[i] == 0) {
				zero++;
			} else {
				one++;
			}
			System.out.println("i " + i);

			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] == 0) {
					zero++;
				} else {
					one++;
				}
				System.out.println("\tj " + j + " one=" + one + " zero=" + zero +  " , ");

				if (zero == one) {
					maxSize = Math.max(maxSize, j-i+1);
				}
			}
			System.out.println("\n");
		}

		System.out.println("Final maxSize " + maxSize);

	}

	/* Efficient => This will use the question: Longest subarray with given sum
		Algo: O(n) || O(n)
			Replace all 0s with -1
			Now this problem will reduce to the Longest subarray with given sum(0)
	*/

	public static void efficient(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		longestSubArrayWithSum(arr, 0);
	}

	public static void longestSubArrayWithSum(int arr[], int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxSize = 0, preSum = 0;

		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];

			if (preSum == 0) {
				maxSize = i+1;
			}
			if (map.containsKey(preSum-sum)) {
				maxSize = Math.max(maxSize, i - map.get(preSum));
			}
			if (map.containsKey(preSum) == false) {
				map.put(preSum, i);
			}
		}

		System.out.println("MaxSize: " + maxSize);
	}
}