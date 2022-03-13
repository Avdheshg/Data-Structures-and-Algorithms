public class PalindromePartitioning {

	public static void main(String[] args) {
		
		String str = "cabababcbc";

		System.out.println(recursive(str, 0, str.length()-1));
		// System.out.println(isPalindrome(str, 0, str.length()-1));

	}

	public static int recursive(String str, int startIdx, int endIdx) {

		if (isPalindrome(str, startIdx, endIdx)) {
			return 0;
		}

		int res = Integer.MAX_VALUE;
		int count;

		for (int i = startIdx; i < endIdx; i++) {
			count =  1 + recursive(str, startIdx, i) + 
								recursive(str, i+1, endIdx);
								

			res = Math.min(res, count);
		}

		return res;
	}

	public static boolean isPalindrome(String string, int startIdx, int endIdx) {

		while(startIdx < endIdx) {

	      if(string.charAt(startIdx) != string.charAt(endIdx))
	        return false; 
	      startIdx++;
	      endIdx--;

	    }

	    return true;
	}	
}