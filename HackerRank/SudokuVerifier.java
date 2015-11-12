package HackerRank;

import java.io.*;
import java.util.*;

public class SudokuVerifier {


	    public int[][] parse(){
	        Scanner s = new Scanner(System.in);
	        String rawinput = s.nextLine();
	        int n = (int) Math.sqrt(rawinput.length()); //length of soduku board
	        int[][] sudoku = new int[n][n];
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                sudoku[i][j] = rawinput.charAt(i*n+j) - '0';
	            }
	        }
	        return sudoku;
	    }
	    
	    public int verifySudoku(int[][] sudoku){
	        //row
	        for(int i=0; i<sudoku.length; i++){
	            HashSet<Integer> row = new HashSet<Integer>();
	            for(int j=0; j<sudoku[0].length; j++){
	                if(!row.add(sudoku[i][j])) return 0;
	            }
	        }
	        //col
	        for(int i=0; i<sudoku[0].length; i++){
	            HashSet<Integer> col = new HashSet<Integer>();
	            for(int j=0; j<sudoku.length; j++){
	                if(!col.add(sudoku[j][i])) return 0;
	            }
	        }        
	        //tuple
	        for(int i=0; i<sudoku[0].length/3; i++){
	            for(int j=0; j<sudoku.length/3; j++){
	                HashSet<Integer> tup = new HashSet<Integer>();
	                for(int p=i*3; p<i*3+3; p++){
	                    for(int q=j*3; q<j*3+3; q++){
	                        if(!tup.add(sudoku[p][q])) return 0;
	                    }
	                }
	            }
	        }
	        return 1;
	    }
	    
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    	SudokuVerifier sol = new SudokuVerifier();
	        System.out.println(sol.verifySudoku(sol.parse()));
	        
	    }
	
}
