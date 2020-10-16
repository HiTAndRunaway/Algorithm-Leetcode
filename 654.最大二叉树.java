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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildupthetree(nums,0,nums.length - 1);
    }

    public TreeNode buildupthetree(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        //找到最大值的索引
        int midset = findmax(nums,left,right);
        TreeNode root = new TreeNode(nums[midset]);
        //递归地定下左子树和右子树
        root.left = buildupthetree(nums,left,midset - 1);
        root.right = buildupthetree(nums,midset + 1,right);
        
        return root;
    }

    public int findmax(int[] nums,int left,int right){
        int maxnum = Integer.MIN_VALUE;
        int maxindex = left;
        for(int i = left;i <= right;i++){
            if(nums[i] > maxnum){
                maxnum = nums[i];
                maxindex = i;
            }
        }
        return maxindex;

    }
}