import java.util.*;

public class UnionOf2UnsortedArrays {

    // Naive: O( m*m + n*(m+n) )
    /*  
        Idea: 
            Suppose V R having 2 rooms and from these 2 rooms V need to find all those elements which either present in room1 or room2 or are common in both. How do V do this?
                V will use 2 persons: One(p1) will stand in room1(a[]) and other will stand in Main room(AL). Which going through all the items p1 will ask main person(MP) that the current item is present in MR or not
                    If not present then V will through the current item into MR
                    If present, then p1 will move to the next item in room1
                Do the same for room2

            Make 2 persons, 1 is standing at one array(which V R current processing) and other is present in another room
        Algo: 
            Define an aux AL (the purpose of AL is that it will hold only the distinct elements from both the arrays)
            TR a[], 
                for each ele of a check if it is present in the AL, 
                    if yes: break => means this ele is repeating, 
                    if no => add it to the AL
            Do same for b[]

            Extra work: one extra loop V R using for TR through the AL for checking if the current element is repeating or not => main process V R doing here is inserting and searching an item and the best DS for this is HM 
    */
    public static void naive(int a[], int b[]) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            boolean isPre = false;
            for (int j = 0; j < al.size(); j++) {
                if (a[i] == al.get(j)) {
                    isPre = true;
                    break;
                }
            }
            if (!isPre) {
                al.add(a[i]);
            }
        }

        System.out.println("After a[], AL: " + al);

        for (int i = 0; i < b.length; i++) {
            boolean isPre = false;
            for (int j = 0; j < al.size(); j++) {
                if (b[i] == al.get(j)) {
                    isPre = true;
                    break;
                }
            }
            if (!isPre) {
                al.add(b[i]);
            }
        }

        System.out.println("after both arr, AL: " + al + " and total number of distinct elements: " + al.size());
    }

    /*
        Algo: Put all the ele of both the arrays and return the size
    */
    public static void efficient(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int x: a) {
            set.add(x);
        }
        for (int x: b) {
            set.add(x);
        }
        System.out.println(set + " and the total distinct : " + set.size());
    }

    public static void main(String[] args) {
        int a[] = new int[]{10,20,30, 10,20,30, 5,10,5};
        int b[] = new int[]{5,10,5, 5,10,5, 10,20,30};

        // naive(a, b);
        efficient(a, b);
    }

}
