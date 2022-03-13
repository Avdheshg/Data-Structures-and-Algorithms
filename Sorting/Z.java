import java.util.*;

public class Z {

	public static void main(String args[]) {

		// int arr[] = new int[] {1, 2, 4, 5, 110, 30, 10, 20, 92, 17, 51, 9};
		// int arr[] = new int[] {1, 2, 4, 3, 8, 6, 12, 10, 7};
		int arr[] = new int[] {14, 8, 6, 12, 10, 7, 4, 1, 2};

		// System.out.println("Before Sorting :" );
		System.out.println("Before partitioning : " +  Arrays.toString(arr) + "\n");

		int pivot = naivePartition(arr, 0, 8, 0);

		System.out.println("\tpivot : " + pivot);
		
	}

	// Naive partitioning
	public static int naivePartition(int arr[], int low, int high, int pivotIdx) {

		int i = low - 1, j = high + 1;
		int pivot = arr[pivotIdx];

		while (true) {

			// System.out.println("=");
			do {
				i++;
				// System.out.println("*");
			} while(arr[i] < pivot);

			do {
				j--;
				// System.out.println("** \t");
			} while(arr[j] > pivot);

			if (i >= j) {
				System.out.println("After partitioning :" + Arrays.toString(arr));
				return j;
			}

			swap(arr, i, j);

		}

	}

	public static void swap(int arr[], int idx, int from) {
		int temp = arr[idx];
		arr[idx] = arr[from];
		arr[from] = temp;
	}
}
	

// // System.out.println




