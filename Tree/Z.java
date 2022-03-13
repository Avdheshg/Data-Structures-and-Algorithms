import java.util.*;

public class Z {

	public static void main(String[] args) {
		
		int a1[] = new int[]{2, 5, 7, 9, 14, 17};
		int a2[] = new int[]{3, 6, 8, 11};

		int arr[] = new int[]{2, 5, 7, 9, 14, 17, 3, 6, 8, 11};
		// int arr[] = new int[]{9, 2, 34, 13, 13, 64, 24, 7, 3};
		// int arr[] = new int[]{8, 3, 5, 2, 17, 13, 12, 10, 11};

		// sortTwoArrays(a1, a2);
		MS(arr, 0, 5, arr.length-1);
		// MSRec(arr, 0, arr.length-1);
		// System.out.println("\nComplete sorting \t" + Arrays.toString(arr));
	}

	public static void MSRec(int arr[], int low, int high) {

		if (low < high) {
			
			int mid = low + (high - low)/2;
			
			MSRec(arr, low, mid);
			MSRec(arr, mid+1, high);
			
			MS(arr, low, mid, high);
		}
	}

	public static void MS(int arr[], int low, int mid, int high) {

		int s1 = mid-low+1;
		int s2 = high-mid;

		int a1[] = new int[s1];
		int a2[] = new int[s2];

		for (int i = low; i < s1; i++) {
			a1[i] = arr[low+i];
		}

		for (int i = 0; i < s2; i++) {
			a2[i] = arr[(mid+1) + i];
		}

		System.out.println("Broken arrays, a1: " + Arrays.toString(a1) + "\t a2 : " + Arrays.toString(a2));

		// sortTwoArrays(arr, a1, a2);

		int idx = 0;
		int i = 0, j = 0;

		while (i < s1 && j < s2) {

			if (a1[i] <= a2[j]) {
				arr[idx++] = a1[i++];
			} else {
				arr[idx++] = a2[j++];
			}
		}

		while (i < s1) {
			arr[idx++] =  a1[i++];
		}

		while (j < s2) {
			arr[idx++] =  a2[j++];
		}

		System.out.println("After sorting till, " + arr[arr.length-1] + "\t" + Arrays.toString(arr));
	}

	// public static void sortTwoArrays(int arr[], int a1[], int a2[]) {

	// 	int s1 = a1.length;
	// 	int s2 = a2.length;

	// 	// int arr[] = new int[s1 + s2];
	// 	int idx = 0;
	// 	int i = 0, j = 0;

	// 	while (i < s1 && j < s2) {

	// 		if (a1[i] <= a2[j]) {
	// 			arr[idx++] = a1[i++];
	// 		} else {
	// 			arr[idx++] = a2[j++];
	// 		}
	// 	}

	// 	while (i < s1) {
	// 		arr[idx++] =  a1[i++];
	// 	}

	// 	while (j < s2) {
	// 		arr[idx++] =  a2[j++];
	// 	}

	// 	System.out.println("After sorting till, " + arr[arr.length-1] + "\t" + Arrays.toString(arr));
	// }
}