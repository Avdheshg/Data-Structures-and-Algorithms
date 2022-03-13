public class LIS {

	public static void main(String[] args) {
		
		int arr[] = new int[]{3, 4, 2, 8, 10	};			// 10, 5, 8, 7, 2, 9

		System.out.println("LIS: " + lis(arr, arr.length));

	}

	public static int lis(int arr[], int len) {

	    // Because a single number can be a subsequence too
	    int max_ans = 1;

	    for(int i = 0; i <= len-1; i++)
	        max_ans = Math.max(max_ans, lis_ending_here(arr, i));

	    return max_ans;
	}

	public static int lis_ending_here(int arr[], int curr) {

	    // Only one subsequence ends at first index, the number itself
	    if(curr == 0)
	        return 1;

	    int ans = 1;

	    for(int i = curr-1; i >= 0; i--) {
	        if(arr[i] < arr[curr])
	            ans = Math.max(ans, 1 + lis_ending_here(arr, i));
	    }
	    return ans;
	}


}