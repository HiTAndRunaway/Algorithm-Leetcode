/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        /**
        先序遍历二叉树, 先考虑子树的结构才能了解这颗树的结构, 用map保存二叉树先序遍历字符串出现的次数,
        未出现过则存入map, 重复出现就加1, 但只在次数等于1时加入返回序列中以避免重复. 
        **/
        List<TreeNode> ret = new ArrayList<>();
        if(root == null) return ret;
        postorder(root, new HashMap<>(), ret);
        return ret;
    }
    
    private String postorder(TreeNode r, Map<String, Integer> map, List<TreeNode> ret) {
        if(r == null) return "#";
        String serial = r.val + "," + postorder(r.left, map, ret) + "," + postorder(r.right, map, ret);
        map.put(serial, map.getOrDefault(serial, 0)+1);
        if(map.get(serial) == 2){
            ret.add(r);
        }
        return serial;
    }
        
}