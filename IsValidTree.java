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
        return checkTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean checkTree(TreeNode root, int higher, int lower){
        if(root == null) return true;
        boolean status = true;
        if(root.val > lower && root.val < higher) {
            status = status && checkTree(root.left, root.val, lower);
        } else {
            return false;
        }
        if(root.val > lower && root.val < higher) {
            status = status && checkTree(root.right,higher, root.val);
        } else {
            return false;
        }
        return status;
    }
}