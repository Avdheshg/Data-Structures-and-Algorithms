import java.util.*;

public class TwoStackIn1Array {

	// private static int top1, top2, capacity, arr[];

	// M-1: Naive     
	/*
		Here V R filling the array: 
		for stack1: left to right i.e from idx [0 , cap/2)
		for stack2: right to left i.e from [cap/2, cap-1]
	*/
	// public TwoStackIn1Array(int capacity) {
	// 	this.capacity = capacity;
	// 	arr = new int[capacity];
	// 	top1 = -1;
	// 	top2 = capacity;
	// }

	// public static void push1(int x) {
	// 	System.out.println("capacity: " + capacity);
	// 	if (top1 < capacity/2) {
	// 		top1++;
	// 		arr[top1] = x;
	// 		System.out.println("Pushed " + x + " to Stack1");
	// 		System.out.println("Array is " + Arrays.toString(arr));
	// 	} else {
	// 		System.out.println("Overflow for top1, top1: " + top1 + " size: " + (capacity/2));
	// 	}
	// }

	// public static void push2(int x) {
	// 	if (top2 >= capacity/2) {
	// 		top2--;
	// 		arr[top2] = x;
	// 		System.out.println("Pushed " + x + " to Stack2");
	// 		System.out.println("Array is " + Arrays.toString(arr));
	// 	} else {
	// 		System.out.println("Overflow for top2, top2: " + top2 + " size: " + (capacity/2));
	// 	}
	// }

	// public static void pop1() {
	// 	if (top1 >= 0) {
	// 		int res = arr[top1];
	// 		top1--;
	// 		System.out.println("popping from top1: " + arr[top1]);
	// 		System.out.println("Array is " + Arrays.toString(arr));
	// 	}else {
	// 		System.out.println("Underflow for top1");
	// 	}
	// }

	// public static void pop2() {
	// 	if (top2 < capacity) {
	// 		int res = arr[top2];
	// 		top2++;
	// 		System.out.println("popping from top2: " + arr[top2]);
	// 		System.out.println("Array is " + Arrays.toString(arr));
	// 	} else {
	// 		System.out.println("Underflow for top2");
	// 	}
	// }

	// M-2: Efficient
	private static int top1, top2, capacity, arr[];

	public TwoStackIn1Array(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		top1 = -1;
		top2 = capacity;
	}

	public static void push1(int x) {
		// top1 < top2-1 means that there must be 1 space available between top1 and top2
		if (top1 < top2-1) {
            top1++; 
            arr[top1] = x;
			System.out.println("Pushed " + x + " to Stack1");
			System.out.println("Array is " + Arrays.toString(arr));
		} else { 
            System.out.println("Stack Overflow"); 
            // System.exit(1);
		}
	}

	public static void push2(int x) {
		if (top1 < top2-1) {
            top2--; 
            arr[top2] = x; 
			System.out.println("Pushed " + x + " to Stack2");
			System.out.println("Array is " + Arrays.toString(arr));
		} else { 
            System.out.println("Stack Overflow"); 
            // System.exit(1); 
        } 
	}

	int pop1() { 
        if (top1 >= 0) { 
            int x = arr[top1]; 
            top1--; 
			System.out.println("popping from top1: " + x);
			System.out.println("Array is " + Arrays.toString(arr));
            return x; 
        } 
        else { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
        } 
        return 0; 
    } 
  
    int pop2() { 
        if (top2 < capacity) { 
            int x = arr[top2]; 
            top2++; 
			System.out.println("popping from top2: " + x);
			System.out.println("Array is " + Arrays.toString(arr));
            return x; 
        } 
        else { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
        } 
        return 0; 
    }

	public static void main(String[] args) {
		TwoStackIn1Array st = new TwoStackIn1Array(6);

		// Not working(push after the range) and problem in array indexes
		st.push1(3);
		st.push1(12);
		st.push1(19);
		st.push1(19);
		// st.push1(19);  if V add this then stack1 will replace element of stack2 and place this at there

		st.push2(8);
		st.push2(14);
		
		// st.push1(19);
	}



}


















