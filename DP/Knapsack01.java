public class Knapsack01 {

	public static void main(String[] args) {
		
		// int val[] = new int[]{10, 40, 30, 50};
		// int wt[] = new int[]{5, 4, 6, 3};

		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};

		// int W = 10;
		int W = 50;

		System.out.println(KSRec(val, wt, W, val.length));

	}

	public static int KSRec(int val[], int wt[], int W, int len) {

		if (len == 0 || W == 0) {
			return 0;
		}


		/*
			2 options : 1st V don't consider
						2nd V consider (in this case V need to take care that the current item's weight must not increase the total weight V can carry )
		*/

		int res = KSRec(val, wt, W, len-1);

		if (wt[len-1] <= W) {

			res = Math.max(res, val[len-1] + KSRec(val, wt, W - wt[len-1], len-1));

		}

		return res;



		// if (wt[len-1] > W) {
		// 	return KSRec(val, wt, W, len-1);
		// } else {
		// 	return Math.max(KSRec(val, wt, W, len-1),
		// 					val[len-1] + KSRec(val, wt, W - wt[len-1], len-1));
		// }
	}
}