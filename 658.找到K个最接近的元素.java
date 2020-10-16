方法一：二分排序 + 双指针
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) return res;
        int l = 0;
        int r = arr.length;
        while (r - l > 1) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == x) {
                l = mid;
                r = mid + 1;
            } else if (arr[mid] > x) r = mid;
            else l = mid;
        }
        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else {
                if (arr[r] - x < x - arr[l]) {
                    r++;
                } else {
                    l--;
                }
            }
            k--;
        }
        for (int i = l + 1; i < r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
方法二：API
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }
}