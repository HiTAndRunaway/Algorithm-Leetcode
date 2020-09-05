class Solution {
    //滑动窗口Sliding Window
    //当历史最大子串+K还小于当前窗口大小的时候 证明不能通过改变K个字符将其变成最大子串 将窗口向右平移 大小不变
    //当历史最大子串+K大于当前窗口大小的时候 证明可以改变K个字符将其变成最大子串 将窗口大小增大
    //最后返回窗口大小即可
    private int[] map = new int[26]; //在滑动窗口中各个字母出现的次数
    public int characterReplacement(String s, int k) {
        if(s == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        int premax = 0;
        char[] arr = s.toCharArray();
        for(right = 0; right < arr.length;right++){
            int index = arr[right] - 'A';
            map[index]++;
            premax = Math.max(premax,map[index]);
            if(right - left + 1 > premax + k){
                map[arr[left] - 'A']--;
                left++;
            }
        }
        return arr.length - left;
        

    }
}