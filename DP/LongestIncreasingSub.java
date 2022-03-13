public class LongestIncreasingSub {

    /*
        Naive: Generate all the sub and then find the max out of it => O(2^n) bcoz there will be total of 2^n subsequences

        DP Sol
            Find the LIS ending with every element i.e what is the LIS that ends with the current element(or V can say V R finding all the previous elements which form the LIS that ends with the current element or the current element will be the last element of the sub starting from the 0 index)

            For each element V will be storing the LIS for each element and for this purpose V need an DS which can store the LIS val for element. For this purpose V will use an array
            lis[i] = means that LIS that ends with the current i. lis[0] = 1, bcoz there is no lis ending with lis[0] other than itself

            What V need to do with the lis[] ?
                V need to fill the whole array and find the max from it

            The main Question is, how do V fill the lis[] ?
                Algo: 
                    define a lis[] and fill the lis[0]
                    TR all the elements which R on the left of current element and are smaller than current ele
    */

    public static int LIS(int arr[], int len) {
        int lis[] = new int[n];
        lis[0] = 1;

        for (int i = 1; i < len; i++) {
            
        }
    }

}
