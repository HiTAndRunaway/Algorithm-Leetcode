class Solution {
    /*
    *1.统计出度&入度&父节点（父节点最多有两个） 
    *2.如果存在入度为0的点，则存在入度为2的点node2。 顺着node2的一个父节点fa1往上找，找到环就返回这个边fa1->node2; 找不到随意返回一个入node2的边就行 
    *3.如果不存在入度为0的点，就返回一条边，这条边的子节点既有出度，也有入度
    */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        int[][] fa = new int[n+1][2];
        for(int[] edge:edges){
            out[edge[0]] ++;
            in[edge[1]] ++;
            if(fa[edge[1]][0]==0){
                fa[edge[1]][0] = edge[0];
            }else{
                fa[edge[1]][1] = edge[0];
            }
        }
        for(int i=1;i<=n;i++){
            if(in[i]==0){
                for(int j=1;j<=n;j++){
                    if(in[j]==2){
                        int x=fa[j][0];
                        while(fa[x][0]!=0 && fa[x][0]!=j) x=fa[x][0];
                        if(fa[x][0]==j) return new int[]{fa[j][0],j};
                        return new int[]{fa[j][1],j};
                    }
                }
                break;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(out[edges[i][1]]>=1 && in[edges[i][1]]>=1)  return edges[i];
        }
        return null;
    }
}