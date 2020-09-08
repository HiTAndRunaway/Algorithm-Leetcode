class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        //按右端点升序排列
        Arrays.sort(points, (o1,o2) -> (o1[1] - o2[1]));
        int count = 1; //至少只需要一支箭可以射完所有气球
        int arrow = points[0][1];
        for(int i=0;i < points.length;i++){
            //这支箭无法射中当前这个目标 count++
            if(arrow < points[i][0]){
                count++;
                arrow = points[i][1]; //下一支箭在下一个气球的右端点开射
            }
        }
        return count;

    }
}