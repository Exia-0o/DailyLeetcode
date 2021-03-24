class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end && nums[start] <= nums[start + 1])
            start++;
        if (start == end)
            return 0;
        while(start <= end && nums[end] >= nums[end - 1])
            end--;
        if (end == 0)
            return nums.length - 1;
        
        int ans = Math.min(end, nums.length - 1 - start);
        
        int i = 0;
        int j = end;
        
        while (i <= start && j < nums.length){
            if (nums[j] >= nums[i]){
                ans = Math.min(j - i - 1, ans);
                i++;
            }
            else
                j++;
        }
        return ans;
}
