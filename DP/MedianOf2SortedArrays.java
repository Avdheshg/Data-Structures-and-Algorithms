public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		
		int a1[] = new int[]{2, 3, 5, 8};    // 10, 20, 30, 40, 50  
		int a2[] = new int[]{10, 12, 14, 16, 18, 20};     // 5, 15, 25, 30, 35, 55, 65, 75, 85

		System.out.println(median(a1, a2, a1.length, a2.length));

	}

	// Wrong OP

	public static double meadian(int a1[], int a2[], int len1, int len2) {

		// Define low and high
		int low = 0, high = len1;

		while (low <= high) {

			// find i1 and i2
	        int mid1 = (0 + len1)/2;
	        int mid2 = (len1 + len2+1)/2 - mid1;

	        // Find max1, max2, min1, min2
	        int max1 = (mid1 == 0) ? Math.MIN_VALUE : (mid1-1);
	        int max2 = (mid2 == 0) ? Math.MIN_VALUE : (mid2-1);

	        int min1 = (mid1 == len1) ? Math.MAX_VALUE : mid1;
	        int min2 = (mid2 == len2) ? Math.MAX_VALUE : mid2;

	        /* ========= Applying the BS ========  */
	        // Do V have found the correct position i.e found the midean where all set1 <= set2
	            // if yes then return the ans wrt the length of the array
	        int maxOfSmall = Math.max(max1, max2);
	        int minOfLarge = Math.min(min1, min2);
	        
	        if (maxOfSmall <= minOfLarge) {

	            if ( (len1+len2) % 2 == 0) {
	                return (maxOfSmall + minOfLarge) / 2;
	            } else {
	                return maxOfSmall;
	            }
	        } else if (max1 > min2) {

	            // If V R here means that V R not at the point of right median
	            high = mid1-1;				
	        } else {
	            low = mid1+1;
	        }


		}


	}
}