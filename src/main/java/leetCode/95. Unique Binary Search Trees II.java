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
    public List<TreeNode> generateTrees(int n) {
        // if 뒤에 더 표시할 것이 있으묜 null 이어라
        // if leaf? dont add null
        return generate(1,n);

    }

    private List<TreeNode> generate(int start,int end){
        List<TreeNode> allTrees = new ArrayList<>();

        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start ; i <= end ; i++){
/**
1 3 1 
  1 0 add null return 
  2 3 2
    2 1
    3 3 3
 */
            List<TreeNode> leftSubTrees = generate(start,i-1);

            List<TreeNode> rightSubTrees = generate(i+1,end);

            for(TreeNode left : leftSubTrees){
                for(TreeNode right : rightSubTrees){

                    TreeNode root = new TreeNode(i,left,right);

                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }
}
