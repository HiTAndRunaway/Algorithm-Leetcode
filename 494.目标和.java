//方法一：深度优先遍历
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,0,S);
        return count;
    }

    public void dfs(int[] nums,int i,int sum,int S){
        if(i == nums.length){
            if(sum == S){
                count++;
                return;
            }
        }else{
            dfs(nums,i + 1,sum + nums[i],S);
            dfs(nums,i + 1,sum - nums[i],S);
        }

    }
}
//方法二：动态规划
class Solution {
    /*
    * 设nums中全是正数的集合为P，nums中全是负数的集合为N，目标值为S，则：
    * sum(p) - sum(n) = s
    * sum(p) + sum(n) + sum(p) - sum(n) = s + sum(p) + sum(n)
    * 2 * sum(p) = s + sum(nums)
    * sum(p) = (s + sum(nums)) / 2
    * 所以可将题目转换为有多少种方法能让正数集合P的总和为(s + sum(nums)) / 2，而这是一个定值
    * 即0-1背包问题，动态规划，维护一个一位数组dp,dp[i]代表当正数集合总和为i时，最多有几种方法
    * 最后返回dp[(s + sum(nums)) / 2]即可
    */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S || (sum + S) % 2 == 1){
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w+1];
        dp[0] = 1;
        for(int num : nums){
            for(int i=w;i >= num;i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[w];

    }
}