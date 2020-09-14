/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxcount = 0; 
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        order(root,map);
        for(int i : map.keySet()){
            if(map.get(i) == maxcount){
                list.add(i);
            }

        }
        int[] res = new int[list.size()];

        for(int i=0;i < res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public int order(TreeNode root,Map<Integer,Integer> map){
        if(root == null){
            return 0;
        }
        int val = root.val + order(root.left,map) + order(root.right,map); //计算总和
        map.put(val,map.getOrDefault(val,0) + 1);   //用map来记录和的出现次数
        maxcount = Math.max(maxcount,map.get(val)); //求出树的所有遍历序列中的总和的最大出现次数
        return val;
    }
}