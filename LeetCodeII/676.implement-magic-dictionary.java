/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 */

// @lc code=start
class MagicDictionary {

    class TrieNode {
        boolean isWord;
        TrieNode[] children;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        if(this.root == null) {
            this.root = new TrieNode();
        }
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str: dict) {
            TrieNode tmp = root;
            for(Character c: str.toCharArray()) {
                if(tmp.children == null) {
                    tmp.children = new TrieNode[26];
                }
                if(tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode();
                }
                tmp = tmp.children[c - 'a'];
            }
            tmp.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode tmp = root;
        char[] input = word.toCharArray();
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<26; j++) {
                if(input[i]-'a' == j || tmp.children == null ||tmp.children[j] == null) continue;
                if(validate(word, i+1, tmp.children[j])) return true;   
            }
            if(tmp.children == null || tmp.children[input[i]-'a'] == null) return false;
            tmp=tmp.children[input[i]-'a'];
        }
        return false;
    }

    private boolean validate(String word, int index, TrieNode node) {
        if(index > word.length() -1) {
            return node.isWord;
        }
        if(node.children == null || node.children[word.charAt(index) - 'a'] == null) return false;
        return validate(word, index+1, node.children[word.charAt(index) - 'a']);
    }

    public static void main(String[] args) {
        MagicDictionary s = new MagicDictionary();
        String[] arr = {"hello", "hallo", "leetcode"};
        s.buildDict(arr);
        System.out.println(s.search("hallo"));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

