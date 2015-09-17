package LeetCode;

public class exist {
	public static  boolean exist(char[][] board, String word) {
		for(int i=0; i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(dfs(board, word, i,j)){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean dfs(char[][] a, String word, int i, int j){
		if(word.equals("")) return true;
		if(i<0 || j<0 ||j>=a[0].length || i>=a.length ) return false;
		if(a[i][j]==word.charAt(0)){
			char tmp=a[i][j];
			a[i][j]='#';
			boolean res = (dfs(a, word.substring(1), i+1, j) || dfs(a, word.substring(1), i, j+1) || dfs(a, word.substring(1), i-1, j) || dfs(a, word.substring(1), i, j-1));
			if(res) return true;
			else a[i][j]=tmp;
		}
		return false;
	}
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] A={{'a','b'}, {'c','d'}};
		System.out.println(exist(A, "ac"));
	}

}
