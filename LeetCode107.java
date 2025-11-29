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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
        if(root == null) return  result;;
        Queue <TreeNode> order = new LinkedList<>();
        order.add(root);

        while(!order.isEmpty()){
            int size = order.size();
             List<Integer> level = new ArrayList<>();
             for(int i =0;i<size;i++){
                TreeNode node = order.poll();
            level.add(node.val);
            if(node.left != null)order.add(node.left);
            if(node.right != null) order.add(node.right);
             }
              result.add(0, level);
        }
   return result;
    }
 
}