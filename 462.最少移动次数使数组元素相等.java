方法一：数学
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while(left < right){
            res += nums[right--] - nums[left++];
        }
        return res;

    }
}
方法二：数学
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int midset = nums[mid];
        int step = 0;
        for(int i=0;i < nums.length;i++){
            step += Math.abs(nums[i] - midset);
        }
        return step;

    }
}