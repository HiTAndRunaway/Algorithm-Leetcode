/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while(true){
            //若使用rand7()+rand7()-1 得到的每个数的概率并不相等 如5 = 2+3 or 3+2，而 14 = 7 + 7 所以使用乘法
            //为什么要乘7 是因为只有乘7的时候才是等概率的 
            int num = (rand7() - 1) * 7 + rand7();
            //若在40以内 直接返回
            if(num <= 40){
                return 1 + num % 10;
            }
            //说明随机数在41-49之间 再次随机处理一次
            num = (num - 40 - 1) * 7 + rand7();
            //此时num得到的数在1-63之间 若随机数小于等于60 直接返回
            if(num <= 60){
                return 1 + num % 10;
            }
            //说明在61-63之间 再次随机处理一次
            num = (num - 60 -1) * 7 + rand7();
            //此时得到的数在1-21之间 若小于等于20 直接返回
            if(num <= 20){
                return 1 + num % 10;
            }
        }
        
    }
}