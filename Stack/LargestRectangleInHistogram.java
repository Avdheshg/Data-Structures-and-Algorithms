import java.util.*;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		
		int arr[] = new int[]{6,2,5,4,1,5,6};		// 6,2,5,4,1,5,6		2,1,5,6,2,3

		// naive(arr);
		// prevSmaller(arr);
		// nextSmaller(arr);
		efficientOne(arr);
		// efficientTwo(arr);

	}

	public static void naive(int arr[]) {

		/*
			Algo: consider curr bar as min and go to left of it and right of it until on both sides V find items >= curr => this appraoch means that V R going to the left and right until all >= items V found and then V find the area assuming curr as min height
		*/
		int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            maxArea = Math.max(maxArea, curr);
        }
        System.out.println("Max area: " + maxArea);

	}

	// Efficient 1: Using prevSmaller and NextSmaller : O(n)|| O(n) but 3 traversals
	public static void efficientOne(int arr[]) {
		System.out.println("arr: " + Arrays.toString(arr));
		int len = arr.length;

		int[] preSmaller = prevSmaller(arr);
		int[] nextSmaller = nextSmaller(arr);
		System.out.println("prevSmaller: " + Arrays.toString(preSmaller));
		System.out.println("nextSmaller: " + Arrays.toString(nextSmaller));

		int maxAr = 0;

		for (int i = 0; i < len; i++) {
			int curr = arr[i];
			curr += (i - preSmaller[i]-1) * arr[i];
			curr += (nextSmaller[i]-i-1) * arr[i];

			System.out.println("For " + arr[i] + " area is " + curr);

			maxAr = Math.max(curr, maxAr);
		}

		System.out.println("maxaArea : " + maxAr);

	}

	// previous Smaller
	public static int[] prevSmaller(int arr[]) {
		// System.out.println("arr: " + Arrays.toString(arr));

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int len = arr.length;

		int pArr[] = new int[len];

		for (int i = 0; i < len; i++) {
			while ( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
				stack.pop();
			}

			int res = (stack.isEmpty()) ? -1 : stack.peek();
			pArr[i] = res;

			stack.push(i);
		}

		for (int i = 0; i < len; i++) {
			// System.out.println("For " + arr[i] + " => " + pArr[i]);
		}

		return pArr;
	}

	// next smaller
	public static int[] nextSmaller(int arr[]) {
		// System.out.println("arr: " + Arrays.toString(arr));

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int len = arr.length;

		ArrayList<Integer> al = new ArrayList<>();
		int nextArr[] = new int[len];

		for (int i = len-1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				// System.out.print("for i: " + arr[i] + " arr[stack.peek()] " + arr[stack.peek()]);
				stack.pop();
			
			// System.out.println();
			}

			int res = stack.isEmpty() ? len : stack.peek();
			al.add(res);
			stack.push(i);
		}

		Collections.reverse(al);

		for (int i = 0; i < len; i++) {
			// System.out.println("For " + arr[i] + " => " + al.get(i));
			nextArr[i] = al.get(i);
		}

		return nextArr;
	}

	// Efficient 2
	public static void efficientTwo(int arr[]) {
		int len = arr.length;

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0;

		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int top = stack.pop();
				int curr = arr[top] * (stack.isEmpty()? i: (i-stack.peek()-1) );

				maxArea = Math.max(curr, maxArea); 
			}

			stack.push(i);
		}

		// loop for those which don't have next smaller element
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int curr = arr[top] * (stack.isEmpty()? len: (len-stack.peek()-1) );

			maxArea = Math.max(curr, maxArea); 
		}

		System.out.println("maxaArea: " + maxArea);
	}


}

/*
	if (stack.isEmpty()) {
				nArr[idx++] = -1; 
			} else {
				nArr[idx++] = arr[i];
			}
*/
































