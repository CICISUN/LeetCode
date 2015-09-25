package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class findWords {
	static exist w=new exist();
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res= new ArrayList<String>();
		for(String s : words){
			if(w.exist(board, s)){
				res.add(s);
			}
		}
		return res;
	}
	
	public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){

        }
    }

    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords2(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        flag = new boolean[board.length][board[0].length];

        addToTrie(words);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){//search for string begins with 
                    search(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<String>(result);
    }

    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]){
            return;
        }

        if(node.child[board[i][j] - 'a'] == null){
            return;
        }

        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord){
            result.add(word + board[i][j]);
        }

        search(board, i-1, j, node, word + board[i][j], result);
        search(board, i+1, j, node, word + board[i][j], result);
        search(board, i, j-1, node, word + board[i][j], result);
        search(board, i, j+1, node, word + board[i][j], result);

        flag[i][j] = false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] A={{'a','b'},{'c','d'}};
		String[] B={"ab", "ac"};
		findWords(A, B);
	}

}
