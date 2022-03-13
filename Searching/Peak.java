public class Peak {

	public static void main(String[] args) {
		
		int arr[] = new int[]{5, 20, 40, 30, 20, 50, 41};

		// System.out.println("Peak is " + naive(arr));

		System.out.println("Peak is " + arr[BS(arr)]);

	}

	public static int BS(int arr[]) {

		int len = arr.length;
		int low = 0, high = len-1;

		if (len == 1) return arr[0];
		if (arr[0] >= arr[1]) return 0;
		if (arr[len-1] >= arr[len-2]) return len-1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]) {

				return mid;

			} else if (arr[mid] <= arr[mid-1]) {

				high = mid-1;

			} else if (arr[mid] <= arr[mid+1]){

				low = mid + 1;

			}
		}

		return -1;
	}



	public static int naive(int arr[]) {

		int peak = -1;
		int len = arr.length;

		for (int i = 1; i < len-2; i++) {

			if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {

				peak = arr[i];
			}
		}

		if (arr[0] > arr[1]) {

			peak = arr[0];
		}

		if (arr[len-1] > arr[len-2]) {

			peak = arr[len-1];
		}

		return peak;
	}

}