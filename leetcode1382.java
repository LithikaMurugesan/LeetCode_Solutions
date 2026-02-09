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
    List <Integer> nums = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
          balancedTree(root); 
           return Build(0, nums.size() - 1); 
    }
    private void balancedTree(TreeNode root){
        if(root==null)
        return;
        balancedTree(root.left);
        nums.add(root.val);
        balancedTree(root.right);
    }
    private TreeNode Build(int left,int right){
        if(left>right)
        return null;
          int mid = left + (right - left) / 2;
          TreeNode root = new TreeNode(nums.get(mid));
            root.left = Build(left, mid - 1);
        root.right = Build(mid + 1, right);
        return root;
    }
}