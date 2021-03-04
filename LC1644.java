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
    private TreeNode[] found = new TreeNode[2];
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = helper(root, p, q);
        if (found[0] != null && found[1] != null)
            return ret;
        return null;
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) 
            return root;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        
        if(root == p || root == q) {
            if (found[0] == null) 
                found[0] = root;
            else found[1] = root;
            return root;
        }
        
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
