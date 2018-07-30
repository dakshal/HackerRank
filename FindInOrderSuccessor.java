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
    TreeNode node;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(findSuccessor(root, p, false))
            return node;
        else 
            return null;
    }
    public boolean findSuccessor(TreeNode root, TreeNode p, boolean found) {
        if(root == null){
            return found;
        }
        boolean status = false;
        status = findSuccessor(root.left, p, found);
        if(node==null){
            if(status){
                node = root;
                return true;
            }
            if(root.val == p.val){
                found = true;
                status = true;
            }
            status = findSuccessor(root.right, p, found);
        } else {
            return true;
        }
        return status;
    }
}