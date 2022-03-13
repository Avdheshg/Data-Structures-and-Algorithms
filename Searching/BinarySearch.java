public class BinarySearch {

	public static void main(String[] args) {
			
		int arr[] = new int[]{10, 20, 30, 40, 50, 60};

		// naive(arr, 2);
		// BS(arr, 0, 5);
		System.out.println(BSRec(arr, 0, 5, 20));

		// System.out.println("");

	}

	public static int BSRec(int arr[], int low, int high, int key) {

		if (low > high) {
			return -1;
		}

		int mid = high - low / 2;

		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return BSRec(arr, low, mid - 1, key);
		} else {
			return BSRec(arr, mid + 1, high, key);
		}

	}

	public static void BS(int arr[], int low, int high) {

		int key = 20;
		

		while (low <= high) {
			int mid = low + (high - low) / 2;
			System.out.println("-----------");

			if (arr[mid] == key) {

				System.out.println("Found at " + mid);
				return;

			} else if (arr[mid] > key) {

				high = mid - 1;
			
			} else {

				low = mid + 1;
			}

		}

		// while(low <= high)
		// {
		// 	int mid = (low + high) / 2;

		// 	if(arr[mid] == key) {
		// 		System.out.println("found");
		// 		return;
		// 	}

		// 	else if(arr[mid] > key)
		// 		high = mid - 1;

		// 	else
		// 		low = mid + 1;
		// }

		System.out.println("======   -1");

	}

	public static void naive(int arr[], int key) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == key) {
				System.out.println("Found at " + i);
				// return i;
				return;
			}
		}
		System.out.println(" ---= -1 ");
	}

}