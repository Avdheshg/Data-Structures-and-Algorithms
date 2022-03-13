import java.util.*;

public class GenerateNumWithGivenDigits {

	public static void main(String[] args) {
			
		int n1 = 5, n2 = 6, end = 10;

		// System.out.println("Hello" + 1);
		naive(n1, n2, end);
		// efficient("5", "6", end);

	}

	public static void efficient(String n1, String n2, int count) {

		Queue<String> q = new LinkedList<>();

		q.add(n1);
		q.add(n2);

		for (int i = 0; i < count; i++) {
			String x = q.poll();

			System.out.println(x);

			q.add(x + "5");
			q.add(x + "6");
		}

	}

	public static void naive(int n1, int n2, int end) {

		// Not working correctly and also printing 156
		int count = 0;

		int num = 0;
		while (true) {
			if (isValid(num)) {
				System.out.println(num);
				count++;
			}

			// String str = Integer.toString(num);
			// if (str.contains("5") && str.contains("6")) {
			// 	count++;
			// 	System.out.println(num + " count: " + count);
			// }

			num++;

			if (count == end) {
				break;
			}
		}
	}

	public static boolean isValid(int x) {
		String str = new String("x");
		System.out.println("x " + x);

		for (int i = 0; i < str.length(); i++) {
			// boolean hasFive = true;
			// boolean hasSix = true;

			// if (str.charAt(i) != '5') {
			// 	hasFive = false;
			// }
			// if (str.charAt(i) != '6') {
			// 	hasSix = false;
			// }

			// if (!hasFive && !hasSix) {
			// 	return false;
			// }

			if (str.charAt(i) != '5' && str.charAt(i) != '6') {
				return false;
			}
		}
		return true;
	}
}



































