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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i=0;i < size;i++){
                TreeNode demo = q.poll();
                sum += demo.val;
                if(demo.left != null){
                    q.add(demo.left);
                }
                if(demo.right != null){
                    q.add(demo.right);
                }
            }
            double average = sum / size;
            result.add(average);
        }
        return result;
    }
}