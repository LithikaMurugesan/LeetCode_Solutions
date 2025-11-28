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
    public boolean isSymmetric(TreeNode root) {
        return BTree(root.left,root.right);
    }
    public boolean BTree(TreeNode left, TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null || right == null) return false;
        return(left.val == right.val) && 
        BTree(right.right,left.left )&&
        BTree(right.left , left.right);
    }
}