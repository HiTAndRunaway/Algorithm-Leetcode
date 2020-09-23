class Solution {
    public String fractionAddition(String expression) {
        boolean fushuflag = expression.charAt(0) == '-';
        expression = expression.replace("-","+-");
        String[] splits = expression.split("\\+");
        int[] fenzi = new int[splits.length];
        int[] fenmu = new int[splits.length];
        int sum_fenmu = 1;
        int i = 0;
        if(fushuflag == true){
            i = 1;
        }
        for(;i < splits.length;i++){
            fenzi[i] = Integer.parseInt(splits[i].split("/")[0]);
            fenmu[i] = Integer.parseInt(splits[i].split("/")[1]);
            sum_fenmu *= fenmu[i];
        }
        int sum = 0;
        i = 0;
        if(fushuflag == true){
            i = 1;
        }
        for(;i < splits.length;i++){
            sum += sum_fenmu / fenmu[i] * fenzi[i];
        }
        int yuenum = this.func(sum,sum_fenmu);
        return sum / yuenum + "/" + sum_fenmu / yuenum;
    }
//辗转相除法 func
    public int func(int m,int n){
        m = Math.abs(m);
        n = Math.abs(n);
        int res = 0;
        while(n != 0){
            res = m % n;
            m = n;
            n = res;
        }
        return m;
    }
}