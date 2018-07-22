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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean status = true;
        if( root.left != null && root.val > root.left.val) {
            status = status && isValidBST(root.left);
        } else if(root.left!=null) {
            return false;
        }
        if( root.right != null && root.val < root.right.val) {
            status = status && isValidBST(root.right);
        }else if(root.right!=null) {
            return false;
        }
        return status;
    }
}