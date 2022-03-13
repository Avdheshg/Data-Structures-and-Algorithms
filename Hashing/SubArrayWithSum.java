import java.util.*;

public class SubArrayWithSum {
	
	// Naive: O(n2)
	public static void naiveSum(int arr[], int sum) {

		for (int i = 0; i < arr.length; i++) {

			int curSum = arr[i];

			for (int j = i+1; j < arr.length; j++) {

				if (curSum == sum) {
					System.out.println("Found");
					return;
				}
				curSum += arr[j];
			}
		}
		System.out.println("Not Found");
	}

	/* Efficient: O(n) || O(n) This will use subarray with sum 0 (in which V use preSum and Hashing concept)
		Algo: TR the array and cal the preSum
				for each iteration, check 2 conditions
					1st: is the current ele is forming preSum == sum starting from idx =0
					2nd: if the HS contains (preSum-sum): means that some elements in between have made the sum equals to the required and when V subtract that sum from total sum(preSum) V will get a sum which is repeating itself 
	*/
	public static void efficientSum(int arr[], int sum) {

		HashSet<Integer> set = new HashSet<>();

		int preSum = 0;

		for (int i = 0; i < arr.length; i++) {

			preSum += arr[i];
			
			if (preSum == sum) {
				System.out.println("Found");
				return;
			}

			if (set.contains(preSum - sum)) {
				System.out.println("Found");
				return;
			}

			set.add(preSum);
		}

		System.out.println("Not Found");
	}

	
	public static void main(String[] args) {
		
		// int arr[] = new int[]{5, 8, 6, 13, 3, -1};
		int arr[] = new int[]{15, 2, 8, 10, -5, -8, 6};

		naiveSum(arr, 22);
		// efficientSum(arr, 22);
	}

}

















