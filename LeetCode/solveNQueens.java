package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
	
    public static List<List<String>> solveNQueens(int n) {
    	List<List<String>> res=new ArrayList<List<String>>();
    	solve(res, n, 0, new int[n]);
    	return res;
    } 
    
    private static void solve(List<List<String>> res, int n, int row, int[] ColforRow){
    	if(row==n){
    		ArrayList<String> rowitem=new ArrayList<String>();
    		for(int i=0;i<n;i++){	
    			StringBuilder rowstring = new StringBuilder();
    			for(int j=0;j<n;j++){	
    				if(ColforRow[i]==j){
    					rowstring.append('Q');
    				}
    				else{
    					rowstring.append('.');
    				}
    			}
    			rowitem.add(rowstring.toString());
    		}
    		res.add(rowitem);
    		return;
    	}
    	for(int i=0;i<n;i++){
    		ColforRow[row] = i;
    		if(isValid(row, ColforRow)){
    			solve(res, n, row+1, ColforRow);
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
		System.out.println(solveNQueens(4));
	}

}
