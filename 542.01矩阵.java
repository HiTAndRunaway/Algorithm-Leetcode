方法一：dfs(递归)
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    int m;
    int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if(m == 0)
            return matrix;
        n = matrix[0].length;
        
        /* 将周围没有0，且值为1的位置 设置为一个极大值*/
        for(int i=0;i < m;i++){
            for(int j=0;j < n;j++){
                if(matrix[i][j] == 1 && !hasNeighbors0(matrix,i,j)){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i < m;i++){
            for(int j=0;j < n;j++){
                if(matrix[i][j] == 1){
                    dfs(matrix,i,j);
                }
            }
        }
        return matrix;
    }
    /* 判断周围四个方向是否有0 */
    public boolean hasNeighbors0(int [][]matrix,int x,int y){ 
         
        for(int[] dir : dirs){
            int new_x = x + dir[0];
            int new_y = y + dir[1];
            if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && matrix[new_x][new_y] == 0){
                 return true;
            }
        }
        return false;
    }

    public void dfs(int [][]matrix,int x,int y){
        for(int[] dir : dirs){
            int new_x = x + dir[0];
            int new_y = y + dir[1];
            if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && matrix[new_x][new_y] > matrix[x][y] + 1){
                matrix[new_x][new_y] = matrix[x][y] + 1;
                dfs(matrix,new_x,new_y);
            }
            
        }
    }
}
方法二：bfs(迭代)
class Solution {
    private int row;
    private int col;
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                } else {
                    //初始化一个最大值
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 搜索上下左右四个方向
            for (int[] v : vector) {
                int r = s[0] + v[0], c = s[1] + v[1];
                if (r >= 0 && r < row
                        && c >= 0 && c < col
                        && matrix[r][c] > matrix[s[0]][s[1]] + 1) {
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }

}
