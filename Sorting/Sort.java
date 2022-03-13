import java.util.*;

// public class Name {

// 	public static void main(String[] args) {

		// int arr[] = new int[] {8, 4, 7, 9, 3, 10, 5};
	

// 	}
// }


// int arr1[] = new int[] {5, 10, 10, 15, 30};

public class Sort {
	// System.out.println();

	// static int arr1[] = new int[]{5, 1, 4, 2, 8};
	// static int arr[] = new int[]{14, 33, 27, 35, 10};
	// static int arr[] = new int[] {10, 15, 20,  11, 30};
	// static int arr[] = new int[] {5, 8, 12, 14, 7};

	// static int arr1[] = new int[]{10, 20, 50};
	// static int arr2[] = new int[]{5, 50, 50, 80, 90};

	static int arr2[] = new int[] {3, 5, 10, 10, 10, 15, 15, 20, 20};
	static int arr1[] = new int[] {5, 10, 10, 15, 30};

	// static int arr1[] = new int[] {1, 1, 3, 3, 3};
	// static int arr2[] = new int[] {1, 1, 1, 1, 3, 5, 7};


	public static void main(String args[]) {

		int s1 = arr1.length, s2 = arr2.length;

		// for (int i = 0; i < s1; i++) {
		// 	if (i > 0 && arr1[i] == arr1[i-1]){
				// i++;
				// 		continue;
			// }
		// 	for (int j = 0; j < s2; j++) {
		// 		if (arr1[i] == arr2[j]) {
		// 			System.out.println(arr1[i]);
		// 			break;
		// 		}
		// 	}
		// }

		int i = 0, j = 0;

		while (i < s1 && j < s2) {

			if (i > 0 && arr1[i] == arr1[i-1]){
				i++;
				continue;
			}
			if (j > 0 && arr2[j] == arr2[j-1]){
				j++;
				continue;
			}

			if (arr1[i] == arr2[j]) {
				System.out.println(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] > arr2[j]) {
				System.out.println(arr2[j]);
				j++;
			} else {
				System.out.println(arr1[i]);
				i++;
			}
		}

		while (i < s1) {
			System.out.println(arr1[i]);
			i++;
		}
		
		while (j < s2) {
			System.out.println(arr2[j]);
			j++;
		}

		// int s1 = arr1.length, s2 = arr2.length;
		// int i = 0, j = 0;
		// int lastEqual = Integer.MAX_VALUE;

		// while (i < s1 && j < s2) {

		// 	if (arr1[i] == arr2[j]) {
		// 		if (arr1[i] != lastEqual) {
		// 			System.out.println(arr1[i]);
		// 			lastEqual = arr1[i];
		// 		}
		// 		i++;
		// 		j++;
		// 	} else if (arr1[i] > arr2[j]) {
		// 		j++;
		// 	} else {
		// 		i++;
		// 	}
		// }

		
		// int[] leftArr = new int[leftSize];
		// int[] rightArr = new int[rightSize];

		// for (int i = 0; i < leftSize; i++) {
		// 	leftArr[i] = arr[low + i];
		// }

		// for (int i = 0; i < rightSize; i++) {
		// 	rightArr[i] = arr[mid + i + 1];
		// }

		// System.out.println("leftArr : " + Arrays.toString(leftArr) + "\t\t rightArr : " + Arrays.toString(rightArr) );

		// // System.out.println("Before sorting : " + Arrays.toString(bigArr));

		// int i = 0, j = 0, k = 0;

		// while (i < leftSize && j < rightSize) {

		// 	if (leftArr[i] <= rightArr[j]) {
		// 		// System.out.print(arr[lowIdx] + " & " + arr[midIdx]);
		// 		arr[k++] = leftArr[i];
		// 		i++;

		// 	} else  {
		// 		arr[k++] = rightArr[j];
		// 		j++;
		// 	}
		// }

		// while (i < leftSize) {
		// 	arr[k++] = leftArr[i];
		// 	i++;
		// }
		
		// while (j < rightSize) {
		// 	arr[k++] = rightArr[j];
		// 	j++;
		// }

		// System.out.println("After sorting : " + Arrays.toString(arr));

	}








	// public static void swap(int low, int high) {
	// 		int temp = arr[low];
	// 		arr[low] = arr[high];
	// 		arr[high] = temp;
	// 	}


}