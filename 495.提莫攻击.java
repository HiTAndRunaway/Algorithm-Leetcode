//方法一：数组
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        if(timeSeries.length == 1){
            return duration;
        }

        int ashe_Poisone_time = 0;

        for(int i=1;i < timeSeries.length;i++){
            ashe_Poisone_time += Math.min(duration,timeSeries[i] - timeSeries[i-1]);
        }

        return ashe_Poisone_time + duration;
        

    }
}
//方法二：数组（与方法一相同，但是执行用时快方法一很多，可能是法一用了Math.min方法）
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        if(timeSeries.length == 1){
            return duration;
        }

        int ashe_Poisone_time = 0;

        for(int i=1;i < timeSeries.length;i++){
            if(timeSeries[i] - timeSeries[i-1] > duration){
                ashe_Poisone_time += duration;
            }else{
                ashe_Poisone_time += timeSeries[i]- timeSeries[i-1];
            }
        }
        ashe_Poisone_time += duration;

        return ashe_Poisone_time;
        

    }
}