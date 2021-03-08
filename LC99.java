/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int n = list.size();
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 1; i < n; i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                y = list.get(i);
                if (x == null)
                    x = list.get(i - 1);
                else
                    break;
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    
    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        preorder(root.left, list);
        list.add(root);
        preorder(root.right, list);
    }
}
