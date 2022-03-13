import java.util.*;

public class LCSpanWithSameSumBinaryArray {

	// Naive Approach 	
	public static void naiveSum(int a[], int b[]) {
		int maxSize = 0;

		for (int i = 0; i < a.length; i++) {

			int sum1 = 0, sum2 = 0;
			for (int j = i; j < b.length; j++) {

				// V R counting on "j" in both the arrays => this will make individual spans starting from current i 
				sum1 += a[j];
				sum2 += b[j];

				if (sum1 == sum2) {
					maxSize = Math.max(maxSize, (j-i) + 1);
					System.out.println("maxSize " + maxSize + "\tsum1 " + sum1 + ", sum2 " + sum2 + "\ti " + i + ", j " + j);
				}
			}
			System.out.println();
		}

		System.out.println("Final maxSize " + maxSize);
	}
	
	// M-2: Efficient sol
	/*
		Algo: 
			1st cal the diff in both the arrays and save it into an aux arra
			Then apply the longest span with 0 sum(using preSum). It has 3 cases
				c1: if preSum == asked sum (sum) => it means that from the idx 0 all elements are making a subarray with asked sum. 
					Update the length from the idx 0
				c2: map contains (preSum-sum): means that some elements from the idx of preSum (saved in the HT) to i are forming a subarray with asked sum
				c3: if map doesn't have (preSum-sum): than it means that the current preSum is not yet added to the HM => so add it 
	*/
	public static void efficientSum(int a[], int b[]) {

		int aux[] = new int[a.length];

		// Saving the difference of a[i] - b[i] to aux
		for (int i = 0; i < a.length; i++) {
			aux[i] = a[i] - b[i];
		}

		System.out.println("aux[] " + Arrays.toString(aux));

		// now calling the longestSpanWith0Sum
		longestSpanWithZeroSum(aux, 0);

	}
	// Ex: -1, 1,0,0,1,1,-1,-1
	public static void longestSpanWithZeroSum(int aux[], int sum) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int preSum = 0, maxSize = 0;

		for (int i = 0; i < aux.length; i++) {

			preSum += aux[i];

			if (preSum == sum) {
				maxSize = i+1;
			}
			if (map.containsKey(preSum - sum)) {
				maxSize = Math.max(preSum, i - map.get(preSum));
			}
			if (map.containsKey(preSum) == false) {
				map.put(preSum, i);
			}
		}
		System.out.println("maxSize " + maxSize);
	}


	

	
	public static void main(String[] args) {
		
		// int a[] = new int[]{0, 1, 0, 0, 0, 0};	
		// int b[] = new int[]{1, 0, 1, 0, 0, 1};

		int a[] = new int[]{0, 1, 0, 1, 1, 1, 1};	
		int b[] = new int[]{1, 1, 1, 1, 1, 0, 1};

		naiveSum(a, b);	

		// efficientSum(a, b);
	}
}