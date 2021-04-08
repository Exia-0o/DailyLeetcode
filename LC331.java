class Solution {
    private int root = 0;
    private String[] nums;
    public boolean isValidSerialization(String preorder) {
        nums = preorder.split(",");
        return isPre() && root == nums.length;
    }
    
    private boolean isPre() {
        if (root >= nums.length) return false;
        if (nums[root++].equals("#")) return true;
        return isPre() && isPre();
    }
}
