import java.util.*;

public class HoaresPartition {
	public static void main(String[] args) {

		int arr[] = new int[] {5, 3, 8, 4, 2, 7, 1, 10};
		// int arr[] = new int[] {8, 4, 7, 9, 3, 10, 5};				// X

		hoares(arr, 0, 6);

	}

	public static void hoares(int arr[], int left, int right) {

		System.out.println("Before : " + Arrays.toString(arr));

		int i = left - 1;
		int j = right + 1;
		// int key = 0;    				// This and X will give indexOutOfBoundException
		int key = arr[left];

		while (true) {


			do {
				i++;
				System.out.println("i : " + i);
			} while (arr[i] < key);

			do {
				j--;
				System.out.println("j : " + j);
			} while (arr[j] > key);

			System.out.println("i : " + i + "\tj : " + j);
			if (i >= j) {
				System.out.println("After : " + Arrays.toString(arr));
				return ;

			} 

			swap (arr, i, j);
		}

		
		// return j;
	}

	public static void swap(int arr[], int to, int win) {
		int temp = arr[win];
		arr[win] = arr[to];
		arr[to] = temp;
	}


}