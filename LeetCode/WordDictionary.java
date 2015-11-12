package LeetCode;

public class WordDictionary {

	private  class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWord;
    }
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public  void addWord(String word) {
        addWord(word.toCharArray(), 0, root);
    }
    
    public  void addWord(char[] s, int i, TrieNode root){
        if(root.child[s[i] - 'a']==null){
            root.child[s[i] - 'a'] = new TrieNode();
        }
        if((s.length-1) == i){
            root.isWord = true;
            return;
        }
        addWord(s, i+1, root.child[s[i] - 'a']);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWord(word.toCharArray(), 0, root);
    }
    
    public  boolean searchWord(char[] s, int i, TrieNode root){
        if(i >= (s.length-1)){
            return root.isWord;
        }
        char cur = s[i];
        if(cur == '.'){
            for(int p=0; p<root.child.length; p++){
                if(root.child[p] != null) 
                	if(searchWord(s, i+1, root.child[p]))
                		return true;
            }
            return false;
        }
        else if(root.child[cur-'a'] == null) return false;
        return searchWord(s, i+1, root.child[cur-'a']);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary word = new WordDictionary();
		
	}

}
