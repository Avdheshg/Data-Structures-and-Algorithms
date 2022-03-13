import java.util.*;

public class QSHoaresPartition  {

	public static void main(String[] args) {

		// int arr[] = new int[] {8, 4, 7, 9, 3, 10, 5};
		// int arr[] = new int[] {5, 8, 13, 2, 6, 4, 8, 9, 5};
		int arr[] = new int[] {8,7,6,1,0,9,2};
		
		System.out.println("Before Sorted : " + Arrays.toString(arr));

		QSHoares(arr, 0, 6);

		System.out.println("After Sorted : " + Arrays.toString(arr));

	}

	public static void QSHoares(int arr[], int left, int right) {

		if (left < right) {
			System.out.println("In the functio ");
			int pivot = hoaresPartition(arr, left, right);
			QSHoares(arr, left, pivot);
			QSHoares(arr, pivot + 1, right);
		}

	}

	public static int hoaresPartition(int arr[], int left, int right) {

		int pivot = left;
		System.out.println("piv: " + arr[left] + " called from " + left + " to " + right);
		int i = left - 1;
		int j = right + 1;
		

		while (true) {

			do {
				i++;
				// System.out.println("For smaller, i " + i + " arr[i] < arr[pivot]: " + arr[i] + " " + arr[pivot] + " => " + (arr[i] < arr[pivot]));
			} while (arr[i] < arr[pivot]);
			System.out.println(arr[i] + " is not < pivot"  + " piv: " + arr[left]);
			do {
				j--;
				// System.out.println("j " + j + " arr[j] > arr[pivot]: " + arr[j] + " " + arr[pivot] + " => " + (arr[j] > arr[pivot]));
			} while (arr[j] > arr[pivot]);
			System.out.println(arr[j] + " is not > pivot" + " piv: " + arr[left]);
			// System.out.println("swapping : " + arr[i] + " with " + arr[j]);

			if (i >= j) return j;

			System.out.println("swapping : " + arr[i] + " with " + arr[j] + " piv: " + arr[left]);
			swap(arr, i, j);
			System.out.println("After swaping arr: " + Arrays.toString(arr) + "\n");
		}

	}

	public static void swap(int arr[], int sortedIndex, int from) {
		
		int temp = arr[sortedIndex];
		arr[sortedIndex] = arr[from];
		arr[from] = temp;
		
		// System.out.println("swapping : " + arr[sortedIndex] + " with " + arr[from]);
		// System.out.println("in swap : sortedIndex : " + arr[sortedIndex] + "\tfrom : " + arr[from]);
		// System.out.println("After swaping arr: " + Arrays.toString(arr) + "\n");
		// for (int i = sortedIndex; i <= from; i++) {
		// 	System.out.print(arr[i] + " ");
		// }
		// System.out.println();
	}

}