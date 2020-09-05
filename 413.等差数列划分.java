方法一：dp
/*
*从小的例子出发,仔细观察,会发现当整个数组为(1, 2, 3, 4, 5, 6)的时候,我们先取出前三个,(1, 2, 3)的等差数列的个数为1,(1, 2, 3, 4)的等差数*列的个数为3,(1, 2, 3, 4, 5)的等差数列的个数为6,(1, 2, 3, 4, 5, 6)的等差数列个数为10,以此类推我们可以很容易的发现在一个等差数列中加入一个数*字,如果还保持着等差数列的特性,每次的增量都会加1,如果刚加进来的数字与原先的序列构不成等差数列,就将增量置为0,接下来继续循环,执行以上的逻辑即可.
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2)
            return 0;
        int res = 0;
        int add = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                res += ++add;
            else
                add = 0;
        return res;
    }
}
方法二：暴力解法
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i < nums.length - 1;i++){
            int pubgap = nums[i+1] - nums[i];
            list.add(nums[i]);
            list.add(nums[i+1]);
            for(int j=i+1;j < nums.length - 1;j++){
                int curgap = nums[j+1] - nums[j];
                if(curgap == pubgap){
                    list.add(nums[i+1]);
                    if(list.size() >= 3){
                        res++;
                    }
                }else{
                    break;
                }
            }
            list.clear();
        }
        return res;
    }
}