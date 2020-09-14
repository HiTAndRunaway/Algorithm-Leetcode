class Solution {
    //遍历方向由层数决定
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[]{};
        }
        int r = 0;
        int c = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[matrix.length * matrix[0].length];
        for(int i=0;i < res.length;i++){
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if((r + c) % 2 == 0){
                if(c == col - 1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }

            }else{
                if(r == row - 1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;

    }
}