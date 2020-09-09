方法一：暴力解法
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        Stack<Integer> s = new Stack<>();
        int index = 0;
        s.push(nums[index]);
        while(!s.isEmpty()){
            for(int i=index+1;i < nums.length - 1;i++){
                int pretop = s.peek();
                if(nums[i] > pretop){
                    s.push(nums[i]);
                }else{
                    continue;
                }
                for(int j=i+1;j < nums.length;j++){
                    if(nums[j] < s.peek() && nums[j] > pretop){
                        return true;
                    }
                }
                s.pop();
                
            }
            while(!s.isEmpty()){
                s.pop();
            }
            index++;
            if(index < nums.length - 2){
                s.push(nums[index]);
            }
            
        }
        return false;

    }
}
方法二：deque
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(nums[i],min[i-1]);
        }
        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i] > min[i]){
                while(!stack.isEmpty() && stack.peekLast() <= min[i]){
                    stack.removeLast();
                }
                if(!stack.isEmpty() && stack.peekLast() < nums[i]){
                    return true;
                }
                stack.addLast(nums[i]);
            }
        }
        return false;
    }
}