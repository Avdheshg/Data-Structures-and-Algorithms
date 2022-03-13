import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		
		int arr[] = new int[]{12, 31, 9, 4, 82, 15, 27, 35};

		MS(arr, 0, arr.length-1);

		System.out.println("After sorting " + Arrays.toString(arr));

	}

	public static void MS(int arr[], int low, int high) {

		if (low < high) {

			int mid = low + (high-low)/2;

			MS(arr, low, mid);
			MS(arr, mid+1, high);

			merge(arr, low, mid, high);

		}
	}

	public static void merge(int arr[], int low, int mid, int high ) {

		int len1 = mid-low+1;
		int len2 = high-mid;

		int a[] = new int[len1];
		int b[] = new int[len2];

		for (int i = 0; i < len1; i++) {
			a[i] = arr[low + i];
		}

		for (int i = 0; i < len2; i++) {
			b[i] = arr[ (mid+1) + i];
		}

		// System.out.println("a[] " + Arrays.toString(a) + "\nb[] " + Arrays.toString(b) + "\narr[] " + Arrays.toString(arr));

		int i = 0, j = 0, idx = low;

		while (i < len1 && j < len2) {
			if (a[i] <= b[j]) {
				arr[idx++] = a[i++];
				// arr[idx++] = b[j++];
				// j++;
				// System.out.println("Equals");
			} else if (a[i] > b[j]) {
				arr[idx++] = b[j++];
			} 
		}

		System.out.println("i " + i + " len " + len1);
		while (i < len1) {
			arr[idx++] = a[i++];
		}


		while (j < len2) {
			arr[idx++] = b[j++];
		}

		System.out.println("\na[]: " + Arrays.toString(a) + "\nb[]: " + Arrays.toString(b) +"\narr[]: " + Arrays.toString(arr) +  "\n");

	}

}