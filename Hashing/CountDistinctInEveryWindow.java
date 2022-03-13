import java.util.*;

public class CountDistinctInEveryWindow {

	public static void main(String[] args) {
		
		int arr[] = new int[]{10, 20, 20, 10, 30, 40, 10};

		// naive2(arr, 4);
		naive(arr, 4);

		// efficient(arr, 4);

	}

	// Total number of windows = n-k+1
	// M-1: NAive: O( (n-k)*k*k )
	public static void naive(int arr[], int k) {

		int len = arr.length;

		for (int i = 0; i <= (len-k); i++) {

			int count = 0;
			System.out.println("In window from " + i + " to " + (i+k-1));

			// finding the distinct elements and counting them also
			for (int j = i; j < (i+k); j++) {

				boolean isRepeated = false;

				for (int m = i; m < j; m++) {
					if (arr[j] == arr[m]) {
						isRepeated = true;
						break;
					}
				}

				if (!isRepeated) {
                    System.out.print(arr[j] + " ");
                    count++;
				}
			}
			System.out.println();
            System.out.println("Total Distinct elements are " + count);
            System.out.println();
		}

	}

	/*
		Algo: Using freq map
			1st: make a freq map of 1st k itmes
			TR the array from k till end
				Case 1: Handling the [i-k] element: Decrease the frequency of [i-k]the element or the element which is now out of the window as V have increased the window to the right
			    Check if the frequency of [i-k]th element is == 0; it means that niether the element and nor it's any duplicate is present in the current window and so V can delete it to accomodate new element
				Case 2: Handling the current element: Add the new element

				Print the size of the map; it will be having all the distinct element present in the current window
			
	 */
	public static void efficient(int arr[], int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for (int i = k; i < arr.length; i++) {

			map.put(arr[i-k], map.get(arr[i-k]) - 1);

			if (map.get(arr[i-k]) == 0) {
				map.remove(arr[i-k]);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

			System.out.println("For " + (i-k) + " to " + i + " => Distinct elements : " + map.size());
			System.out.println();

		}
	}


	// NAive using HS
	public static void naive2(int arr[], int k) {

		for (int i = 0; i <= arr.length-k; i++) {

			HashSet<Integer> set = new HashSet<>();

			for (int j = i; j < i+k; j++) {

				System.out.println("Adding " +  arr[j]);				
				set.add(arr[j]);

			}

			System.out.println("For " + i + " to " + (i+k) + " => Distinct elements : " + set.size());
			System.out.println();
		}

	}

}