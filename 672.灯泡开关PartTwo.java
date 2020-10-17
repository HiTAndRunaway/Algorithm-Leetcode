class Solution {
    public int flipLights(int n, int m) {
        if(m == 0){
            return 1;
        }
        if(n <= 1){
            return 2 * n;
        }
        if(n == 2){
            return (m == 1) ? 3 : 4;
        }
        if(m == 1){
            return 4;
        }else if(m == 2){
            return 7;
        }
        return 8;
    }
}