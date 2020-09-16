动态规划
class Solution {
    public int change(int amount, int[] coins) {
        /*if(amount == 0){
            return 0;
        }
        if(coins.length == 0){
            return 0;
        }*/
        if(amount == 0 && coins.length == 0){
            return 1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int coin : coins){
            for(int i=0;i <= amount;i++){
                if(i >= coin){
                    dp[i] += dp[i - coin];
                }
                
            }
        }
        return dp[amount];

    }
}