class Solution {
    public String findLongestWord(String s, List<String> d) {
        int currlen = Integer.MIN_VALUE;
        int resindex = -2;
        for(int i=0;i < d.size();i++){
            String str = d.get(i);
            if(isSubSeq(str,s)){
                if(currlen == str.length()){
                    if(strcmp(str,d.get(resindex)) == -1){
                        resindex = i;
                    }
                }else if(currlen < str.length()){
                    currlen = str.length();
                    resindex = i;
                }
            }
        }
        if(resindex == -2){
            return "";
        }
        return d.get(resindex);

    }

    private boolean isSubSeq(String s1,String s2){
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

    private int strcmp(String s1,String s2){
        for(int i=0;i < s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i)){
                continue;
            }else if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }else if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }
        }
        return 0;
    }
}