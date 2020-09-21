class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //初始值
        map.put(0,1);
        int sum = 0,res = 0;
        for(int i=0;i < nums.length;i++){
            //每个数组元素累加 每一次累加的和都是连续子数组的和
            sum += nums[i];
            //判断map中是否存在sum - k 若存在 则说明一定有一个连续子数组满足和为k
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return res;
    }
}