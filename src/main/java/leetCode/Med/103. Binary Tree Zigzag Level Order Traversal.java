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
import java.util.*;

class Solution {
    private static List<List<Integer>> result;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 레벨 0 : 왼 -> 오
        // 레벨 1 : 오 -> 왼
        // 레벌 2 : 왼 -> 오
        result = new ArrayList<>();
        bfs(root);
        return result;

    }

    private static void bfs(TreeNode node){
        if(node == null) return;

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        int level = 0;
        dq.add(node);
        
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> values = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                if(level % 2 == 0){
                    TreeNode now = dq.poll();
                    values.add(now.val);
                    if(now.left != null) dq.add(now.left);
                    if(now.right != null) dq.add(now.right);
                }else{
                    TreeNode now = dq.poll();
                    values.add(0,now.val);
                    if(now.left != null) dq.add(now.left);
                    if(now.right != null) dq.add(now.right);
                }
            }
            result.add(new ArrayList<>(values));
            level++;
        }
    }
}
