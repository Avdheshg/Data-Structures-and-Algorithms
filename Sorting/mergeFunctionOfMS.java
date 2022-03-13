import java.util.*;

public class mergeFunctionOfMS {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{10,15,20,11,30};
		int arr[] = new int[]{1, 4, 5, 7, 10, 14, 60, 2, 4, 5, 6, 13, 14, 35, 55};

		mergeMS(arr, 0, 6, 14);

	}

	public static void mergeMS(int arr[], int low, int mid, int high) {

		int len = arr.length;
		int l1 = mid - low + 1;
		int l2 = high - mid;

		System.out.println("Len: " + len + " l1 : " + l1 + " l2 " + l2);

		int a[] = new int[l1];
		int b[] = new int[l2];

		for (int i = 0; i < l1; i++) {
			a[i] = arr[i];
		}

		for (int i = 0; i < l2; i++) {
			b[i] = arr[ (mid+1) +i];
		}

		System.out.println("Arr : " + Arrays.toString(arr) + "\na[] : " + Arrays.toString(a) + "\nb[] : " + Arrays.toString(b));

		arr = merge(arr, a, b);

		System.out.println("After merging arr[] " + Arrays.toString(arr));

	}

	public static int[] merge(int arr[], int a[], int b[]) {
		int len1 = a.length; 
		int len2 = b.length;

		int i = 0, j = 0, idx = 0;

		while (i < len1 && j < len2) {
			// if (a[i] == b[j]) {
			// 	arr[idx++] = a[i];
			// 	arr[idx++] = b[j];
			// 	i++;
			// 	j++;
			// } else if (a[i] > b[j]) {
			// 	arr[idx++] = b[j];
			// 	j++;
			// } else {
			// 	arr[idx++] = a[i++];
			// }

			if (a[i] <= b[j]) {
				arr[idx++] = a[i++]; 
			} else {
				arr[idx++] = b[j++];
			}
		}

		while (i < len1) {
			arr[idx++] = a[i++];
		}

		while (j < len2) {
			arr[idx++] = b[j++];
		}

		return arr;
	}

}