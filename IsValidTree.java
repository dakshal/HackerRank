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
        return checkTree(root, null, null);
    }
    
    public boolean checkTree(TreeNode root, Integer higher, Integer lower){
        if(root == null) return true;
        if((lower == null || root.val > lower) && (higher == null || root.val < higher)) {
            return checkTree(root.left, root.val, lower) && checkTree(root.right, higher, root.val);
        } else {
            return false;
        }
    }
}