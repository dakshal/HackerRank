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
        return checkTree(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean checkTree(TreeNode root, Long higher, Long lower){
        if(root == null) return true;
        boolean status = true;
        if(root.val > lower && root.val < higher) {
            status = status && checkTree(root.left, (long) root.val, lower);
        } else {
            return false;
        }
        if(root.val > lower && root.val < higher) {
            status = status && checkTree(root.right, higher, (long) root.val);
        } else {
            return false;
        }
        return status;
    }
}