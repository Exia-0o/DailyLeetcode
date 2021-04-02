class Solution {
    public static int getSum(int[]nums, int mid) {
        int sum = 0;
        for (int num : nums)
            sum += (num - 1) / mid + 1;
        return sum;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 10000000;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (getSum(nums, mid) > threshold)
                start = mid + 1;
            else 
                end = mid - 1;
        }
        return start;
    }
}
