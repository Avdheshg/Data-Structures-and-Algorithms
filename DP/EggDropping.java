public class EggDropping {

	public static void main(String[] args) {
			
		int floors = 6, eggs = 2;     // 6  2

		System.out.println(minTrialsRec(floors, eggs));
	}

	public static int minTrialsRec(int floors, int eggs) {

		if (eggs == 1) return floors;
		if (floors == 0 || floors == 1) return floors;

		int minTrials = Integer.MAX_VALUE;
		int res;

		for (int i = 1; i <= floors; i++) {

			res = Math.max(minTrialsRec(i-1, eggs-1),
						  minTrialsRec(floors-i, eggs)
						  );

			minTrials = Math.min(minTrials, res);
		}

		return minTrials + 1;

	}
}