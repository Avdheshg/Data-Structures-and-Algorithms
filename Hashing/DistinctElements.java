import java.util.*;

public class DistinctElements {

	public static void naive(int arr[]) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
            boolean isVis = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isVis = true;
                    break;
                }
            }

            if (isVis == false) {
				res++;
				System.out.println("Distinct element: " + arr[i]);
                continue;
            }
        }
		System.out.println("Distinct element: " + res);
	}

	public static void efficient(int arr[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		System.out.println(set + " count: " + set.size());
	}

	public static void main(String[] args) {
			
		int arr[] = new int[]{15, 12, 13, 12, 13, 13, 18};
		// int arr[] = new int[]{1, 1, 1, 1, 1, 1};

		// naive(arr);
		efficient(arr);

		int count = 0;
		int len = arr.length;

		// M-5: Sorting : WHY NOT WORKING
		// Arrays.sort(arr);
		// System.out.println("After sorting : " + Arrays.toString(arr));
		// for (int i = 1; i < len; i++) {
		// 	if (arr[i] != arr[i-1]) {
		// 		count++;
		// 		System.out.println("Incremented count : " + count + " for " + i);
		// 	} else {
		// 		while (arr[i] == arr[i-1]) {
		// 			System.out.println("loop : " + i);
		// 			i++;
		// 		}
		// 	}
		// }
		// System.out.println("Total distinct elements: " + count);

		// M-1: Here take care about when the whole arrays has dups
		// for (int i = 0; i < size; i++) {
		// 	boolean hasDups = false;
			
		// 	System.out.println("length: " + size + " i : " + i + " j " + (i+1));
		// 	for (int j = i+1; j < size; j++) {
		// 		if (arr[i] == arr[j]) {
		// 			hasDups = true;
		// 			System.out.println("Dup of " + arr[i] + " is found");
		// 			break;
		// 		}
		// 	}

		// 	if (!hasDups) {
		// 		System.out.println("Updated for " + i);
		// 		count++;
		// 	}
		// }
		// System.out.println("Total distinct elements: " + count);

		// Method 2
		// HashMap<Integer, Integer> map = new HashMap<>();

		// for (int i = 0; i < size; i++) {
		// 	if (!map.containsKey(arr[i])) {
		// 		System.out.println(map.containsKey(arr[i]) + " " + arr[i]);
		// 		count++;
			
		// 		map.put(arr[i], i);
		// 	}
		// }

		// Method 3
		// HashSet<Integer> set = new HashSet<>();
		// for (int i = 0; i < size; i++) {
		// 	set.add(arr[i]);
		// }

		// Method 4    => Not working
		// List<Integer> list = Arrays.asList(arr);
		// HashSet<Integer> set = new HashSet<>(list);

		// System.out.println("Count => " + set.size());	

	}


}