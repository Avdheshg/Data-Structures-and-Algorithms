import java.util.*;

public class IntersectionOf2Arrays {

	// Naive: O(n * (n+m)) || O(1)
	public static void naive(int a[], int b[]) {

		for (int i = 0; i < a.length; i++) {

			boolean isVis = false;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					isVis = true;
					break;
				}
			}

			if (isVis) {
				continue;
			}

			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);
					break;
				}
			}
		}
	}

	// M-2: save a[] in set1 and b[] in set2. Now TR any one of the set and check if that element is present in another set : O(n+m+n) || O(m+n)

	// M-3: O(n+m) || O(n)
	public static void countIntersectionSet(int a1[], int a2[]) {

		int s1 = a1.length;
		int s2 = a2.length;
		int count = 0;

		// HashSet<Integer> set1 = new HashSet<>(Arrays.asList(a1));
		HashSet<Integer> set1 = new HashSet<>();
		for (int i = 0; i < s1; i++) {
			set1.add(a1[i]);
		}

		System.out.println("Set1 " + Arrays.asList(set1));

		for (int i = 0; i < s2-1; i++) {

			// Either V can leave dups in the array Or V can remove the matched element from the HS
			// if (i > 0 && a2[i] == a2[i+1]) continue;

			if (set1.contains(a2[i])) {
				count++;
				System.out.println(a2[i]);
				set1.remove(a2[i]);
			}
		}

		System.out.println("Count => " + count);

	}

	// M-1
	public static void countIntersectionLoops(int a1[], int a2[]) {

		Arrays.sort(a1);
		Arrays.sort(a2);

		System.out.println("After sorting" );
		System.out.println("a1 => " + Arrays.toString(a1));
		System.out.println("a2 => " + Arrays.toString(a2));

		int s1 = a1.length;
		int s2 = a2.length;
		int count = 0;

		for (int i = 0; i < s1; i++) {

			boolean flag = false;

			for (int j = 0; j < s2; j++) {

				if (flag) continue;

				if (a1[i] == a2[j]) {
					count++;
					flag = true;
				}
			}

			// Checking for dups in a1
			while (i < (s1-1) && a1[i] == a1[i+1]) {
				i++;
			}
		}

		System.out.println("Count => " + count);

	}

	
	public static void main(String[] args) {
		
		int a1[] = new int[]{10, 15, 20, 5, 15, 30};
		int a2[] = new int[]{30, 5, 15, 30, 15, 80};

		// int a1[] = new int[]{10, 15, 20, 5, 30};
		// int a2[] = new int[]{30, 5, 30, 80};

		// int a1[] = new int[]{10, 10, 10};
		// int a2[] = new int[]{10, 10, 10};

		// countIntersectionLoops(a1, a2);
		// naive(a1, a2);
		countIntersectionSet(a1, a2);

	}
}