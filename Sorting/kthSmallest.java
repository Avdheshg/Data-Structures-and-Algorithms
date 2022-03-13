import java.util.*;

public class kthSmallest {

	public static void main(String[] args) {

		// int arr[] = new int[] {8, 4, 7, 9, 3, 10, 5};
		// int arr[] = new int[] {30, 20, 5, 10, 8};
		// int arr[] = new int[] {3,2,3,1,2,4,5,5,6};
		int arr[] = new int[] {10, 4, 5, 8, 11, 6,26};
		
		kthSmallest(arr, 5);
		Arrays.sort(arr);
		System.out.println("After sorting: " + Arrays.toString(arr));

	}

	public static void kthSmallest(int arr[], int k) {

		// Something missing in method 2
		int left = 0, right = arr.length - 1;
		System.out.println("=====BS");
		while (left <= right) {

			int pos = lomutoPartition(arr, left, right);

			if (pos == (k-1)) {
				System.out.println("Found at : " + pos + " element is : " + arr[pos]);
				return;
			}
			else if (pos > (k-1))
				right = pos - 1;
			else
				left = pos + 1;
		}
		System.out.println("Not found");


		/*================ METHOD 1 =========================================*/
		// QSLomuto(arr, 0, right);		// this will give the sorted array


		// // for (int i = 0; i < arr.length; i++) {
		// // 	if (i == (k-1)) {
		// // 		System.out.println(arr[i]);
		// // 	}
		// // }

		// // Use this method to find the kth smallest in the sorted element
		// System.out.println(arr[k-1]);
	}

	public static void QSLomuto(int arr[], int left, int right) {

		if (left < right) {

			int pivot = lomutoPartition(arr, left, right);

			QSLomuto(arr, left, pivot-1);
			QSLomuto(arr, pivot + 1, right);

		}

	}

	public static int lomutoPartition(int arr[], int left, int right) {

		int pivot = arr[right];
		int sortedIndex = left-1;

		for (int i = left; i <= right-1; i++) {

			if (arr[i] < pivot) {
				sortedIndex++;
				swap (arr, sortedIndex, i);
			}
		}

		swap(arr, ++sortedIndex, right);

		return sortedIndex;
	}

	public static void swap(int arr[], int sortedIndex, int from) {
		
		int temp = arr[sortedIndex];
		arr[sortedIndex] = arr[from];
		arr[from] = temp;
	}


}

/*
	
*/