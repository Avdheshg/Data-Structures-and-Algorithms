
import java.util.*;

public class Sort2Types {

	public static void main(String[] args) {

		// int arr[] = new int[] {-2, -3, 15, 18};
		// int arr[] = new int[] {8, -5, 6, -3, -7, 11, -2};
		// int arr[] = new int[] {2,3,4,5,6,7,8,9};
		int arr[] = new int[] {0, 1, 0, 1, 0, 1, 0, 1};

		int left = 0, right = arr.length-1;
		hoareSort(arr, left, right);

		System.out.println("After segregation : " + Arrays.toString(arr));

		// naiveSort(arr);

		
	}

	// Efficient Solution
	public static void hoareSort(int arr[], int left, int right) {

		System.out.println("Before segregation : " + Arrays.toString(arr));

		int i = left-1;
		int j = right + 1;

		int pivot = 0;

		while (true) {

			do {
				i++;
				System.out.println("i : " + i + "\t");
			// } while (arr[i] == 0);
			} while (arr[i] < 1);
				
			do {
				j--;
				System.out.println("j : " + j + "\t");
			// } while (arr[j] == 1);	
			} while (arr[j] >= 1);	

			if (i >= j) return;

			swap(arr, i, j);

		}

		// 

		/*	
			For pos and neg :
				while (arr[i] < pivot);
				while (arr[j] >= pivot);

			For Odd even : 
				while (arr[i] % 2 == 0);
 				while (arr[j] % 2 != 0);
		*/
		
	}

	public static void swap(int arr[], int ele, int from) {
		int temp = arr[ele];
		arr[ele] = arr[from];
		arr[from] = temp;
	}

	




	// Naive Solution
	// public static void naiveSort(int arr[]) {

	// 	int len = arr.length;
	// 	int idx = 0;

	// 	int temp[] = new int[len];

	// 	for (int i = 0; i < len; i++) {
	// 		if (arr[i] < 0) {
	// 			temp[idx++] = arr[i];
	// 		}
	// 	}

	// 	for (int i = 0; i < len; i++) {
	// 		if (arr[i] >= 0) {
	// 			temp[idx++] = arr[i];
	// 		}
	// 	}

	// 	for (int i = 0; i < len; i++) {
	// 		arr[i] = temp[i];
	// 	}

	// 	System.out.println("After segregation : " + Arrays.toString(arr));
	// }


}