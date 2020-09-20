
class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        //从后往前遍历 找到一位数小于他的下一位数（正序数）a[i]
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = a.length - 1;
        //然后继续从后想前遍历 找到第一个大于a[i]的数a[j]的索引j
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        //交换a[i]与a[j]
        swap(a, i, j);
        //再将逆序数反转成正序
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
