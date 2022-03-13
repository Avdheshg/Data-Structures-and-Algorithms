import java.util.*;

public class Partitioning {

	public static void main(String[] args) {
	
		int arr[] = new int[]{5, 1, 4, 2, 8, 7, 9};

		makePartition(arr,0, 6, 5);

	}

	public static void makePartition(int arr[],int low, int high, int key) {

		int temp[] = new int[high - low + 1];
		int index = 0;

		/*
			save small 
				key
				large
			save back 
		*/

		System.out.println("before : " + Arrays.toString(arr));					

		for (int i = low; i <= high; i++) {

			if (arr[i] <= arr[key] & i != key) {
				temp[index++] = arr[i];
			}
		}

		temp[index++] = arr[key];

		for (int i = low; i <= high; i++) {

			if (arr[i] > arr[key]) {
				temp[index++] = arr[i];
			}
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temp[i-low];
		}

		System.out.println("after : " + Arrays.toString(arr));
	}


}