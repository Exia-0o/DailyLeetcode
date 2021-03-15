class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            // No overlapping
            if (prevEnd <= interval[0])
                prevEnd = interval[1];
            else
                count++;
        }
        return count;
    }
}
