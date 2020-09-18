class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        //将时间转换为分钟数
        for(int i=0;i < timePoints.size();i++){
            arr[i] = Integer.parseInt(timePoints.get(i).substring(0,2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i < arr.length;i++){
            min = Math.min(min,arr[i] - arr[i-1]);
        }
        //第一个时间与最后一个时间判断 中间隔一天
        return Math.min(min,arr[0] + 24 * 60 - arr[arr.length-1]);

    }
}