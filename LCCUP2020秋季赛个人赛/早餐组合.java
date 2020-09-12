/*
小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。

注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
*/

class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int left = 0;
        int right = drinks.length - 1;
        int point = 0;
        while(left < staple.length){
            int sum = staple[left] + drinks[right];
            if(sum > x){
                right--;
            }else{
                if(point == 0){
                    point = right;
                }
                right--;
                res++;
            }
            if(right < 0){
                left++;
                right = point;
            }
        }
        return res % 1000000007;

    }
}
最佳解法：
class Solution {
    final int MOD = 1000000007;

	public int breakfastNumber(int[] staple, int[] drinks, int x) {
		Arrays.sort(staple);
		Arrays.sort(drinks);

		int n1 = staple.length;
		int n2 = drinks.length;

		int ans = 0;

		int j = n2 - 1;

		for (int i = 0; i < n1; i++) {
			while (j >= 0 && staple[i] + drinks[j] > x) {
				j--;
			}

			if (j < 0) {
				break;
			}
			ans = (ans + j + 1) % MOD;
		}

		return ans;
	}
}