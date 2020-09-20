//记录每个一行砖墙的边缘值和该边缘值出现的数量 绘制成一个map
//然后穿墙数 = 砖墙的总高度 - 该边缘值出现的次数
//取穿墙数中最小的值为res
class Solution {
    public int leastBricks(List<List<Integer>> walls) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum, size = walls.size(), min = size;
        for (List<Integer> wall : walls) {
            sum = 0;
            for (int i = 0; i < wall.size() - 1; i++) {
                sum += wall.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int m : map.values()) 
            min = Math.min(min, size - m);
        return min;
    }
}