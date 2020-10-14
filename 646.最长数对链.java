class Solution {
    public int findLongestChain(int[][] pairs) {
        //Java+贪心
        Arrays.sort(pairs,(o1,o2) -> o1[1] - o2[1]);
        int res = 1;
        int tmp = pairs[0][1];
        for(int i=0;i < pairs.length;i++){
            if(pairs[i][0] > tmp){
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }
}