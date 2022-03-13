public class MatrixChainMultiplication {

	public static void main(String[] args) {
		
		int arr[] = new int[]{20, 10, 30, 40};

		System.out.println(multiplicationRec(arr, 0, arr.length-1));

	}

	public static int multiplicationRec(int arr[], int startIdx, int len) {

		// if there is only one matrix left
		if (startIdx + 1 == len) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = startIdx+1; i < len; i++) {

			int count = multiplicationRec(arr, startIdx, i) +
						multiplicationRec(arr, i, len) + 
						arr[startIdx] * arr[i] * arr[len];

			min = Math.min(min, count); 
		}

		return min;
	}
}