class Solution {
    public int[][] intervalIntersection(int[][] list1, int[][] list2) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.length && j < list2.length) {
            int start = Math.max(list1[i][0], list2[j][0]);
            int end = Math.min(list1[i][1], list2[j][1]);
            if (start <= end)
                ans.add(new int[] {start, end});
            if (list1[i][1] < list2[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
