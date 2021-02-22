class Solution {
    private int minLen; private int result; Set<Integer> set = new HashSet<>();
    public String minAbbreviation(String target, String[] dictionary) {
        for (String word : dictionary)
            if (target.length() == word.length())
                set.add(getBitMask(word, target));
        minLen = target.length(); result = -1;
        dfs(target, 0, 0, 0);
        if (minLen > target.length()) return "";
        int count = 0; String ans = "";
        for (int i = target.length() - 1; i >= 0; i--) {
            if ((result & 1) == 0) count++;
            else {
                if (count > 0) {
                    ans = count + ans;
                    count = 0;
                }
                ans = target.charAt(i) + ans;
            }
            result >>= 1;
        }
        if (count > 0) ans = count + ans;
        return ans;
    }
    private void dfs(String target, int start, int curLen, int curResult) {
        if (curLen > minLen) return;
        if (start == target.length()) {
            for (int mask : set) if ((curResult & mask) == curResult) return;
            if (minLen > curLen) {
                minLen = curLen;
                result = curResult;
            }
            return;
        }
        for (int i = start; i < target.length(); i++)
            if (curLen == 0 || (curResult & 1) == 1)
                dfs(target, i + 1, curLen + 1, curResult << (i + 1 - start));
        dfs(target, start + 1, curLen + 1, (curResult << 1) + 1);
    }
    private int getBitMask(String word, String target) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask <<= 1;
            if (word.charAt(i) == target.charAt(i)) mask += 1;
        }
        return mask;
    }
}