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

 import java.util.List;
 import java.util.ArrayList;
 import java.util.ArrayDeque;

class Solution {

    private static List<List<Integer>> result;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<>();
        bfs(root);
        return result;

    }

    private static void bfs(TreeNode node){
        if(node == null) return;
        
        List<Integer> level = new ArrayList<>();
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.add(node);

        while(!dq.isEmpty()){
            int size = dq.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode now = dq.poll();
                level.add(now.val);
                if(now.left != null) dq.add(now.left);
                if(now.right != null) dq.add(now.right);
            }
            result.add(0,new ArrayList<>(level));
            level.clear();           
        }
    }
}
