package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class totalNQueens {
	
    public static int totalNQueens(int n) {
        int[] count={0};
    	solve(n, 0, new int[n], count);
    	return count[0];
    }
    private static void solve(int n, int row, int[] ColforRow, int[] count){
    	if(row==n){
    		count[0]+=1;
    		return;
    	}
    	for(int i=0;i<n;i++){
    		ColforRow[row] = i;
    		if(isValid(row, ColforRow)){
    			solve(n, row+1, ColforRow, count);
    		}
    	}
    }
    
    private static boolean isValid(int row, int[] ColforRow){
    	for(int i=0;i<row;i++){
    		if(ColforRow[row]==ColforRow[i] || Math.abs(ColforRow[row]-ColforRow[i])==row-i) // if same column, or same diagonal
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(8));
	}

}
