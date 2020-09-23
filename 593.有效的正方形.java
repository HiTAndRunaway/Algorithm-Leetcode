方法一：四条边相等 两条对角线也相等
class Solution {
    //四条边相等 两条对角线也相等
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dis = new int[6];
        dis[0] = distance(p1,p2);
        dis[1] = distance(p1,p3);
        dis[2] = distance(p1,p4);
        dis[3] = distance(p2,p3);
        dis[4] = distance(p2,p4);
        dis[5] = distance(p3,p4);
        //升序排列 边长在索引小的位置0，1，2，3  对角线较大 在索引大的位置4，5
        Arrays.sort(dis);
        //若至少有一点重合 则不能构成正方形
        if(dis[0] == -1){
            return false;
        }

        return dis[0] == dis[1] && dis[1] == dis[2] && dis[2] == dis[3] && dis[4] == dis[5];

    }

    public int distance(int[] p1,int[] p2){
        //同一个点 距离为-1
        if(p1[0] == p2[0] && p1[1] == p2[1]){
            return -1;
        }
        //两点之间的距离的平方 带根号也行 但是不带根号也可以
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
方法二：任选三个点 都是 一个直角三角形
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //任选三个点 都是 一个直角三角形
        return isRightTriangle(p1, p2, p3) && isRightTriangle(p1, p2, p4) && isRightTriangle(p1, p3, p4) && isRightTriangle(p2, p3, p4);
    }

    public boolean isRightTriangle(int[] p1, int[]p2, int[] p3){
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if(d1 > d2 && d2 == d3 && d2 + d3 == d1 ||
            d2 > d1 && d1 == d3 && d1 + d3 == d2 ||
            d3 > d1 && d1 == d2 && d1 + d2 == d3){
            return true;
        }
        return false;
    }
}
