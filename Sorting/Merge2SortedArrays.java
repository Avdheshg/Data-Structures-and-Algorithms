import java.util.*;

public class Merge2SortedArrays {

	public static void main(String[] args) {
			
		int a[] = new int[]{1, 4, 5, 7, 10, 14, 60};
		int b[] = new int[]{2, 4, 5, 6, 13, 14, 35, 55};

		merge(a, b);

	}

	public static void merge(int a[], int b[]) {

		System.out.println("a[] " + Arrays.toString(a) + "\nb[] " + Arrays.toString(b));

		int len1 = a.length;
		int len2 = b.length;

		int arr[] = new int[len1+len2];

		int i = 0, j = 0, idx = 0;

		while (i < len1 && j < len2) {
			if (a[i] == b[j]) {
				arr[idx++] = a[i];
				arr[idx++] = a[i];
				i++;
				j++;
			} else if (a[i] > b[j]) {
				arr[idx++] = b[j];
				j++;
			} else {
				arr[idx++] = a[i];
				i++;
			}
		}

		while (i < len1) {
			arr[idx++] = a[i++];
		}

		while (j < len2) {
			arr[idx++] = b[j++];
		}

		System.out.println("After sortin " + Arrays.toString(arr));
	}
}