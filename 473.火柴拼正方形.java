class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4) return false;
        int sum = Arrays.stream(nums).sum();
        if(sum % 4 != 0) return false;
        Arrays.sort(nums);
        return dfs(nums,nums.length - 1,new int[4], sum >> 2);
    }

    private boolean dfs(int[] nums, int k, int[] sum, int target){
        if(k == -1)  return true;
        for(int i = 0; i < sum.length; ++i){
            if(sum[i] + nums[k] <= target){
                sum[i] += nums[k];
                if(dfs(nums, k - 1, sum, target)) return true;
                sum[i] -= nums[k];
            }
        }
        return false;
    }
}
