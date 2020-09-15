方法一：BFS
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
    //BFS（广度优先搜索）
    public int findBottomLeftValue(TreeNode root) {
        //从右向左进行树的每一层的层序遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null){
                q.add(root.right);
            }
            if(root.left != null){
                q.add(root.left);
            }
        }

        return root.val;
    }
}

方法二：DFS
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
    //DFS(深度优先遍历，找到具有最大深度和最左边的点，找出每一层的最左结点，使用前序遍历)
    private int max = Integer.MIN_VALUE;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode node,int depth){
        if(node != null){
            if(node.left == null && node.right == null){
                if(max < depth){
                    max = depth;
                    res = node.val;
                }
            }
            dfs(node.left,depth + 1);
            dfs(node.right,depth + 1);
        }
    }
}