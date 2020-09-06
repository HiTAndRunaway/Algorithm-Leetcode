//方法一：暴力解法
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if(intervals.length == 0){
            return new int[]{};
        }
        int[] res = new int[intervals.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i < intervals.length;i++){
            int index = Integer.MAX_VALUE;
            int gap = Integer.MAX_VALUE;
            for(int j=0;j < intervals.length;j++){
                if(intervals[i][1] <= intervals[j][0]){
                    if(gap > intervals[j][0] - intervals[i][1]){
                        gap = intervals[j][0] - intervals[i][1];
                        index = j;
                    }
                    index = Math.min(index,j);
                }
            }
            if(index == Integer.MAX_VALUE){
                list.add(-1);
            }else{
                list.add(index);
            }
        }
        for(int i=0;i < intervals.length;i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
//方法二：二分查找
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] in = new int[n][2]; //记录下集合的起点的位置
        int[] res = new int[n];
        for(int i=0;i < n;i++)
        {
            in[i][0] = intervals[i][0];
            in[i][1] = i;
        }
        Arrays.sort(in, new Comparator<int[]>() {//将起点排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i=0;i < n;i++)
        {
            int l = 0,r = n - 1;
            while (l <= r)//二分查找
            {
                int mid = (r - l) / 2 + l;
                if(in[mid][0] >= intervals[i][1])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            if(l == 0 || l == n){
                res[i] = -1;//找不到
            }else
                res[i]=in[l][1];
        }
        return res;
    }
}
