class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0;    
        for(int sweet : sweetness)
            sum += sweet;
        if (K == 0)
            return sum;
        int start = 0, end = sum;
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (canCut(sweetness, mid, K+1)) {
                ans = mid;
                start = mid +1;
            }
            else
                end = mid -1;
        }
        return ans;
    }
    
    private boolean canCut(int[] nums, int value, int k) {        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= value) {
                sum = 0;
                k--;
            }
            if (k == 0) return true;
        }
        return k <= 0;
    }
}
