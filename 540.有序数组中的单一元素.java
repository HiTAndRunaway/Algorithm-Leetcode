方法一：二分查找 o(logn)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int midset = left + (right - left) / 2;
            if(midset % 2 == 1){
                midset--;
            }
            if(nums[midset] == nums[midset+1]){
                left = midset + 2;
            }else{
                right = midset;
            }
        }
        return nums[left];

    }
}
方法二：位运算 o(n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for(int i : nums)
            num ^= i;
        
        return num;
    }
}