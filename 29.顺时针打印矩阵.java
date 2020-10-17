class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int num = 0;
        while(left <= right && up <= down){
            for(int i=left;i <= right;i++){
                list.add(matrix[up][i]);
            }
            up++;
            for(int i=up;i <= down;i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i >= left && up <= down;i--){
                list.add(matrix[down][i]);
            }
            down--;
            for(int i=down;i >= up && right >= left;i--){
                list.add(matrix[i][left]);
            }
            left++;   
        }
        int[] res = new int[list.size()];
        for(int i=0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;

    }
}