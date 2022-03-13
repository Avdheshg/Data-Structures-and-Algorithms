public class FirstOccurence {

	public static void main(String[] args) {
			
		int arr[] = new int[]{1, 10, 10, 20, 20, 20, 20, 40};		// 1, 10, 10, 20, 20, 20, 20, 40		15, 15, 15, 15, 15, 15, 15, 15, 15

		System.out.println("Size : " + (arr.length-1) + "\nOcc :  " + Arrays.toString(searchRange(arr, 20)));

		// System.out.println(findIdxRec(arr, 0, 7, 20, -1));

	}

	int pos(int arr[], int target) {
        
        int len = arr.length;
        int firstPos = len;         
        
        int low = 0, high = len-1;
        
        while(low <= high) {
            
            int mid = (low + high) / 2;
            
            if(arr[mid] >= target) {
                firstPos = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return firstPos;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first = pos(nums, target);
        int last = pos(nums, target+1) -1;
        
        if(first <= last)
            return new int[]{first, last};
        
        return new int[]{-1,-1};
    }






















	// DO IT FROM LEETCODE

	// public static int first(int arr[], int key, boolean findFirst) {

	// 	int low = 0, high = arr.length - 1;
	// 	int requiredOcc = -1;

	// 	while(low <= high) {

	// 		int mid = high - low / 2;

	// 		if (arr[mid] == key) {
	// 			requiredOcc = mid;
	// 			high = mid - 1;
	// 		} else if (arr[mid] > key) {
	// 			high = mid - 1;
	// 		} else {
	// 			low = mid + 1;
	// 		}

	// 	}

	// 	return requiredOcc;

	// }

	// public static int last(int arr[], int key) {

	// 	int low = 0, high = arr.length - 1;
	// 	int requiredOcc = -1;

	// 	while(low <= high) {

	// 		int mid = high - low / 2;

	// 		if (arr[mid] == key) {
	// 			requiredOcc = mid;
	// 			low = mid + 1;
	// 		} else if (arr[mid] > key) {
	// 			high = mid - 1;
	// 		} else {
	// 			low = mid + 1;
	// 		}

	// 	}

	// 	return requiredOcc;
		
	// }

	// public static int findIdxRec(int arr[], int low, int high, int key, int occ) {

	// 	if (low > high) return -1;

	// 	int mid = high - low / 2;

	// 	if (arr[mid] == key) {
			
	// 		if (mid == (arr.length - 1) || arr[mid + 1] != key) {
	// 			return mid;
				
	// 		} else {
	// 			return findIdxRec(arr, mid + 1, high, key, occ);
	// 		}

	// 	} else if (arr[mid] > key) {
	// 		return findIdxRec(arr, low, mid-1, key, occ);
	// 	} else {
	// 		return findIdxRec(arr, mid + 1, high, key, occ);
	// 	}


	// }

	

}