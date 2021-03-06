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
    private Set<TreeNode> set;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<TreeNode>(Arrays.asList(nodes));
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null || set.contains(root))
            return root;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
