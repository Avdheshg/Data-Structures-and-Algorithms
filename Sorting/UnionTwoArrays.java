import java.util.*;

public class UnionTwoArrays {

	public static void main(String[] args) {
		
		// int arr2[] = new int[] {3, 5, 10, 10, 10, 15, 15, 20, 20, 20};
		// int arr1[] = new int[] {5, 10, 10, 15, 30};

		int arr2[] = new int[] {3, 5, 10, 10, 10, 15, 15, 20, 20, 20};
		int arr1[] = new int[] {5, 10, 10, 15, 30};

		int s1 = arr1.length, s2 = arr2.length;


		// Efficient 2
		// int i = 0, j = 0;
		// while (i < s1 && j < s2) {

		// 	if (i > 0 && arr1[i] == arr1[i-1]){
		// 		i++;
		// 		continue;
		// 	}
		// 	if (j > 0 && arr2[j] == arr2[j-1]){
		// 		j++;
		// 		continue;
		// 	}

		// 	if (arr1[i] == arr2[j]) {
		// 		System.out.println(arr1[i]);
		// 		i++;
		// 		j++;
		// 	} else if (arr1[i] > arr2[j]) {
		// 		System.out.println(arr2[j]);
		// 		j++;
		// 	} else {
		// 		System.out.println(arr1[i]);
		// 		i++;
		// 	}
		// }
		// while (i < s1) {
		// 	System.out.println(arr1[i]);
		// 	i++;
		// }
		// while (j < s2) {
		// 	System.out.println(arr2[j]);
		// 	j++;
		// }

		// =========  Naive method: O(n+m) | o(n+m)     =========  
		HashSet<Integer> set = new HashSet<>();

		for (int x: arr1) {
			set.add(x);
		}
		for (int x: arr2) {
			set.add(x);
		}

		System.out.println(set);

		// =========  Naive method: O(nlogn) | O(n)    =========  
		// int bigArr[] = new int[s1 + s2];
		// int k = 0;

		// for (int i = 0; i < s1; i++) {
		// 	bigArr[i] = arr1[i];
		// }

		// for (int i = 0; i < s2; i++) {
		// 	bigArr[s1 + i] = arr2[i];
		// }

		// Arrays.sort(bigArr);

		// System.out.println("After sorting : " + Arrays.toString(bigArr));

		// for (int i = 0; i < (s1 + s2); i++) {
		// 	if (i > 0 && bigArr[i] == bigArr[i-1]) {
		// 		continue;
		// 	}
		// 	System.out.println(bigArr[i]);
		// }

	}
}