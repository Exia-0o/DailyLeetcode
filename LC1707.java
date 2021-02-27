class Solution {
    class TrieNode {
        TrieNode[] children;
        TrieNode() { children = new TrieNode[2];}
    }
    TrieNode root;
    public int[] maximizeXor(int[] nums, int[][] q) {
        int n = nums.length;
        int[] ans = new int[q.length];
        root = new TrieNode();
        int[][] queries = new int[q.length][3];
        for (int i = 0; i < q.length; i++) {
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(queries, (a, b) -> a[1] - b[1]);
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            while (index < n && nums[index] <= queries[i][1]) {
                insert(nums[index]);
                index++;
            }
            if (nums[0] > queries[i][1])
                ans[queries[i][2]] = -1;
            else
                ans[queries[i][2]] = maxAns(queries[i][0]);
        }
        return ans;
    }
    private void insert(int num) {
        TrieNode cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (cur.children[bit] == null)
                cur.children[bit] = new TrieNode();
            cur = cur.children[bit];
        }
    }
    private int maxAns(int num) {
        TrieNode cur = root;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (cur == null || cur.children == null)
                break;
            if (cur.children[bit ^ 1] != null) {
                sum += (1 << i);
                cur = cur.children[bit ^ 1];
            }
            else
                cur = cur.children[bit];
        }
        return sum;
    }
}