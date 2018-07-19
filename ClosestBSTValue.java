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
    public int closestValue(TreeNode root, double target) {
        return difference(root, target);
    }
    
    public int difference(TreeNode root, double target){
        
        if(root.val < target){
            if(root.right!= null){
                int least = difference(root.right, target);
                return (Math.abs(least-target) > Math.abs(root.val-target))?(root.val):(least);
            } else {
                return root.val;
            }
        } else if(root.val > target){
            if(root.left!= null){
                int least = difference(root.left, target);
                return (Math.abs(least-target) > Math.abs(root.val-target))?(root.val):(least);
            } else {
                return root.val;
            }
        } else {
            return root.val;
        }
    }
}