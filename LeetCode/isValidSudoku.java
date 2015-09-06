package LeetCode;

import java.util.HashSet;

public class isValidSudoku {
	public boolean isValidSudoku(char[][] board) {
	    int len=board[0].length;
	    //column
	    for(int i=0; i<len;i++){
	        HashSet<Character> col=new HashSet<Character>();
	        for(int j=0 ;j<len;j++){
	        if(board[j][i]!='.' && !col.add(board[j][i])) return false;
	    }
	    }
	    //row
	    for(int i=0; i<len;i++){
	        HashSet<Character> row=new HashSet<Character>();
	        for(int j=0 ;j<len;j++){
	        if(board[i][j]!='.' && !row.add(board[i][j])) return false;
	    }
	    }
	    //tuple
	    for(int i=0;i<3;i++){
	        for(int j=0;j<3;j++){
	            HashSet<Character> tup=new HashSet<Character>();
	            for(int m=i*3;m<3+i*3;m++){
	                for(int n=j*3;n<3+j*3;n++){
	                    if(board[m][n]!='.' && !tup.add(board[m][n])) return false;
	                }
	            }
	        }
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
