import java.util.*;

public class InfixToPrefix {
    
    public static void main(String[] args) {
        toPrefix("x+y*z");        // (A-B/C)*(A/K-L)     A*B+C/D
    }

    public static String toPrefix(String str) {

        Stack<Character> stack = new Stack<>();
        String res = "";

        for (int i = str.length()-1; i >= 0; i--) {

            char x = str.charAt(i);

            if (Character.isLetterOrDigit(x)) {
                res += x;
            } else if (x == ')') {
                stack.push(x);
            } else if (x == '(') {
                while (!stack.isEmpty() && x != ')') {
                    res += stack.pop();
                }

                // if (stack)
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(x) <= prec(stack.peek())) {
                    res += stack.pop();
                }
                stack.push(x);
            }

        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        StringBuilder input = new StringBuilder();
        input.append(res);

        input = input.reverse();

        System.out.println("Final string: " + input);

        return "";
    }

    public static int prec(char x) {
        switch (x) {
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
    }

}
