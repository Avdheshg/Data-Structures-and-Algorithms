import java.util.*;

public class CoinChange {

    // this question is for counting the total number of combinations formed for the given sum from the given coins 
    private static int count = 0;

	public static void main(String[] args) {
		
		// int coins[] = new int[]{2,5,3,6};
		// int sum = 10;
		int coins[] = new int[]{1, 2, 5};
		int sum = 11;

		// System.out.println(recursive(coins, coins.length, sum));
		System.out.println(memo(coins, coins.length, sum));
        System.out.println("Count: " + count);
	}

    /*
        Naive Algo: 
            V will take coins[], len, sum
            Base case: for "len" and "sum"

            **** Consider and Don't  **** 
                Don't Consider: reduce then length and don't change the sum
                Consider: don't change the len but change the sum i.e V R considering the [len-1]th coin and checking it recursively that does it will be able ti make the required sum 
    */
	public static int recursive(int[] coins, int len, int amount) {
        count++;
        // ***** Base case
        if (amount == 0) return 1;
        if (len == 0) return 0;
        
        // ***** Choices        
        // Don't consider
        int res = recursive(coins, len-1, amount);

        // Consider
        if (coins[len-1] <= amount) {
            res = res + recursive(coins, len, amount - coins[len-1]);
        }
        
        return res;
    }

    /*
        Efficient Algo: 
            dp[i][j] means the number of combinations V can get with sum i and coin from i to j
                dp[][]:    sum
                                dp[i][j]
                * if sum = 0(no matter of how much coins are left) => then v have only 1 way to pick any coin i.e pick no coin => fill the whole row with 1
                * if len = 0(no matter what the sum is) => V can't make any sum as no coins are left => fill the whole column with 0
                
        TR the whole matrix 
            for each cell in the matrix,
                get the val the of the prev cell of current row (this is when V don't want to consider the current coin)
                * If V wants to conider the current coin, then in the coins array check if the [j-1]th coin is less than current sum(i)

                    If yes, 
                        subtract the current coin( coin[j-1] ) from the current sum(i) and
                        the save it to the dp[i][j]

        Why V have taken matrix in the form, [sum+1]*[n+1] not [n+1][sum+1] bcoz by using [n+1][sum+1] =>  for a coin, V will be going through all the sums      
            in this case loop will be
                for (int i = 1; i <= len; i++) {
                    for (int j = 1; i <= sum; j++) {

                    }
                }            
                This will given wrong res
        but using [sum+1]*[n+1] , for a sum V R going through all the sums


    */
    public static int memo(int coins[], int len, int sum) {
        count++;
        int dp[][] = new int[sum+1][len+1];
        // if sum = 0, filling the 1st row 
        Arrays.fill(dp[0], 1);
        // if len = 0, fill the 1st col with 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[i][0] = 0;
        }
        // printing the matrix
        // System.out.println("Printing the matrix");
        // for (int[] arr: dp) {
        //     for (int x: arr) {
        //         System.out.print(x + " ");
        //     }
        //     System.out.println();
        // }

        // TR the whole matrix
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= len; j++) {
                
                // Don't consider the current coin
                dp[i][j] = dp[i][j-1];

                // consider the current coin
                    // if the cal of current coin is less or equal to current sum(i), then only consider
                if (coins[j-1] <= i) {
                    dp[i][j] += dp[i - coins[j-1] ][j]; 
                }

            }
        }
        return dp[sum][len];
    }


}