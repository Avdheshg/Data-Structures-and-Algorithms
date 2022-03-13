import java.util.*;

public class Inversion {

	public static void main(String[] args) {
		// int arr[] = new int[]{2, 4, 6, 1, 3, 2, 5, 7};
		int arr[] = new int[]{2, 4, 6, 1, 3, 5, 7};
		// int arr[] = new int[]{40, 30, 20, 10};
		int len = arr.length;
		
		
		// System.out.println("After sorting, inversions: " + naive(arr, arr.length));
		System.out.println("After sorting, inversions: " + MS(arr, 0, arr.length-1));
	 } 


	// Efficient sol
	public static int MS(int arr[], int low, int high) {
		int res = 0;	
		if (low < high) {
			int mid = low + (high-low)/2;
			res += MS(arr, low, mid);
			res += MS(arr, mid+1, high);
			res += merge(arr, low, mid, high);
		}
		return res;
	}

	public static int merge(int arr[], int low, int mid, int high) {
		System.out.println("=======");

		int n1 = mid-low+1;
		int n2 = high-mid;
		int len = arr.length;
		int a[] = new int[n1];
		int b[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			a[i] = arr[low+i];
		}
		for (int i = 0; i < n2; i++) {
			b[i] = arr[(mid+1)+i];
		}
		int i = 0, j = 0, k = low;
		System.out.println("a[] " + Arrays.toString(a) + "\nb[] " + Arrays.toString(b));
		int res = 0;
		while (i < n1 && j < n2) {
			if (a[i] <= b[j]) {
				arr[k++] = a[i++];
			} else {
				arr[k++] = b[j++];
				System.out.println("res: " + res + " + (n1-i) = " + (n1-i));
				res = res + (n1-i);

			}
		}
		while (i < n1) {
			arr[k++] = a[i++];
		}
		while (j < n2) {
			arr[k++] = b[j++];
		}
		return res;
	}




	// Naive
	public static int naive(int arr[], int len) {
		// int count = 0;
		// for (int i = 0; i < len; i++) {
		// 	for (int j = i+1; j < len; j++) {
		// 		if (arr[i] > arr[j]) {
		// 			count++;
		// 		}
		// 	}
		// }
		// System.out.println("count : " + count);
		// return count;

		// using while loop
		
		int i = 0;
		int count = 0;
		while (i < len) {

			boolean isRepeated = false;
			int j = 0;
			while (j < i) {
				if (arr[i] == arr[j]) {
					System.out.println(arr[i] + " is repeated");
					isRepeated = true;
				}
				j++;
			}

			if (isRepeated) {
				i++;
				continue;
			}

			j = i+1;
			while (j < len) {
				if (arr[i] > arr[j]) {
					count++;
				}
				j++;
			}
			
			i++;

		}
		System.out.println("Count: " + count);
		return count;
	}

}