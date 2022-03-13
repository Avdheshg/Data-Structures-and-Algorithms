public class SubsetSum {

	public static void main(String[] args) {
		
		int arr[] = new int[]{3, 34, 4, 12, 5, 2};					// {10, 20, 15};      25
		int sum = 9;

		System.out.println(subsetSumRec(arr, arr.length, sum));

	}

	public static int subsetSumRec(int arr[], int len, int sum) {

		if (len == 0) {
			// if (sum == 0) return 1;
			// else return 0;

			return (sum == 0) ? 1 : 0;
		}

		return subsetSumRec(arr, len-1, sum) +
				subsetSumRec(arr, len-1, sum - arr[len-1]);
	}
}