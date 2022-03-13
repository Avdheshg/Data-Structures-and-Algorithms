import java.util.*;

public class LongestConsecutiveSubsequence {
	
	// Naive: (nlogn)
	public static void naiveSorting(int arr[]) {
		int maxSize = 1, count = 1;

		Arrays.sort(arr);	
		System.out.println("Sorted Arrays " + Arrays.toString(arr));

		for (int i = 0; i < arr.length-1; i++) {

			if (arr[i]+1 == arr[i+1]) {
				count++;
				
				System.out.println("i " + i + "\tarr[i]= " + arr[i] + "\tarr[i+1]= " + arr[i+1]);
				maxSize = Math.max(maxSize, count);
				System.out.println("maxSize " + maxSize + "\tCount " + count );
			 	System.out.println();
			} else if (arr[i] != arr[i+1]) {
				count = 1;
			}

		}
		System.out.println("Final maxSize " + maxSize);
	}

	/*
		Algo: V use 2 lookups in the HS
			1st: save all the elements to HS
			2nd: for the current element(x) V check in the HS if it has (x-1) present in the HS if not then it means that this element is the 1st ele of subsequence
				Then V check for x+1, x+2, and so on in the HS. The more elements V find the more is the size of susq 
				At each found ele V increase the max size
	*/
	public static void efficientSub(int arr[]) {

		HashSet<Integer> set = new HashSet<>();
		
		for (int ele : arr) {
			set.add(ele);
		}

		System.out.println("Set : " + set);
		System.out.println("Array : " + Arrays.toString(arr));

		int maxSize = 1;
		for (int ele : arr) {
			int count = 1;
			if (set.contains(ele-count) == false) {
				
				while (set.contains(ele + count)) {
					count++;
					System.out.println("count " + count + "\t Element= " + ele);	
				}
				maxSize = Math.max(maxSize, count);
			}
		}

		System.out.println("\nmaxSize " + maxSize);
	}

	
	public static void main(String[] args) {
		
		// int arr[] = new int[]{1, 9, 3, 4, 2, 20};
		int arr[] = new int[]{1, 4, 3, 8, 3, 11, 4, 15, 2, 9};			// How to Handle the dups
		// int arr[] = new int[]{1, 9, 3, 8, 11, 4, 15, 2};
		// int arr[] = new int[]{8, 20, 7, 10};
		// int arr[] = new int[]{20, 30, 40};

		// naiveSub(arr);

		// naiveSorting(arr);

		efficientSub(arr);

	}

}