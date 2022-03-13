public class LCS {

	public static void main(String[] args) {
		
		String s1 = "ABC", s2 = "BCD";

		System.out.println(s1, s2, s1.length(), s2.length());
	}

	public static int lcsRecursive(String s1, String s2, int l1, int l2) {

		System.out.println("l1 : " + l1 + "\tl2: " + l2);

		if (l1 == 0 || l2 == 0) {
			return 0;
		}

		// System.out.println("l1 : " + l1 + "\tl2: " + l2);

		if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
			return 1 + lcsRecursive(s1, s2, l1-1, l2-1);
		}

		return Math.max(lcsRecursive(s1, s2, l1, l2-1), lcsRecursive(s1, s2, l1-1, l2));

	}
}