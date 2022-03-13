public class AllocateMinPages {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{10, 20, 30, 40};
		int arr[] = new int[]{12, 34, 67, 90};
		int students = 2;

		System.out.println(minPageRec(arr, arr.length, students));

	}

	public static int minPageRec(int arr[], int len, int students) {

		if (students == 1) {
			return totPages(arr, 0, len-1);
		}
		if (len == 1) {
			return arr[0];
		}

		int minPages = Integer.MAX_VALUE;
		int count ;

		for (int i = 1; i < len; i++) {
			count = Math.max(minPageRec(arr, i, students-1),
							totPages(arr, i, len-1)
							);

			minPages = Math.min(minPages, count);
		}

		return minPages;

	}

	public static int totPages(int arr[], int stIdx, int endIdx) {
		int sum = 0;

		for (int i = stIdx; i <= endIdx; i++) {
			sum += arr[i];
		}

		return sum;
	}
}



// #D4C8C3

// 25/11/21  12:08:00
// 25/11/21  12:28:00

// Age 35 Yrs  M