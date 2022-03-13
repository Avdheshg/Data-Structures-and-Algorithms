import java.util.*;

public class StockSpan{ 

	// Here V need to find all the consecutive days(previous) which has price less or equal to curr day
	public static void main(String[] args) {
		
		// int arr[] = new int[]{13,15,12,14,16,8,6,4,10,30};
		int arr[] = new int[]{100, 80, 60, 70, 60, 75, 85};

		naive(arr);	
		// efficient(arr);
	}

	// naive: O(n2)
	public static void naive(int arr[]) {
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			int span = 1;

			for (int j = i-1; j >= 0; j--) {
				if (arr[i] >= arr[j]) {
					span++;
				} else {
					break;
				}
			}

			System.out.println("For i: " + i +", arr[i]: " + arr[i] + ", span is " + span);
		}
	}

	// Efficient: O(n)=> Explain || O(n)
	public static void efficient(int arr[]) {
		int len = arr.length;

		ArrayDeque<Integer> st = new ArrayDeque<>();
		st.push(0);
		System.out.println("for [0]: " + 1);

		for (int i = 1; i < len; i++) {
			int span = 1;

			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				span = i+1;
			} else {
				span = i - st.peek();
			}

			System.out.println("For i: " + i +", arr[i]: " + arr[i] + ", span is " + span);
			st.push(i);
		}

	}
}






































