/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> demo = new ArrayList<>();
            for(int i=0;i < size;i++){
                Node tmp = q.poll();
                List<Node> child = tmp.children;
                demo.add(tmp.val);
                for(Node node : child){
                    q.add(node);
                }
            }
            res.add(demo);
        }
        return res;
    }
}