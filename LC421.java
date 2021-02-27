class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode() { children = new HashMap<>();}
    }
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);
        int maxLen = Integer.toBinaryString(max).length();
        int n = nums.length, bitMask = 1 << maxLen;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++)
            strNums[i] = Integer.toBinaryString(bitMask | nums[i]).substring(1);
        TrieNode root = new TrieNode();
        int maxXor = 0;
        for (String num : strNums) {
            TrieNode node = root;
            TrieNode xorNode = root;
            int curXor = 0;
            for (char bit : num.toCharArray()) {
                if (!node.children.containsKey(bit)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(bit, newNode);
                }
                node = node.children.get(bit);
                char toggledBit = bit == '1' ? '0' : '1';
                if (xorNode.children.containsKey(toggledBit)) {
                    curXor = (curXor << 1) | 1;
                    xorNode = xorNode.children.get(toggledBit);
                }
                else {
                    curXor = curXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }
}
