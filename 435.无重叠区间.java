class Solution {
    /*
    *贪心策略，先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
    *在每次选择中，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
    *按区间的结尾进行升序排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
    *在对数组进行排序的时候也可以使用 lambda 表示式来创建 Comparator ，不过算法运行时间会比较长点
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        if(intervals.length == 0 || intervals[0].length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int pre = intervals[0][1];
        for(int i=0;i < intervals.length;i++){
            if(intervals[i][0] < pre){
                continue;
            }
            pre = intervals[i][1];
            count++;
        }
        return intervals.length - count;


    }
}