import java.util.*;

public class MoreThanNbyKOccurences {

	// M-1: Naive: O(nlogn) => sort the array and print all those eligible
	public static void naive2(int arr[], int k) {

		int len = arr.length;
		int limit = (int) Math.floor(len / k);
		System.out.println("Limit " + limit);

		Arrays.sort(arr);
		System.out.println("After sorting " + Arrays.toString(arr));

		int i = 1;
		while (i < len) {
			int count = 1;

			while (i < len && arr[i] == arr[i - 1]) {
				System.out.println("Dups " + i + ", " + arr[i] + " ");
				count++;
				i++;
			}

			if (count > limit) {
				System.out.println("Count " + count);
			}
			i++;
		}
	}

	/*
	 * Algo:
	 * build the map with the freq
	 * print all eligible
	 */
	public static void efficient(int arr[], int k) {

		int len = arr.length;
		int limit = (int) Math.floor(len / k);
		System.out.println("Limit " + limit);

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : arr) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> x : map.entrySet()) {
			if (x.getValue() > len / k) {
				System.out.println(x.getKey());
			}
		}
	}

	public static void main(String[] args) {

		// System.out.println( (int) Math.floor(9/2));

		// int arr[] = new int[]{20, 20, 20, 20, 10, 30, 20}; // k = 3
		int arr[] = new int[] { 30, 30, 20, 20, 30, 20, 30, 20, 30, 30, 20, 30 };

		// naive1(arr, 3);
		// naive2(arr, 3);
		// efficient(arr, 3);
		printNByK(arr, arr.length, 2);
	}

	// Most efficient: i.e O(nk) => when n is very large and k is small => Moore's voting Algo
	/*	
		* In the above method of HM, when V have large amount of number and k is very small then it will be not an good idea to storing everything into a HM and then TR the HM might not be the good idea. So that's why this solution is better in that situation
		Define a map (make sure it's size must not increase k-1)
	 * It has 2 phases
		* 1st phase: V find the candidate element (possible solution)    => O(nk)
		* 	TR througb the map and use 3 cases for each element
				if map already have this element => increase it's count
				if not and map size is in limit => add to the map
				if not in the map and the size is increased => 
					TR through the map and dcrease the freq of all ele and remove those freq == 0
		* 2nd Phase: V find the eligible solution     => O(nk)
			TR the HM 
				for each map ele TR the array and print all those ele which R in the map and having freq > n/k
	 */

	static void printNByK(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		// Phase 1
		for (int i = 0; i < n; i++) {
			if (m.containsKey(arr[i])) {
				int count = m.get(arr[i]);
				m.put(arr[i], count + 1);
			} else if (m.size() < k - 1)
				m.put(arr[i], 1);
			else {
				// for (Map.Entry x : m.entrySet()) {
				// 	Integer c = (Integer) x.getValue();
				// 	m.put((Integer) x.getKey(), c - 1);
				// 	if ((Integer) x.getKey() == 0)
				// 		m.remove(x.getKey());
				// }
				for (Map.Entry<Integer, Integer> x : m.entrySet()) {
					int c = x.getValue();
					m.put(x.getKey(), c - 1);
					if (x.getKey() == 0)
						m.remove(x.getKey());
				}
				
			}

		}
		// Pahse 2
		for (Map.Entry <Integer, Integer> x : m.entrySet()) {
			int count = 0;
			// for (int i = 0; i < n; i++) {
			// 	if ((Integer) x.getKey() == arr[i])
			// 		count++;
			// }
			for (int z: arr) {
				if (x.getKey() == z)
					count++;
			}
			
			System.out.println("count" + count + " n/k: " + n/k + " for " + x.getKey());
			if (count > n / k)
				System.out.print(x.getKey() + " ");
		}
	}

}