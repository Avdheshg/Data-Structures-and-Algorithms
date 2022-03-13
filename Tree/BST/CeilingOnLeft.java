import java.util.*;

public class CeilingOnLeft {
    public static void main(String[] args) {
        int arr[] = new int[]{2,8,30,15,25,12};

        // ceilingNaive(arr);
        efficientCeiling(arr);
    }
    
    /*
        Naive Algo:
            print -1 for the 1st element
            Loop through arr, l1
                def a "diff" var for current element and make it infinite
                Loop from starting till curr-1, l2
                    check if the l2 > l1
                        get the diff of l1 and l2
                        update the min diff of "diff" and above l1 and l2
                if "diff" is still infinite => no ele was greater than current
                    print -1
                else 
                    print arr[i] + "diff"

        Why V R using the "diff"
            V need to find a sol from the set of possible solutions 

        O(n2) || O(1)
    */
    public static void ceilingNaive(int arr[]) {
        System.out.println(Arrays.toString(arr));
        System.out.print("-1" + " ");

        for (int i = 1; i < arr.length; i++) {
            int diff = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    diff = Math.min(diff, arr[j] - arr[i]);
                }
            }

            if (diff == Integer.MAX_VALUE) {
                System.out.print("-1" + " ");
            } else {
                System.out.print(arr[i] + diff + " ");
            }
        }
    }

    /*
        Efficient sol:
            Def a TS
            print -1 for [0]
            add [0] to TS

            TR the arr, i=1
                for current element check if TS contains the ceil
                    print the ceil
                if not
                    print -1
                add [i] to TS

        O(nlogn) || O(1)
    */
    public static void efficientCeiling(int arr[]) {
        TreeSet<Integer> ts = new TreeSet<>();
        System.out.println("-1");
        ts.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (ts.ceiling(arr[i]) != null) {
                System.out.println(ts.ceiling(arr[i]));
            } else {
                System.out.println("-1");
            }
            ts.add(arr[i]);
        }
    }
}
