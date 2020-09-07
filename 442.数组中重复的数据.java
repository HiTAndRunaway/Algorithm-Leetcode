方法一：排序
public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> smap = new HashMap<>(); //记录s的每个字符和出现的次数
        Map<Character,Integer> pmap = new HashMap<>(); //记录p的每个字符和出现的次数
        for(char ch : p.toCharArray()){
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0; //候选字符的个数
        int len = p.length();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0) + 1);
            //如果 p 中包含当前字符，且s的窗口中该字符出现次数不足，则该字符可以作为候选字符，count加一
            if(pmap.containsKey(ch) && smap.get(ch) <= pmap.get(ch)){
                count++;
            }
            //当候选字符个数等于p长度，此时left为起始索引
            if(count == len){
                res.add(left);
            }
            //当窗口大小等于p长度时，窗口左边需要收缩一个字符
            if(right - left + 1 >= len){
                char leftChar = s.charAt(left);
                //判断收缩的这个字符是否是候选字符，是则count减一
                if(pmap.containsKey(leftChar) && smap.get(leftChar) <= pmap.get(leftChar)){
                    count--;
                }
                //窗口收缩一个字符
                smap.put(leftChar,smap.getOrDefault(leftChar,1) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
方法二：技巧
/**
     * 这个题属于技巧题 首先仔细看输入的给定的数组值 该值的区间为 1 ≤ a[i] ≤ n
     * 这其实是这道题解题的关键点，好好利用这个信息。 某些元素出现了两次，
     * 而一些其他的元素只出现了1次，我们可以利用这些元素在出现次数上面的不一样做文章。
     *
     * 仔细观察发现1 ≤ a[i] ≤ n 这个条件，正好和我们数组的下标差1，我们可以按照数值
     * 来遍历数组，那么在数组中具有相同值的元素，会被经过两次，那么我们只要想出一种方式
     * 在这个遍历结束后可以区分，哪些元素被经过了多次即可，由于数组元素具有1 ≤ a[i] ≤ n
     * 这样的范围，那其实我们当每次经过一个元素时，给他加上n，当遍历结束时，我们再次遍历数组
     * 那些数值超过2n的元素索引+1，对应的就是我们的出现了两次的元素。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) ret.add(i+1);
        }
        return ret;
    }