public class MaxSumWithNoConsecutives {

	public static void main(String[] args) {

		// int arr[] = new int[]{10, 5, 15, 20, 2, 30};
		int arr[] = new int[]{5, 8, 10, 100, 10, 5};

		System.out.println(maxSumRecursion(arr, arr.length));
		
	}

	public static int maxSumRecursion(int arr[], int len) {

		// M-2: Tabulation
		if (len == 1) return arr[0];

		int maxP[] = new int[arr.length+1];

		maxP[1] = arr[0];
		maxP[2] = Math.max(arr[0], arr[1]);

		for (int i = 3; i <= len; i++) {
			maxP[i] = Math.max( maxP[i-1], maxP[i-2] + arr[i-1] );
		}

		return maxP[len];

		// M-1: Naive
		// if (len == 1) return arr[0];
		// if (len == 2) return Math.max(arr[0], arr[1]);

		// return Math.max(maxSumRecursion(arr, len-1), 
		// 				maxSumRecursion(arr, len-2) + arr[len-1]
		// 				);
	}
}