class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long mod = 1000000007;
        long up = 0, down = 0;
        int i = 0, j = 0;
        int m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                up += nums1[i++];
            else if (nums2[j] < nums1[i])
                down += nums2[j++];
            else {
                long max =  Math.max(up, down) + nums1[i];
                up = max;
                down = max;
                i++;
                j++;
            }
        }
        while (i < m)
            up += nums1[i++];
        while (j < n)
            down += nums2[j++];
        long ret = (Math.max(up, down) % mod);
        return (int) ret;
    }
}
