public class MinCoinsToMakeValue {

	public static void main(String[] args) {
		
		int coins[] = new int[]{1, 2, 5};
		int amount = 11;

		System.out.println(minCoins(coins, amount));
	}

	public static int minCoin(int[] coins, int amount) {
        count++;
        
        if (amount == 0) return 0;
        
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < coins.length; i++) {
                
            if (coins[i] <= amount) {
                    
                int subRes = minCoin(coins, amount - coins[i]);
                
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
                
            } 
        }
        
        return res;
    }
}