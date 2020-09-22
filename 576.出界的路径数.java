方法一：dfs（TLE）
class Solution {
    private int res = 0;
    public int findPaths(int m, int n, int N, int i, int j) {
        dfs(m,n,N,i,j);
        return res;
    }

    public void dfs(int m, int n, int N, int i, int j){
        if(i > m - 1 || j > n - 1 || i < 0 || j < 0){
            res++;
            return;
        }
        if(N == 0){
            return;
        }
        dfs(m,n,N-1,i,j-1);
        dfs(m,n,N-1,i,j+1);
        dfs(m,n,N-1,i-1,j);
        dfs(m,n,N-1,i+1,j);
    }
}

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m,n,N,i,j) % 1000000007;

    }

    public int dfs(int m, int n, int N, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 1;
        }
        if(N == 0){
            return 0;
        }
        return dfs(m,n,N-1,i+1,j) + dfs(m,n,N-1,i-1,j) + dfs(m,n,N-1,i,j-1) + dfs(m,n,N-1,i,j+1);
    }
}
方法二：动态规划(AC)
class Solution {
    /**
        动态规划, dp[i][j][k]表示从(i, j)开始在k步内移除边界的路径数. 
        可知dp[i][j][k]只与(i, j)四周邻接点在k-1步内移除边界的路径数有关. 
        dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
        空间优化: 可以看出重复利用一个二维数组储存路径数即可(k-1步更新之后就无需保存)
    **/
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N <= 0) return 0;
        int mod = 1000000007;
        int[][][] dp = new int[m][n][N+1];
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int k = 1; k <= N; ++k) {
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        // 边界处理, 无论在第几步只要位置处于边界都包含一步出界的情况
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) 
                            dp[x][y][k] += 1;
                        else
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k-1]) % mod;
                    }
                }
            }
        }
        
        return dp[i][j][N];

    }
}