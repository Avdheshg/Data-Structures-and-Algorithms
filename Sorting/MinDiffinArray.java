import java.util.*;

public class MinDiffinArray {

	public static void main(String[] args) {

		// int arr[] = new int[] {1, 8, 12, 5, 18};
		// int arr[] = new int[] {8, 15};
		int arr[] = new int[] {8, -1, 0, 3};
		
		int len = arr.length;

		int min = Integer.MAX_VALUE;

		Arrays.sort(arr);

		for (int i = 1; i < len; i++) {
			min = Math.min(min, (arr[i] - arr[i-1]));
		}

		System.out.println("min : " + min);
	}
}