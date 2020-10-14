class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] d = dictionary.toArray(new String[dictionary.size()]);
        Arrays.sort(d,(o1,o2) -> o1.length() - o2.length());
        String[] s = sentence.split(" ");
        String res = "";
        for(int i=0;i < s.length;i++){
            for(String pattern : d){
                int len = pattern.length();
                if(s[i].length() < len){
                    continue;
                }
                if(s[i].substring(0,pattern.length()).equals(pattern)){
                    s[i] = pattern;
                    break;
                }
            }
            
        }
        for(int i=0;i < s.length;i++){
            if(i == s.length - 1){
                res += s[i];
            }else{
                res += s[i] + " ";
            }
            
        }
        return res;

    }
}