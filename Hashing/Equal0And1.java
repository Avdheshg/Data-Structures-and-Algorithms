import java.util.*;

public class Equal0And1 {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{1,0,1,1,1,0,0};    // 
		int arr[] = new int[]{0,0,1,1,1,1,1,0};

		// largestNaive(arr);
		largestEfficient(arr);	

	}

	public static void largestNaive(int arr[]) {

		int res = 0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			int c0 = 0, c1 = 0;

			for (int j = i; j < len; j++) {

				if (arr[j] == 0) {
					c0++;
				} else {
					c1++;
				}

				if ( c1==c0 && (res < (c1+c0))) {
					res = c1+c0;
					System.out.println("New longest subarray is from " + i + " to "  + j + " res: " + res + ", (c1+c0) " + (c1+c0));
				}

			}

			System.out.println("for i: " + i + ", c1 : " + c1 + ", c0 : " + c0);
		}

	}

	public static void largestEfficient(int arr[]) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		int res = 0;
		int pSum = 0;
		for (int i = 0; i < len; i++) {

			pSum += arr[i];

			if (pSum == 0) {
				res = i+1;
			}

			if (map.containsKey(pSum-0)) {
				res = Math.max(res, i-map.get(pSum-0));
			}

			if (!map.containsKey(pSum)) {
				map.put(pSum, i);
			}
		}

		System.out.println("Longest subarray is of length " + res );

	}

}