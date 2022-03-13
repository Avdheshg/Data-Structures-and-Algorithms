public class NumOfOccurrences {

	public static void main(String[] args) {
			
		int arr[] = new int[]{0, 0, 0};		// 1, 10, 10, 20, 20, 20, 20, 40		15, 15, 15, 15, 15, 15, 15, 15, 15

		System.out.println("Size : " + (arr.length-1) + "\nOcc :  " + findIdx(arr, 1));

		// System.out.println(findIdxRec(arr, 0, 7, 20, -1));

	}

	public static int findIdx(int arr[], int key) {

		int firstOcc = occ(arr, key, true);
		int lastOcc = occ(arr, key, false);

		if (firstOcc == -1 ) return -1;
		
		return (lastOcc - firstOcc) + 1;

	}

	public static int occ(int arr[], int key, boolean findFirst) {

		int low = 0, high = arr.length - 1;
		int requiredOcc = -1;

		while(low <= high) {

			int mid = high - low / 2;

			if (arr[mid] == key) {
				requiredOcc = mid;

				if (findFirst) {
					high = mid - 1;	
				} else {
					low = mid + 1;
				}
				
			} else if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return requiredOcc;

	}
}