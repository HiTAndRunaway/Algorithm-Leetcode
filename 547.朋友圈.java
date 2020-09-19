class Solution {
    //有点像求连通分量 并查集的应用
    public int findCircleNum(int[][] M) {
        //M是矩阵 长和宽相等 统一用M.length
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for(int i=0;i < M.length;i++){
            //遍历每一行 如果有没被访问的朋友 访问他 把他的朋友遍历完后 朋友圈数+1
            if(!visited[i]){
                dfs(M,visited,i);
                res++;
            }
        }
        return res;

    }

    public void dfs(int[][] M,boolean[] visited,int i){
        //固定一个人 把他的朋友遍历一遍 遍历过的朋友将其visited数组的值变为true已访问 然后再继续遍历他的朋友 依此类推
        for(int j=0;j < M.length;j++){
            if(M[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(M,visited,j);
            }
        }

    }
}