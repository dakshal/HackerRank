/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> list = new Stack<>();
    int pos=0;
    TreeNode root;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode next = root;
        while(next!=null){
            list.push(next);
            next = next.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(list.size()>0){
            return true;
        } else {
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = list.pop();
        if(ret.right!=null){
            TreeNode next = ret.right;
            while(next!=null){
                list.push(next);
                next = next.left;
            }
        }
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */