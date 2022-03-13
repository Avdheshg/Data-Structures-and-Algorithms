import java.util.*;

public class LongestSubArrayWithSum {

	// Efficient: O(n) || O(n)
	public static void efficientSum(int arr[], int sum) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int maxSize = 0, preSum = 0;

		for (int i = 0; i < arr.length; i++) {

			preSum += arr[i];

			// if preSum started from idx 0
			if (preSum == sum) {
				maxSize = i + 1;
			}

			// if V have found that the current idx is having sum equals to sum then V need to update the maxSize
			if (map.containsKey(preSum - sum)) {
				maxSize = Math.max(maxSize, i - map.get(preSum - sum));
				System.out.println("Updated maxSize " + maxSize);
			}

			// V don't need to add those elements which are making the sum 0 and adding themselves to the preSum
			if (map.containsKey(preSum) == false) {
				map.put(preSum, i);
			}
		}

		System.out.println("Final maxSize " + maxSize);
	}

	// Naive: O(n2)
	public static void naiveSum(int arr[], int sum) {
		int maxSize = 0;

		for (int i = 0; i < arr.length; i++) {

			int curSum = arr[i];
			for (int j = i+1; j < arr.length; j++) {

				curSum += arr[j];

				if (curSum == sum) {
					maxSize = Math.max(maxSize, (j-i) + 1);
				}
			}
		}
		if (maxSize == 0) {
			System.out.println("Not Sum Found");
			return;
		}
		System.out.println("maxSize " + maxSize);
	}

	
	public static void main(String[] args) {
		
		// int arr[] = new int[]{5, 8, -4, -4, 9, -2, 2};
		// int arr[] = new int[]{3, 1, 0, 1, 8, 2, 3, 6};
		int arr[] = new int[]{8, 3, 1, 5, -6, 6, 2, 2};

		// naiveSum(arr, 4);
		efficientSum(arr, 4);
	}
}