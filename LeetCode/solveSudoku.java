package LeetCode;

import java.util.HashSet;

public class solveSudoku {
	
    public void solveSudoku(char[][] board){
    	solver(board);
    }
    
    public boolean solver(char[][] board){
    	
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
            	if(board[i][j]=='.'){
            		for(char k='1'; k<='9'; k++){
            			if(isValidSudoku(board, i, j, k)){
                			board[i][j]=k;
            				if(solver(board))
            					{
            					return true;
            					}
            				else{
                				board[i][j]='.';
                			}
            			}
            		}
            		return false;
            	}
            }
        }
		return true;
    }
    
    public boolean isValidSudoku(char[][] board, int row, int col, char tmp) {
        //row
        for(int i=0; i<board[0].length;i++){
            if(board[row][i]==tmp) return false;
        }
        //col
        for(int i=0; i<board.length;i++){
        	if(board[i][col]==tmp) return false;
        }
        //tuple
        for(int m=row/3*3;m<3+row/3*3;m++){
            for(int n=col/3*3;n<3+col/3*3;n++){
                if(board[m][n]==tmp) return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
