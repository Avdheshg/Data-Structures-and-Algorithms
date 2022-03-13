
import java.util.*;

public class ChocolateDistributionProblem {

	public static void main(String[] args) {

		int arr[] = new int[] {7, 3, 2, 4, 9, 12, 56};
		
		System.out.println("Before sorting : " + Arrays.toString(arr));

		int m = 3;

		naive(arr, m);
		// distribute(arr, m);

	}

	// not working => wrong logic
	public static void naive(int arr[], int k) {
		int len = arr.length;
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; (i+k) < len; i++) {
			int min = arr[i];
			int max = arr[i];

			System.out.println("\nwindows is");
			for (int j = i; j < k; j++) {
				System.out.print(arr[j] + " ");
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
			}

			minDiff = Math.min(minDiff, max-min);
			System.out.println("\nmin: " + min + " max: " + max + " minDiff: " + minDiff + " ( max-min) " + ( max-min));
		}

		System.out.println("min diff is : " + minDiff);
	}

	public static void distribute(int arr[], int m) {

		Arrays.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		int len = arr.length;

		// int min = arr[m-1] - arr[0];
		int min = Integer.MAX_VALUE;

		// for (int i = 0; (i + (m-1) < len; i++) {
		for (int i = 0; (i+m) < len; i++) {
			min = Math.min(min, arr[i + (m-1)] - arr[i]);
		}

		System.out.println("min diff is : " + min);


	}
}