import java.util.*;

public class Z {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{3, 8, 6, 12, 10, 7};		10, 80, 90, 40, 50, 70
		int arr[] = new int[]{8, 5, 9, 3, 13, 2, 0, 1};

		System.out.println("Before sorting : " + Arrays.toString(arr));
		// naive(arr, 0, 5, 5);
		// lomuto(arr, 0, 9, 5);

		// hoare(arr, 0, 9, 4);

		QSHoare(arr, 0, 7);		
		
		System.out.println("After sorting : " + Arrays.toString(arr));
	}

	public static void QSHoare(int arr[], int low, int high) {

		if (low < high) {
			int pivot = hoare(arr, low, high);
			QSHoare(arr, low, pivot);
			QSHoare(arr, pivot + 1, high);

			// System.out.println("arr - > " + Arrays.toString(arr));
		}

	}

	public static void QSLomuto(int arr[], int low, int high) {

		if (low < high) {
			int pivot = lomuto(arr, low, high);
			QSLomuto(arr, low, pivot - 1);
			QSLomuto(arr, pivot + 1, high);

			System.out.println("arr - > " + Arrays.toString(arr));
		}

	}

	public static int hoare(int arr[], int low, int high) {

		// swap(arr, low, pIdx);
		System.out.println("Before partition : " + Arrays.toString(arr));

		int i = low - 1, j = high + 1;
		int pivot = arr[low];

		while (true) {

			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j) {
				// System.out.println("After partition " + Arrays.toString(arr));
				return j;
			}

			swap(arr, i, j);
		}

	}

	public static int lomuto(int arr[], int low, int high) {

		// swap(arr, pivotIdx, high);
		// System.out.println("Pivot swapped : " + Arrays.toString(arr));

		int pivot = arr[high];

		int win = low - 1;

		for (int i = low; i <= high - 1; i++) {

			if (arr[i] < pivot) {
				win++;
				swap(arr, win, i);
			}
		}

		swap(arr, ++win, high);

		System.out.println("lomuto : " + Arrays.toString(arr) + " win = " + win);
		return win;
	}

	public static void swap(int arr[], int ele, int from) {
		System.out.println("Swaping " + arr[ele] + " from " + arr[from]);
		int temp = arr[ele];
		arr[ele] = arr[from];
		arr[from] = temp;
	}


	public static void naive(int arr[], int low, int high, int pivotIdx) {

		int pivot = arr[pivotIdx];
		int size = arr.length;

		int aux[] = new int[arr.length];
		int idx = 0;

		for (int i = low; i <= high; i++) {
			if (arr[i] < pivot) {
				aux[idx++] = arr[i];
			}
		}

		for (int i = low; i <= high; i++) {
			if (arr[i] == pivot) {
				aux[idx++] = arr[i];
			}
		}

		for (int i = low; i <= high; i++) {
			if (arr[i] > pivot) {
				aux[idx++] = arr[i];
			}
		}

		// saving back to the original array
		for (int i = low; i <= high; i++) {
			arr[i] = aux[i];
		}

		System.out.println("After partition : " + Arrays.toString(arr));
	}

	
}