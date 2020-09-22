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
    private int res = 0;
    
    public int minCameraCover(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(dfs(root) == 2){
            res++;
        }
        return res;

    }

    public int dfs(TreeNode node){
        if(node == null){
            return 1;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 2 || right == 2){
            res++;
            return 0;
        }else if(left == 0 || right == 0){
            return 1;
        }else{
            return 2;
        }
    }
}