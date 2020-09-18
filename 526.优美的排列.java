class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visit = new boolean[N+1];
        backtrace(N,1,visit);
        return count;
    }

    public void backtrace(int N,int start,boolean[] visit){
        if(start > N){
            count++;
        }
        for(int i = 1;i <= N;i++){
            if(!visit[i] && (start % i == 0 || i % start == 0)){
                visit[i] = true;
                backtrace(N,start + 1,visit);
                visit[i] = false;
            }
        }
    }
}