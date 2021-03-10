// Approach 1:
/*
class MyCalendarThree {
    class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private List<Pair> list;
    public MyCalendarThree() {
        list = new ArrayList<>();
    }
    
    public int book(int start, int end) {
        list.add(new Pair(start, end));
        Collections.sort(list, (a, b) -> a.start - b.start);
        Queue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> a.end - b.end);
        int n = minHeap.size();
        for (Pair p : list) {
            // No overlaps
            if (!minHeap.isEmpty() && minHeap.peek().end <= p.start) {
                minHeap.poll();
                minHeap.offer(p);
            }
            // Overlapps
            else {
                minHeap.offer(p);
            }
        }
        return minHeap.size();
    }
}
*/

// Approach 2:
class MyCalendarThree {
    private TreeMap<Integer, Integer> minHeap;
    public MyCalendarThree() {
        minHeap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        minHeap.put(start, minHeap.getOrDefault(start, 0) + 1);
        minHeap.put(end, minHeap.getOrDefault(end, 0) - 1);
        int ans = 0;
        int overlaps = 0;
        for (int v : minHeap.values()) {
            overlaps += v;
            ans = Math.max(overlaps, ans);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
