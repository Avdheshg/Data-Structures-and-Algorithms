import java.util.*;

public class CountFrequencies {


	public static void main(String[] args) {
		
		int arr[] = new int[]{10, 12, 10, 15, 10, 20, 12, 12};

		// countFre(arr, arr.length);

		countFreByHashing(arr, arr.length);

	}

	public static void countFreByHashing(int arr[], int size) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < size; i++) {

			// if (!map.containsKey(arr[i])) {
				// map.get(arr[i])++;
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			// }
		}

		// for (int i = 0; i < size; i++)
		// System.out.println(Arrays.asList(map));
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

	public static void countFre(int[] arr, int size) {

		Arrays.sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));

		for (int i = 0; i < size; i++) {

			int count = 1;
			for (int j = i+1; j < size; j++) {

				if (arr[i] == arr[j]) {
					count++;
				}

			}

			while (i < size-1 ) {
				if (arr[i] == arr[i+1]) {
					i++;
					
				} else {
					break;
				}
				// System.out.println("----- i " + i);
			}

			System.out.println(arr[i] + " -> " + count);
		}

	}

}