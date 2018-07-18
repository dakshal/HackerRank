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
    int max = 0;
    public int findPath(TreeNode root, int parent) {
        if(root == null){
            return 0;
        }

        int left = findPath(root.left, root.val);
        int right = findPath(root.right, root.val);
        
        max = Math.max(max, left+right);
        if(root.val == parent) return Math.max(left, right) + 1;
        return 0;
        
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        findPath(root, root.val);
        return max;
    }
}