import java.util.*;

public class GetMinFunction {

	private static ArrayDeque<Integer> stack = new ArrayDeque<>();
	private static int min;

	// private static ArrayDeque<Integer> mainStack = new ArrayDeque<>();
	// private static ArrayDeque<Integer> auxStack = new ArrayDeque<>();

	public static void main(String[] args) {
		push(5);    getMin();
		push(10);    getMin();  
		push(20);    getMin();
		push(2);    getMin();
		push(6);    getMin();
		push(4);    getMin();

		pop();    getMin();
		pop();    getMin();

		push(2);    getMin();

		pop();    getMin();

		push(1);    getMin();

		pop();    getMin();
		pop();    getMin();
	}

	// Naive1: 
	/*
		during push and pop => perfomr them as normal push and pop
		For getMin()
			Create a aux stack
			pop every element from the main stack and push it into the aux stack. During this traversal def a var and save the min into it while traversing
			fill the main stack back

			Here getMin() => O(n)
	*/

	// ========= Naive 2: (n)|(n) => in practice it will take much less space then O(n)  ========
	/*	Algo:
			push() =>
				if both stacks are empty, then push to both the stacks 
				Only push to the aux sta when the x <= peek of the auxSt (i.e x is min among all)

			pop() => 
				check if the aux stack is empty => V have not added any element yet => if yes then return -1
				In both the below cases, main will remove the element 
					if main and aux stack contains the same peek => remove from both
					o/w remove from main
			
			getMin() => 
				if auxStack is empty => return -1 => V have not added any element yet
				o/w return the top of aux stack => at any stage peek of aux stack will contain min of all elements
	*/
	// public static void push(int x) {
	// 	if (mainStack.isEmpty() || x <= auxStack.peek()) {
	// 		auxStack.push(x);
	// 	}
	// 	mainStack.push(x);

	// 	// System.out.println();
	// 	System.out.println("\nAfter pushing " + x + " to the stacks");
	// 	System.out.println("mainStack: " + mainStack);
	// 	System.out.println("auxStack: " + auxStack);
		
	// }
	// public static int pop() {
	// 	if (auxStack.isEmpty()) {
	// 		return -1;
	// 	}

	// 	if (mainStack.peek() == auxStack.peek()) {
	// 		auxStack.pop();
	// 	}
	// 	mainStack.pop();

	// 	System.out.println("\n\tAfter popping from the stacks");
	// 	System.out.println("\tmainStack: " + mainStack);
	// 	System.out.println("\tauxStack: " + auxStack);

	// 	return mainStack.peek();
	// }

	// public static int getMin() {
	// 	if (auxStack.isEmpty()) {
	// 		return -1;
	// 	}

	// 	System.out.println("\ngetMin(), peek is: " + auxStack.peek());

	// 	return auxStack.peek();
	// }


	// ============== EfficientOne: Only +ve   ============
	/*
		Algo:
			push() => 
				if stack is empty => push and update min
				if x <= min => push(x-min) and update min to x
				else => x is not min and stack is not empty => push to the stack

			pop() =>
				pop 
				if pop <= 0 => it means that pop is the 2nd min => so return the 1s min and update the 		min with the 2nd min
				else => return the pop
			
			peek() =>
				if peek <= 0 => measn that the peek is the 2nd min => return the min
				else return peek
	*/
	// public static void push(int x) {
	// 	if (stack.isEmpty()) {
	// 		min = x;
	// 		stack.push(x);
	// 	} else if (x <= min) {
	// 		stack.push(x-min);
	// 		min = x;	
	// 	} else {
	// 		stack.push(x);
	// 	}

	// 	System.out.println("\nAfter pushing " + x + " to the stack");
	// 	System.out.println("stack: " + stack);
	// 	System.out.println("min: " + min);
	// }

	// public static int pop() {
	// 	int top = stack.pop();
	// 	System.out.println("\n\tpopping from the stacks");
	// 	if (top <= 0) {
	// 		int res = min;
	// 		min = min-top;
			
	// 	System.out.println("stack: " + stack);
	// 	System.out.println("min: " + min);
	// 		return res;
	// 	} else {
	// 		return top;
	// 	}
		
	// }

	// public static int peek() {
	// 	return (stack.peek() <= 0) ? min : stack.peek();
	// }

	// public static int getMin() {
	// 	System.out.println("\ngetMin(), min is: " + min);
	// 	return min;
	// }


	// not working for LC
	// ============== Efficient Two  ============
	/*
		Algo: Same as above algo just change the operation of min var with multiply by 2
	*/
	public static void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push(x);
		} else if (x <= min) {
			stack.push(2*x-min);
			min = x;	
		} else {
			stack.push(x);
		}

		System.out.println("\nAfter pushing " + x + " to the stack");
		System.out.println("stack: " + stack);
		System.out.println("min: " + min);
	}

	public static int pop() {
		int top = stack.pop();
		System.out.println("\n\tpopping from the stacks");
		if (top <= min) {
			int res = min;
			min = 2 *min - top;
			
		System.out.println("stack: " + stack);
		System.out.println("min: " + min);
			return res;
		} else {
			return top;
		}
		
	}

	public static int peek() {
		return (stack.peek() <= min) ? min : stack.peek();
	}

	public static int getMin() {
		System.out.println("\ngetMin(), min is: " + min);
		return min;
	}

}






































