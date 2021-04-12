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
    private int vidx = 0;
    private int dash = 0;

    // O(S.length())
    public TreeNode recoverFromPreorder(String S) {
        char[] str = S.toCharArray();
        return recoverFromPreorder(str, 0, str.length);
    }

    // O(S.length())
    public TreeNode recoverFromPreorder(char[] str, int depth, int length) {

        int num = 0;
        while (vidx < length && str[vidx] != '-') {
            num = num * 10 + str[vidx] - 48;
            vidx++;
        }

        while (vidx < length && str[vidx] == '-') {
            vidx++;
            dash++;
        }

        TreeNode root = new TreeNode(num);
        if (dash != depth + 1)
            return root;

        dash = 0;
        root.left = recoverFromPreorder(str, depth + 1, length);
        if (dash == depth + 1) {
            dash = 0;
            root.right = recoverFromPreorder(str, depth + 1, length);
        }
        return root;
    }
}
