class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {       
        List<int[]> result = new ArrayList<>();        
        int i = 0;
        int start = newInterval[0], end = newInterval[1];
        // Step 1 - add all intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }
        // Step 2 - update the newInterval by merging with all overlapping intervals
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[] {start, end}); // add updated interval
        // Step 3 - add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][2]);
    }
}
