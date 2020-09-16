方法一：哈希map+set存储 3ms
class Solution {
    public int findLUSlength(String[] strs) {
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        for(String s : strs){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        Set<String> again = new HashSet<>(); //重复字符串集合
        Set<String> notagain = new HashSet<>(); //不重复字符串集合
        //遍历map中的键值对 方法都是Map的API
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value > 1){
                again.add(key);
            }else{
                notagain.add(key);
            }
        }

        for(String s1 : notagain){
            int curlen = s1.length();
            for(String s2 : again){
                //如果s1是s2的子序列 直接终止该层循环 证明s1并不是独一无二的子序列
                if(isSubseq(s1,s2)){
                    curlen = 0; //这里将当前长度置空是为了不影响下面max函数的比较赋值
                    break;
                }
            }
            max = Math.max(curlen,max);
        }
        return max == 0 ? -1 : max; 

    }
    //判断s1是否是s2的子序列
    private boolean isSubseq(String s1,String s2){
        int indexs1 = 0;
        int indexs2 = 0;
        while(indexs1 < s1.length() && indexs2 < s2.length()){
            if(s1.charAt(indexs1) == s2.charAt(indexs2)){
                indexs1++;
            }
            indexs2++;
        }
        return indexs1 == s1.length();
    }
}

方法二：排序 1ms
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b)->b.length()-a.length());
        for(int i=0; i<strs.length; i++){
            boolean valid = true;
            for(int j=0; j<strs.length; j++){
                if(i != j && strs[i].length() <= strs[j].length()){
                    if(isSubsequence(strs[i], strs[j])){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid)
                return strs[i].length();
        }
        
        return -1;
    }
    
    private boolean isSubsequence(String a, String b){
        if(a.length() == b.length())
            return a.equals(b);
        
        int i=0, j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else
                j++;
        }
        
        return i== a.length();
    }
}