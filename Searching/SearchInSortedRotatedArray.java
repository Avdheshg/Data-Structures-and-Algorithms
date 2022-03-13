public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
			
		// int arr[] = new int[]{10, 20, 30, 40, 50, 8, 9};					

		int arr[] = new int[]{ 40, 50, 8, 9, 10, 20, 30};

		// System.out.println("Index is : " + findIdx(arr, 8));

		System.out.println("Index is : " + naive(arr, 8));

	}

	public static int findIdx(int arr[], int key) {

		int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("low: " + low  + "\thigh: " + high + "\tmid: " + mid);

            if (arr[mid] == num) return mid;

            if (arr[low] <= num && num < arr[mid]) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

		// int low = 0, high = arr.length - 1;

		// while (low <= high) {

		// 	int mid = low + (high - low) / 2;

		// 	if (arr[mid] == key) {
			
		// 		return mid;
			
		// 	} else if (arr[mid] > arr[low]) {			// 1st half of the array is sorted

		// 		if (arr[low] <= key && arr[mid] > key) {

		// 			high = mid - 1;
				
		// 		} else {

		// 			low = mid + 1;

		// 		}
			
		// 	} else {

		// 		if (arr[mid] < key && arr[high] >= key) {

		// 			low = mid + 1;

		// 		} else {

		// 			high = mid - 1;

		// 		}
		// 	}
		// }

		// return -1;
	}

	public static int naive(int arr[], int key) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == key) {

				return i;
			}
		}

		return -1;

	}

}