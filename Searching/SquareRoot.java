public class SquareRoot {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{0, 1, 2, 4, 9, 16, 25, 36, 49, 64, 81, 100};

		// System.out.println("Found at " + findSquare(50));

		System.out.println("Found at " + naive(2147395600));

	}

	public static int naive( int key) {

		 int i = 0;

		while((i * i) <= key) {
			System.out.println("square " + (i*i) + " for i: " + i);
			i++;
		}
		return i-1;

	}

	// public static int findSquare(int key) {

	// 	int low = 1, high = key;
	// 	int ans = -1;

	// 	while (low <= high) {

	// 		int mid = low + (high - low) / 2;

	// 		int midSq = mid * mid;

	// 		System.out.println("Mid : " + mid + "\tmidSq : " + midSq);

	// 		if (midSq == key) {
	// 			System.out.println("Found ");
	// 			return mid;
	// 		} else if (midSq > key) {
	// 			high = mid - 1;
	// 		} else {
	// 			low = mid + 1;
	// 			ans = mid;
	// 		}

	// 	}

	// 	return ans;
	// }


	
}