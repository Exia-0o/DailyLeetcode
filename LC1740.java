class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q)
            return 0;
        TreeNode ret = helper(root, p, q);
        return bfs(ret, p, q);
    }
    
    private TreeNode helper(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
    
    private int bfs(TreeNode root, int p, int q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        int layer = 0;
        boolean pAdded = false, qAdded = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == p) {
                    ans += layer;
                    pAdded = true;
                }
                if (cur.val == q) {
                    ans += layer;
                    qAdded = true;
                }            
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            layer++;
            if (pAdded && qAdded)
                break;
        }
        return ans;
    }
}
