import java.util.*;

public class PairSumUnsortedArray {
	
	// naive: O(n2)
	public static void naiveSum(int arr[], int sum) {

		int size = arr.length;

		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {

				if (arr[i] + arr[j] == sum) {
					System.out.println("Found");
					return;
				}
			}
		}
		System.out.println("Not found");
	}
	
	// M-2: Sort the array and use 2PA: O(nlogn)

	// Efficient: O(n) || O(n)
	public static void efficientSet(int arr[], int sum) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {

			if (set.contains(Math.abs(sum - arr[i]))) {
				System.out.println("Found, and pairs are " + arr[i] );
				return;		
			} else {
				set.add(arr[i]);
			}
		}
		System.out.println("Not found");
	}

	
	public static void main(String[] args) {
		
		int arr[] = new int[]{3, 2, 8, 15, -8};
		// int arr[] = new int[]{2, 1, 6, 3};

		// naiveSum(arr, 6);
		efficientSet(arr, 17);
	}
}