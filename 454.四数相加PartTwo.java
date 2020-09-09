class Solution {
    /*先把A和B中所有的组合之和以及出现的次数记录在map中，然后遍历所有C和D的组合之和，取其相反数
    * 并看它是否在map中出现过，若出现过，则count = count + 出现的次数
    */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0){
            return count;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a + b,map.getOrDefault(a + b,0) + 1);
            }
        }
        for(int c : C){
            for(int d : D){
                int sumcd = 0 - (c + d);
                if(map.containsKey(sumcd)){
                    count += map.get(sumcd);
                }
            }
        }
        return count;

    }
}