class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            }
            else {
                int max = Math.max(ans.getLast()[1], interval[1]);
                ans.getLast()[1] = max;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
