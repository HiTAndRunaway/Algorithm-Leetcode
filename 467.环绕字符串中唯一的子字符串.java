class Solution {
        /**
        *统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
        *例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
        *总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
        **/
        public int findSubstringInWraproundString(String p){
            int[] dp = new int[26];
            int cnt = 1, n = p.length();
            char[] cs = (" " + p).toCharArray();
            for(int i = 1; i <= n; i++){
                int idx = cs[i] - 'a';
                if(check(cs[i - 1], cs[i])) cnt++;
                else cnt = 1;
                dp[idx] = Math.max(dp[idx], cnt);
            }
            int ans = 0;
            for(int i = 0; i < 26; i++) {
                ans += dp[i];
            }
            return ans;
        }

        public boolean check(char a, char b){
            if(a == 'z' && b == 'a') return true;
            return b - a == 1;
        }
}