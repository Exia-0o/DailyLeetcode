class Solution {
    private int pos = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        
        pos = inorder.length-1;
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return getTreeFromArray(map, inorder, postorder, 0, inorder.length-1);
    }
    
    public TreeNode getTreeFromArray(Map<Integer, Integer>map, int[]inorder, int[]postorder, int start, int end){
        if(start > end) return null;
        
        int val = postorder[pos--];
        TreeNode node = new TreeNode(val);
        
        node.right = getTreeFromArray(map, inorder, postorder, map.get(val)+1, end);
        node.left = getTreeFromArray(map, inorder, postorder, start, map.get(val)-1);
        
        return node;
    }
}
