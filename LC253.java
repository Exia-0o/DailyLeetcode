class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
                minHeap.offer(interval);
            }
            else {
                minHeap.offer(interval);
            }
        }
        return minHeap.size();
    }
}
