import java.util.*;

public class TwoPointer {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{2, 3, 2, 8, 9, 20, 40};			//  {3, 1, 4, 6, 5} 
		int arr[] = new int[]{3, 1, 4, 6, 5};
		Arrays.sort(arr);

		int reverse[] = new int[arr.length];
		int idx = 0;

		for (int i = arr.length-1; i >= 0; i--) {
			reverse[idx++] = arr[i];
		}

		System.out.println("Reverse array is : " + Arrays.toString(reverse));
		// {1, 3, 4, 5, 6}
		System.out.println("For array : " + Arrays.toString(reverse) + ",\tFound " + pythgoreanTriplet(reverse));

	}

	public static boolean pythgoreanTriplet(int arr[]) {

		int size = arr.length;

		for (int i = 0; i < size; i++) {

			int sum = arr[i] * arr[i];

			System.out.println("for " + arr[i] + ", twoPointer asking sum " + sum);

			if(twoPointerModified(arr, i+1 , size-1, sum)) {

				return true;
			}

		}

		return false;

	}

	public static boolean twoPointerModified(int arr[], int low, int high, int sum) {

		while (low < high) {

			int currSum = (arr[low] * arr[low]) + (arr[high] * arr[high]);

			System.out.println("Two pointer sum " + currSum + ", arr[low] : " + arr[low] +  ", arr[high] : " + arr[high] );
			
			if (currSum == sum) {

				
				return true;
			
			} else if (currSum > sum) {

				high--;
			
			} else {

				low++;
			}
		}

		return false;
	}

	public static void sortInReverse(int arr[]) {
	}

	public static boolean findTriplet(int arr[], int sum) {

		int size = arr.length;

		for (int i = 0; i < size; i++) {

			int twoSum = sum - arr[i];

			System.out.println("for " + arr[i] + ", threePointer asking sum " + twoSum);

			if(twoPointer(arr, i+1, size-1, twoSum)) {

				return true;
			}

		}

		return false;
	}

	public static boolean twoPointer(int arr[], int low, int high, int sum) {

		while (low < high) {

			int currSum = arr[low] + arr[high];

			if (currSum == sum) {

				System.out.println("Two pointer sum " + currSum + ", arr[low] : " + arr[low] +  ", arr[high] : " + arr[high] );
				return true;
			
			} else if (currSum > sum) {

				high--;
			
			} else {

				low++;
			}
		}

		return false;
	}


	// public static boolean threePointerMap(int arr[], int sum) {

	// 	Map<Integer, Integer> map = new HashMap<>();

	// 	int len = arr.length;

	// 	for (int i = 0; i < len-1; i++) {

	// 		int findSum = sum - arr[i];
	// 		// if ()
	// 		map.put(arr[i], i);
	// 	}

	// }


}