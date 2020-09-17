class Solution {
    public int findMaxLength(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        //map用于记录数组中每一位0的个数-1的个数
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? 1 : -1;
            //如果当前位置0和1的数量相等 直接取最大长度并记录下来
            if (count == 0) {
                maxLen = Math.max(maxLen, i + 1);
                continue;
            }
            //用于记录不同位置上的0-1的个数
            if (map.get(count) == null) {
                map.put(count, i);
                continue;
            }
            //如果之前出现了一次0-1的个数为count 当前位上0-1的个数也为count 那么说明在这一位到前一次出现的位置上 0和1的数量相等
            maxLen = Math.max(maxLen, i - map.get(count));
        }
        return maxLen;
    }
}