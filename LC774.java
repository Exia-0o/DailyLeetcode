class Solution {
    public double minmaxGasDist(int[] st, int K) {
        int n = st.length;
        double start = 0, end = st[n - 1] - st[0];
        while (start + 1e-6 <= end) {
            double mid = start + (end - start) / 2;
            int count = helper(st, mid, n);
            if (count > K)
                start = mid;
            else
                end = mid;
        }
        return end;
    }
    private int helper(int[] st, double mid, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; ++i)
            count += Math.ceil((st[i + 1] - st[i]) / mid) - 1;
        return count;
    }
}
