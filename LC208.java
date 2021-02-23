class TrieNode {
    boolean isWord = false;
    Map<Character, TrieNode> children = new HashMap<>();
}
class Trie {
    private TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode cur = root;
        // Insert all characters into trie
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        // After insertion, set the end node to true
        cur.isWord = true;
    }
    public boolean search(String word) {
        TrieNode result = searchPrefix(word);
        return (result != null) && (result.isWord);
    }
    public boolean startsWith(String prefix) {
        TrieNode result = searchPrefix(prefix);
        return result != null;
    }
    // If there exists a word, return the end node; otherwise null
    private TrieNode searchPrefix(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else
                return null;
        }
        return cur;
    }
}