import java.util.*;

public class Sort3Types {

	public static void main(String[] args) {

		// int arr[] = new int[] {0, 1, 0, 2, 1, 2};
		// int arr[] = new int[] {2, 1, 2, 20, 10, 20, 1};
		int arr[] = new int[] {10, 5, 6, 3, 20, 9, 40};
		
		System.out.println("Before segregation : " + Arrays.toString(arr));

		// efficientSort1(arr);
		efficientSort2(arr);

		System.out.println("After segregation : " + Arrays.toString(arr));
	}

	public static void efficientSort2(int arr[]) {

		int len = arr.length;
		int left = 0, mid = 0, right = len-1;

		while (mid <= right) {

			if (arr[mid] < 5) {
				swap(arr, left, mid);
				left++;
				mid++;
			} else if (arr[mid] >= 5 && arr[mid] <= 10) {
				mid++;
			} else {
				swap(arr, mid, right);
				right--;
			}

		}

		/*	
			For 0s, 1s and 2s
				if (arr[mid] == 0) 
				else if (arr[mid] == 1)

			For left < 2 < right
				pivot = 2
		*/
	} 

	public static void swap(int arr[], int ele, int from) {
		System.out.println("swapping ele : " + arr[ele] + " at " + ele + " with ele :" + arr[from] + " at " + from);
		int temp = arr[ele];
		arr[ele] = arr[from];
		arr[from] = temp;
	}


	/*
		this method is efficient but using 2 trvaersals of the array
		V need more effiecient which can do the work in one traversal

		V can also do this by using the 3 traversals of the array with Lomuto partition
	*/

	// public static void efficientSort1(int arr[]) {

	// 	System.out.println("Before segregation : " + Arrays.toString(arr));

	// 	int idx = 0, count = 0;
	// 	int len = arr.length;

	// 	for (int i = 0; i < len; i++) {
	// 		if (arr[i] == 2) {
	// 			idx = i;
	// 			count++;
	// 		} else {
	// 			swap (arr, idx, i);
	// 		}	
	// 	}

	// 	int left = 0, right = (len - 1) - count;
	// 	hoares(arr, left, right);

	// 	System.out.println("After 2s : " + Arrays.toString(arr));

	// }

	// public static void hoares(int arr[], int left, int right) {

	// 	int i = left - 1;
	// 	int j = right + 1;

	// 	while (true) {

	// 		do{
	// 			i++;
	// 		} while (arr[i] == 0);

	// 		do{
	// 			j--;
	// 		} while (arr[j] == 1);

	// 		if (i >= j) return;

	// 		swap(arr, i, j);
	// 	}
	// }



	// public static void swap (int arr[], int ele, int from) {
	// 	int temp = arr[ele];
	// 	arr[ele] = arr[from];
	// 	arr[from] = temp;
	// }

	/*
		Naive apporach :
			temp space with 4 traversals
	*/
}