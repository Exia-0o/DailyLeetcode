/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = null;
        if (p.parent == null)
            return p;
        if (q.parent == null)
            return q;
        Node cur = p;
        root = findRoot(cur);
        System.out.println(root.val);
        return helper(root, p, q);
    }
    Node findRoot(Node node) {
        while (node.parent != null)
            node = node.parent;
        return node;
    }
    Node helper(Node root, Node p, Node q) {
        if (root == p || root == q || root == null)
            return root;
        Node left = helper(root.left, p, q);
        Node right = helper(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
