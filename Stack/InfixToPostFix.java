import java.util.*;

// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

public class InfixToPostFix {

	public static void main(String[] args) {
		
		String str = "+b*(c^d-e)^(f+g*h)-i";     // (a+b)*c

		toPostfix(str);
	}

/*
	Algo:
		Define a stack	

		Do the following for every char(x) => loop through the whole expression
			If x is an operand, 
				add it to output.
			If x is an '(',  
				push it to the stack.
			If x is an ')', 
				pop and output from the stack 
            	until an '(' is encountered.
			X is an operator
				loop through the stack until for 2 conditions
					a. stack is empty
					b. precedence(x) <= precedence(peek())   
						pop from the stack and output it
				push x to the stack

		pop all the items from the stack and output them		

*/

	public static String toPostfix(String str) {

		ArrayDeque<Character> stack = new ArrayDeque<>();
		String res = new String(""); 

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				res += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && getPrec(c) <= getPrec(stack.peek())) {
					res += stack.pop();
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			if(stack.peek() == '(')
                return "Invalid Expression";

			res += stack.pop();
		}

		System.out.println("After conversion: " + res);
		return res;

	}

	public static int getPrec(char c) {
		
		switch (c) {
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '^':
				return 3;

			default:
				return -1;
		}

		// if (c == '+' || c == '-') {
		// 	return 1;
		// } else if (c == '*' || c == '/') {
		// 	return 2;
		// } else if (c == '^') {
		// 	return 3;
		// } else {
		// 	return -1;
		// }
	}
}



































