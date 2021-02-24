class TrieNode {
    boolean hasWord = false;
    Map<Character, TrieNode> children = new HashMap<>();
}
class Trie {
    public TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
    }
    public boolean search(String word) {
        return searchPrefix(word, root);
    }
    public boolean searchPrefix(String word, TrieNode cur) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                // If c ='.', then just go through all entries
                if (c == '.') {
                    for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                        // search the remaining chars starting from i + 1
                        if (searchPrefix(word.substring(i + 1), entry.getValue()))
                            return true;
                    }
                }
                return false;
            }
            else
                cur = cur.children.get(c);
        }
        return cur.hasWord;
    }
}
class WordDictionary {
    Trie trie = new Trie();
    
    public void addWord(String word) {
        trie.insert(word);
    }
    public boolean search(String word) {
        return trie.search(word);
    }
}