import java.util.*;						/* ======= Prove this usign sout ======= */

public class QSLomutoPartitioning {
	public static void main(String[] args) {

		int arr[] = new int[] {8, 4, 7, 9, 3, 10, 5};

		System.out.println("Before Sorted : " + Arrays.toString(arr));

		QSLomuto(arr, 0, 6);

		System.out.println("After Sorted : " + Arrays.toString(arr));
	}

	public static void QSLomuto(int arr[], int left, int right) {

		if (left < right) {

			int pivot = lomutoPartition(arr, left, right);

			QSLomuto(arr, left, pivot-1);
			QSLomuto(arr, pivot + 1, right);

		}

	}

	public static int lomutoPartition(int arr[], int left, int right) {

		/*
			In this function take care about the range given for sorting and 
			Don't include pivot for
		*/
		// System.out.println("in lomutoPartition : right : " + right);

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
		
		// System.out.println("in swap : sortedIndex : " + sortedIndex + "\tfrom : " + from);
		// System.out.print("After swaping : ");
		// for (int i = sortedIndex; i <= from; i++) {
		// 	System.out.print(arr[i] + " ");
		// }
		// System.out.println();
	}


}
