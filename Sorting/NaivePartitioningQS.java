import java.util.*;

public class NaivePartitioningQS {

	public static void main(String[] args) {

		int arr[] = new int[]{3, 6, 8, 12, 10, 7};
		naive(arr, 5);
		
	}

	public static void naive(int arr[], int pivIdx) {
		System.out.println("before partitioning : " + Arrays.toString(arr));

		int len = arr.length;

		int temp[] = new int[len];
		int idx = 0;
		int piv = arr[pivIdx];

		// saving smaller
		for (int i = 0; i < len; i++) {
			if (arr[i] < piv) {
				temp[idx++] = arr[i];
			}
		}

		// saving equals
		for (int i = 0; i < len; i++) {
			if (arr[i] == piv) {
				temp[idx++] = arr[i];
			}
		}

		int res = idx -1;

		// saving larger
		for (int i = 0; i < len; i++) {
			if (arr[i] > piv) {
				temp[idx++] = arr[i];
			}
		}

		// saving back to the array
		for (int i = 0; i < len; i++) {
			arr[i] = temp[i];
		}

		System.out.println("After partitioning : " + Arrays.toString(arr));
	}

}