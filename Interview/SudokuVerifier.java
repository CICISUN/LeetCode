package Interview;

public class SudokuVerifier {
	
	/**
     *  Determine if a Sudoku is valid.
     */
    public boolean isValidSudoku(char[][] board){ 
            if(board.length != 9 || board[0].length != 9) return false;
            for(int i = 0; i < 9; i++){
                    // we just use the 1-9 indices
                    boolean[] row = new boolean[10];
                    boolean[] col = new boolean[10];
                    boolean[] box = new boolean[10];
                    for(int j = 0; j < 9; j++){ 
                            if(!isValid(row, board[i][j]) || !isValid(col, board[j][i]) || !isValid(box, board[3 * (i/3) + (j/3)][3 *(i%3) + (j%3)])){
                                    return false;
                            }
                    }
            } 
            return true;
    }
    public boolean isValid(boolean[] num, char c){
            // it's not occupied, valid   
            if(c == '.') return true;
            // it's not valid
            if(c-'0' > 9) return false;
            // it's has been occupied
            if(num[c - '0']) return false;
            else{
                    // occupy it
                    num[c-'0'] = true; 
                    return true;
            }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


