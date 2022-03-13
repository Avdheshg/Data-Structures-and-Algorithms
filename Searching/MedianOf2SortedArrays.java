import java.util.*;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {
		
		// int arr1[] = new int[]{10, 20, 30, 40, 50};
		// int arr2[] = new int[]{5, 15, 25, 35, 45};

		int arr1[] = new int[]{1, 2, 3, 4, 5, 6};
		int arr2[] = new int[]{10, 20, 30, 40, 50};

		System.out.println("Median is " + getMedian(arr1, arr2));

		// int sum = 25 + 30;
		// System.out.println("sum : " + sum + ", sum/2 " + sum/2 + ", total Sum : " + (sum/2 + sum))


	}

	// Efficient solution
	public static double getMedian(int a1[], int a2[]) {

		// a1 needs to be smaller or = to a2

		int n1 = a1.length, n2 = a2.length;

		int begin1 = 0, end1 = n1;

		while (begin1 <= end1) {
			int i1 = (begin1 + end1)/2;
			int i2 = ((n1+n2+1)/2) - i1;

			int min1 = (i1 == n1) ? Integer.MAX_VALUE:a1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE:a1[i1-1];

			int min2 = (i2 == n2) ? Integer.MAX_VALUE:a2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE:a2[i2-1];

			// If this condition becomes true then V will stop our BS => means V have found the correct orientation of both the arrays and now V just need to return odd or even
			if (max1 <= min2 && max2 <= min1) {
				if ((n1+n2) % 2 == 0) 
					return ((double) Math.max(max1, max2) + 
									 Math.min(min1, min2)) / 2;

				else 
					return (double) Math.max(max1, max2);
				
			
			} else if (max1 > min2) 
				end1 = i1-1;

			else if (max2 > min1) {
				begin1 = i1+1;
			}
		}

		return -1;
	}

	public static int naive(int arr1[], int arr2[]) {

		int oneArray[] = combineArray(arr1, arr2);

		int bigSize = oneArray.length;
		int mid1 = (bigSize-1) / 2;

		if (oneArray.length % 2 == 0) {
			int mid2 = mid1 + 1;

			int sum = oneArray[mid1] + oneArray[mid2];

			sum = sum/2 + sum%2;

			return sum;
		
		} else {

			return oneArray[mid1];
		} 
	}

	public static int[] combineArray(int arr1[], int arr2[]) {

		int size1 = arr1.length, size2 = arr2.length;

		int oneArray[] = new int[size1 + size2];
		int idx = 0;

		for (int i = 0; i < size1; i++) {

			oneArray[idx++] = arr1[i];
		}

		for (int i = 0; i < size2; i++) {

			oneArray[idx++] = arr2[i];
		}

		System.out.println("One sorted array : " + Arrays.toString(oneArray));

		return oneArray;		

	}

}