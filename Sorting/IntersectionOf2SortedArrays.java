import java.util.*;

public class IntersectionOf2SortedArrays {
    
    public static void main(String[] args) {
        int a[] =  new int[]{1 ,2, 3, 3,3, 4,4, 5, 6,6,6};
        int b[] =  new int[]{3,5,6,6,6};

        naive(a,b);
        // efficientHM(a, b);
    }

    // Efficient 2 
    public static void efficientHM(int a1[], int a2[]) {
        int l1 = a1.length;
        int l2 = a2.length;

        HashSet<Integer> set = new HashSet<>();

        for (int x: a1) {
            set.add(x);
        }

        System.out.println("HS: " + set);

        for (int x: a2) {
            if (set.contains(x)) {
                System.out.println(x);
                set.remove(x);
            }
        }
    }

    //Efficient 1: 2PA
    public static void efficient2PA(int a1[], int a2[]) {
        int l1 = a1.length;
        int l2 = a2.length;
        System.out.println( l1 + "" + " len2: " + l2);
        System.out.println(a1.length);

        int i = 0, j = 0;

        while (i < l1 && j < l2) {
            // don't use while loops for leaving dups => bcoz if at the end of the arr all dups are present then V also need to handle the case after the while loops where index var must not increase the size of the array
            // while ( (i > 0 && i < l1) && a1[i] == a1[i-1]) {
            //     // System.out.println(i);
            //     // System.out.println(i + " equals: " + a1[i] );
            //     i++;
            // }
            // while (j > 0 && j < l2 && a2[j] == a2[j-1]) {
            //     // System.out.println("j: "+ j + " equals: " + a2[j] );
            //     j++;
            // }

            // if (i > l1 || j >= l2) break;
            System.out.println("====");

            if (i > 0 && a1[i] == a1[i-1]) {
                i++;
                continue;
            }

            if (a1[i] == a2[j]) {
                System.out.println(a1[i]);
                i++;
                j++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                i++;
            }
        }
    }


    // Naive 2
    public static void naive2(int a1[], int a2[]) {
        int l1 = a1.length;
        int l2 = a2.length;
        for (int i = 0; i < l1; i++) {
            boolean isRepeated = false;

            // this method will be used when arr is not sorted
            for (int j = 0; j < i; j++) {
                if (a1[i] == a1[j]) {
                    isRepeated = true;
                }
            }

            if (isRepeated) {
                continue;
            }

            for (int j = 0; j < l2; j++) {
                if (a1[i] == a2[j]) {
                    System.out.println(a1[i]);
                    break;
                }
            }
        }
    }

    // Naive 1
    public static void naive(int a1[], int a2[]) {

        int l1 = a1.length;
        int l2 = a2.length;

        for (int i = 0; i < l1; i++) {
            // while (i > 0 && i < l1 && a1[i] == a1[i-1]) {
            //     i++;
            // }
            if (i > 0 && a1[i] == a1[i-1]) {
                continue;
            }


            for (int j = 0; j < l2; j++) {
                // while (j > 0 && j < l2 && a2[j] == a2[j-1]) {
                //     j++;
                // }

                if (j > 0 && a2[j] == a2[j-1]) {
                    continue;

                }

                if (a1[i] == a2[j]) {
                    System.out.println(a1[i]);
                }
            }
        }

    }

}
