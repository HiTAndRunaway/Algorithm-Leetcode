class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] res = new int[26];
        for(char c : A[0].toCharArray()){
            res[c - 'a']++;
        }

        for(int i=1;i < A.length;i++){
            int[] tmp = new int[26];
            for(char c : A[i].toCharArray()){
                tmp[c - 'a']++;
            }
            for(int j=0;j < tmp.length;j++){
                res[j] = Math.min(res[j],tmp[j]);
            }
        }

        for(int i=0;i < res.length;i++){
            if(res[i] > 0){
                for(int j=0;j < res[i];j++){
                    String str = "" + (char)('a' + i);
                    ans.add(str);
                }
            }
        }
        return ans;

    }
}