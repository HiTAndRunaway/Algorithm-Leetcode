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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int currmax = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i < size;i++){
                TreeNode demo = q.poll();
                if(currmax < demo.val){
                    currmax = demo.val;
                }
                if(demo.left != null) q.add(demo.left);
                if(demo.right != null) q.add(demo.right);
            }
            res.add(currmax);
            currmax = Integer.MIN_VALUE;
        }
        return res;
        
    }
}

方法二：DFS
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
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root,int depth){
        if(root == null){
            return;
        }
        if(depth == res.size()){
            res.add(root.val);
        }else{
            if(res.get(depth) < root.val){
                res.set(depth,root.val);
            }
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
}