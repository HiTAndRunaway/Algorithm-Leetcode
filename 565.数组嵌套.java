方法一：小部分剪枝 342ms 13%
class Solution {
    public int arrayNesting(int[] nums) {
        int res = 1;
        for(int i=0;i < nums.length;i++){
            //剪枝 只要当前环的长度大于数组的一半 即可立即返回 是最大环
            if(res > nums.length / 2){
                return res;
            }
            int currmax = 1;
            int currval = nums[nums[i]];
            //找到以i位置开始的数组中存在的最大的环
            while(nums[i] != currval){
                currmax++;
                currval = nums[currval];
            }
            //保存当前最大环的长度
            res = Math.max(res,currmax);
        }
        return res;
    }
}
方法二：大部分剪枝 2ms 95%
class Solution {
    public int arrayNesting(int[] nums) {
        int res = 1;
        boolean[] visited = new boolean[nums.length];
        for(int i=0;i < nums.length;i++){
            //剪枝 只要当前环的长度大于数组的一半 即可立即返回 是最大环
            if(res > nums.length / 2){
                return res;
            }
            //若该值被访问过 则以该元素开头必定不会出现最大环
            if(visited[nums[i]]){
                continue;
            }
            visited[nums[i]] = true;
            int currmax = 1;
            int currval = nums[nums[i]];
            //找到以i位置开始的数组中存在的最大的环
            while(nums[i] != currval){
                visited[currval] = true;
                currmax++;
                currval = nums[currval];
            }
            //保存当前最大环的长度
            res = Math.max(res,currmax);
        }
        return res;
    }
}