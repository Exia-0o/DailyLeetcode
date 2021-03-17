class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1])
                    return 0;
                if (a[1] < b[1])
                    return -1;
                return 1;
            }
        });
        int arrows = 1;
        int prevEnd = points[0][1];
        for (int[] point : points) {
            if (prevEnd < point[0]) {
                arrows++;
                prevEnd = point[1];
            }
        }
        return arrows;
    }
}

