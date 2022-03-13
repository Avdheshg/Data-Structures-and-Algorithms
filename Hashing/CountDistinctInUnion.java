import java.util.*;

public class CountDistinctInUnion {

	public static void main(String[] args) {
		
		// int a1[] = new int[]{10, 12, 15};
		// int a2[] = new int[]{18, 12};

		int a1[] = new int[]{15, 20, 5, 15};
		int a2[] = new int[]{15, 15, 15, 20, 10};

		// countNaive(a1, a2);	

		efficient(a1, a2);
	}

	public static void efficient(int a1[], int a2[]) {

		Set<Integer> set = new HashSet<>();

		for (int ele : a1)
			set.add(ele);

		for (int ele : a2)
			set.add(ele);

		System.out.println(set + "\tsize " + set.size() );


	}

	// public static void countNaive(int a1[], int a2[]) {

	// 	int s1 = a1.length;
	// 	int s2 = a2.length;

	// 	int aux[] = new int[s1+s2];
	// 	int k = 0;

	// 	k = insertDistinct(a1, aux, s1, k);
	// 	k = insertDistinct(a2, aux, s1+s2, k);

	// 	System.out.println("aux[] " + Arrays.toString(aux) + " \tcount " + k);

	// }

	// public static int insertDistinct(int a1[], int aux[], int s1, int k) {

	// 	for (int i = 0; i < s1; i++) {

	// 		boolean flag = false;

	// 		for (int j = 0; j < s1; j++) {
	// 			if (a1[i] == aux[j]) {
	// 				flag = true;
	// 			}
	// 		}

	// 		if (flag == false) {
	// 			aux[k++] = a1[i];
	// 		}
	// 	}

	// 	return k;

	// }



}