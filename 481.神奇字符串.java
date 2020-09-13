class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 2; // 第0位无实际意义，只是为了编码简便，可以直接从 i-1 位置获得上一个字符，取反之后就是接下来该出现的字符
        arr[1] = 1;
        arr[2] = 2;
        int i = 1, j = 1, count = 0;
        while(i <= n && j <= n){
            int t = arr[i++]; //t = 重复次数
            int num = arr[j - 1] == 1 ? 2 : 1; // num = 接下来该重复的字符
            while(t > 0 && j <= n){
                arr[j++] = num;
                if(num == 1) count++; // count = 1 出现的次数
                t--;
            }
        }
        return count;
    }

}