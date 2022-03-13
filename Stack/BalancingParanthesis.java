import java.util.*;

public class BalancingParanthesis{ 

	public static void main(String[] args) {

		String str = "(()))";     //  ([])   ((())    ([)]   {}([()])  (()))

		System.out.println(str + " is matching: " + isMatching(str));
	}

	public static boolean isMatching(String str) {
		ArrayDeque<Character> stack = new ArrayDeque<>();

		// M-2: short and better
		for (char c: str.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();

		/*
			TR the str
				if opening bracket => push 
				else 
					if st is empty || x is not a pair
						return false
					pop
			return result of st is empty
		*/

		// M-1
		// for (int i = 0; i < str.length(); i++) {
		// 	char x = str.charAt(i);

		// 	if (x == '(' || x == '[' || x == '{') {
		// 		stack.push(x);
		// 	} else {

		// 		if (stack.isEmpty()) {
		// 			System.out.println("We R having " + x + " but stack is empty");
		// 			return false;
		// 		}
		// 		if (!isPair(stack.peek(), x)) {
		// 			System.out.println("peek() and x is not matching, x: " + x + " peek(): " + stack.peek());
		// 			return false;
		// 		}
		// 		stack.pop();
		// 	}
		// }
		// return stack.isEmpty();
	}

	public static boolean isPair(char a, char b) {
		return (a == '(' && b == ')' ) ||
				(a == '[' && b == ']') ||
				(a == '{' && b == '}');
	}

}




















