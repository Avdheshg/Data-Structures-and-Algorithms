public class SearchInInfiniteArray {

	public static void main(String[] args) {
			
		int arr[] = new int[]{1, 10, 15, 20, 40, 60, 80, 100, 200, 500, 1000, 2000, 4000, 4500, 8765, 9543, 10345, 11345, 12654, 13567, 15765, 16234};

		int idx = findIdx(arr, 40);

		System.out.println("Found at " + idx + ". Element at this idx is : " + arr[idx]);

	}

	public static int findIdx(int arr[], int key) {

		int low = 0, high = 2;
		int pos = -1;

		while (low <= high) {
			int mid = low + (high-low)/2;

			System.out.println("Start: mid " + mid + " low: " + low + " high " + high); 

			System.out.println("arr[mid]: " + arr[mid] + " key: " + key); 
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid;
				high *= high;
				pos = mid;
			} else {
				high = mid-1;
			}

			System.out.println("End:\t mid " + mid + " low: " + low + " high " + high); 
		}

		System.out.println("Retun idx " + pos);
		return pos;

	}

	// public static int findIdx(int arr[], int key) {

	// 	System.out.println(arr.length);

	// 	if(arr[0] == key) return 0;

	// 	int high = 1;
	// 	int low = 0;

	// 	while (arr[high] < key) {
	// 		low = high;
	// 		high *= 2;
	// 	}

	// 	if (arr[high] == key) return high;

	// 	return BS(arr, low, high-1, key);

		// int idx = 1;

		// while(arr[idx] < key){
		// 	idx = idx * 2;
		// 	 	System.out.println("------- idx : " + idx);
		// }

		// if(arr[idx] == key) return idx;

		// return BS(arr, (idx/2) + 1, idx - 1, key );

	// }

	public static int BS(int arr[], int low, int high, int key) {

		int ans = 0;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] == key) {
			
				return mid;
			
			} else if (arr[mid] > key) {

				high = mid - 1;
			
			} else {

				ans = mid;
				low = mid + 1;

			}
		}

		return ans;
	}

}