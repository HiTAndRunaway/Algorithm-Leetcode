class Solution {
    /*
    * java dp
    * 1.如果n是质数，dp[i] = i;
    * 2.如果n不是质数，则dp[i] = dp[j] + dp[i / j];
    * 例如 dp[8] 8不是质数 所以dp[8] = dp[4] + dp[2]
    *      dp[4] 4不是质数 所以dp[4] = dp[2] + dp[2]
    *      dp[2] 2是质数 所以dp[2] = 2
    */
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i < n + 1;i++){
            dp[i] = i;
            for(int j=2;j < i / 2;j++){
                if(i % j == 0){
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }
}