import java.util.*;

public class SubArraySumZero {

	
	public static void naiveSum(int arr[], int sum) {

		// for (int i = 0; i < arr.length; i++) {

		// 	int curSum = arr[i];

		// 	for (int j = i+1; j < arr.length; j++) {

		// 		curSum += arr[j];

		// 		if (curSum == sum) {
		// 			System.out.println("Found");
		// 			return;
		// 		}
		// 	}
		// }
		for (int i = 0; i < arr.length; i++) {

			int curSum = 0;

			for (int j = i; j < arr.length; j++) {

				curSum += arr[j];

				if (curSum == sum) {
					System.out.println("Found");
					return;
				}
			}
		}

		System.out.println("Not Found");
	}

	public static void efficientSum(int arr[], int sum) {

		HashSet<Integer> set = new HashSet<>();

		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];

			// Sum already seen
			if (set.contains(preSum)) {
				System.out.println("Found");
				return;	
			}

			// at this point preSum === 0
			if (preSum == 0) {
				System.out.println("Found");
				return;	
			}

			// add to the set
			set.add(preSum);
		}

		System.out.println("Not Found");

	}

	
	public static void main(String[] args) {
			
		int arr[] = new int[]{1, 4, 13, -3, -10, 5};
		// int arr[] = new int[]{-1, 4, -3, 5, 1};
		// int arr[] = new int[]{3, -1, -2, 5, 6};

		naiveSum(arr, 0);

		// efficientSum(arr, 0);

	}
}