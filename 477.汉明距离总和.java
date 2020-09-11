class Solution {
    public int totalHammingDistance(int[] nums) {
        /*
        *4： 0 1 0 0
        *14：1 1 1 0
        *2： 0 0 1 0
        *-------------
        *第高位：两个0，一个1， 有2*1个
        *其次为：两个1，一个0， 有2*1个
        *其次位：两个1，一个0， 有2*1个
        *最低位：三个零，       有3*0个
        *最后得6
        */
        int res = 0;
        int n = nums.length;
        //数组元素的范围从0-10^9次方 而10的9次方用30位二进制足矣
        for(int i=0;i < 30;i++){
            int onecount = 0;
            for(int j=0;j < n;j++){
                onecount += (nums[j] >> i) & 1;
            }
            res += onecount * (n - onecount);
        }
        return res;
    }
}