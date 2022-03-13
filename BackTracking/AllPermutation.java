public class AllPermutation {

	public static void main(String[] args) {
			
		String str = "ABC";

		naiveRec(str, 0, str.length()-1);

	}

	public static void naiveRec(String str, int l, int length) {

		if (l == length) {

			// For String which doesn't contain AB
			if (str.contains("AB")) {
				// System.out.println(str);
				return;
			}	else {
				System.out.println(str);
			}
			// System.out.println(str);

		} else {

			for (int i = l; i <= length; i++) {

					str = new String(swap(str, i, l));
					naiveRec(str, l+1, length);
					str = new String(swap(str, i, l));	

			}

		}

	}

	public static char[] swap(String str, int idx, int from ) {

		/* Convert Str to char[]
		   Swap char in array
		   return []
		*/

		   char[] ch = str.toCharArray();
		   char temp = ch[idx];
		   ch[idx] = ch[from];
		   ch[from] = temp;

		   return ch;

		 

		// String temp = str.charAt(idx);
		// str.charAt(idx) = str.charAt(from);
		// str.charAt(from) = temp;

		// System.out.println("\t\tAfter swapping : " + str);

	}

}