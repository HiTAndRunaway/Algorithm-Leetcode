class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=nums.length - 1;i >= 0;i--){
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    res += (right - 1 - left) + 1;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;

    }

    
}