class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        int count = 0;
        int prevEnd = 0;
        int n = intervals.length;
        for (int[] interval : intervals) {
            if (prevEnd < interval[1]) {
                count++;
                prevEnd = interval[1];
            }
        }
        return count;
    }
}
