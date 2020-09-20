class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }
        if(nums.length == 2){
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        String res = String.valueOf(nums[0]) + "/(";
        for(int i=1;i < nums.length;i++){
            res += String.valueOf(nums[i]) + "/";
        }
        int n = res.length();
        res = res.substring(0,n-1);
        res += ")";
        return res;

    }
}