import java.util.*;

public class LomutoPartitioning {

	public static void main(String[] args) {
		
		// int arr[] = new int[] {3, 5, 18, 12, 11, 20, 17, 15};
		// int arr[] = new int[] {70, 60, 80, 40, 30};
		// int arr[] = new int[] {30, 40, 20, 50, 80};
		// int arr[] = new int[] {5, 3, 4, 2,7,9,8, 5};

		int arr[] = new int[] {5, 5, 4, 2,7,9,8, 3};
		lomutoPart(arr, 0, 7);
	}

	public static void lomutoPart(int arr[], int low, int high) {

		int piv = arr[high];
		System.out.println("Before : " + Arrays.toString(arr) + " pivot: " + piv);
		int len = arr.length;
		int win = -1;
		// int win = 0;

		swap(arr, piv, arr[high]);
		System.out.println(Arrays.toString(arr) + " correct pivot at last ");

		for (int i = 0; i < len-1; i++) {
			if (arr[i] < piv) {
				win++;
				System.out.println("swaping : " + arr[i] + " with " + arr[win]);
				swap(arr, i, win);
				// win++;
			}
		}

		swap(arr, len-1, ++win);	
		// swap(arr, len-1, win);	
		System.out.println("Done : " + Arrays.toString(arr) + "\npiv: " + win);
	}

	public static void swap(int arr[], int to, int win) {
		int temp = arr[win];
		arr[win] = arr[to];
		arr[to] = temp;
	}

/*
	When we pass the array from 1 method to anothe method, it is passed by reference, Like in lomutoPart() to swap
*/

}