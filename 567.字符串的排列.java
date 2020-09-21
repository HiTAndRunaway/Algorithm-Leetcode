class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //记录s1中所有字符出现次数
        Map<Character, Integer> target = new HashMap<>();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        //记录窗口中的相应字符出现次数
        Map<Character, Integer> window = new HashMap<>();
        //count记录窗口中满足条件的字符数量
        int left = 0, right = 0, count = 0;
        char[] chars = s2.toCharArray();
        while (right < chars.length) {
            //扩大窗口
            char c = chars[right++];
            //如果是s1中的字符，更新窗口
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果窗口中相应字符出现次数等于s1中字符出现次数，更新count
                if (window.get(c).equals(target.get(c))) count++;
            }
            //当窗口长度等于s1的长度，缩小窗口
            if (right - left == s1.length()) {
                //窗口中所有字符都是s1中的字符，返回true
                if (count == target.size()) return true;
                //缩小窗口
                char d = chars[left++];
                //如果是s1中的字符，更新窗口
                if (target.containsKey(d)) {
                    if (window.get(d).equals(target.get(d))) count--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}