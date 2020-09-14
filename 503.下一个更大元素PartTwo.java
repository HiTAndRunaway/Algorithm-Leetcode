class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> s = new Stack<>();
        for(int i=0;i < 2*n;i++){
            int num = nums[i % n];
            while(!s.isEmpty() && num > nums[s.peek()]){
                res[s.pop()] = num;
            }
            if(i < n){
                s.add(i);
            }
        }
        return res;

    }
}