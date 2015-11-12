package Interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class blobBoundary {

	/*
	 * Helper Functions:
	 * blobResult class: container for the result
	 * print_result function: print the blobResult
	 * parse function: parse input to a 2D matrix
	 */

	public class blobResult{
		int top;
		int bottom;
		int left;
		int right;
		int cellreads;
	}

	public void print_result(blobResult b){
		System.out.println("Cell Reads: " + b.cellreads);
		System.out.println("Top: " + b.top);
		System.out.println("Left: " + b.left);
		System.out.println("Bottom: " + b.bottom);
		System.out.println("Right: " + b.right);
	}

	public int[][] parse(String path) throws FileNotFoundException{
		int[][] input = new int[10][10];
		File file = new File(path);
		Scanner s = new Scanner(file);
		int linenum=0;
		while(s.hasNextLine()){
			String linein = s.nextLine();
			int[] line = new int[10];
			for (int i = 0; i < linein.length(); i++){
				line[i] = linein.charAt(i) - '0';
			}
			input[linenum] = line;
			linenum++;
		}
		return input;
	} 

	/*
	 * The brute force method finds the four indexes one at a time, while recording cell reads. 
	 * This is O(N^2) time, O(1) Space solution.
	 * Output:
	 * Cell Reads: 120
	 * Top: 1
	 * Left: 2
	 * Right: 6
	 * Bottom: 7
	 */

	public blobResult first_solve(int[][] input){
		blobResult res = new blobResult();
		int count = 0;
		//find top
		for(int i=0; i<10; i++){
			int rowsum=0;
			for(int j=0; j<10; j++){
				rowsum+=input[i][j];
				count++;
			}
			if(rowsum != 0){
				res.top=i;
				break;
			}
		}
		//find left
		for(int i=0; i<10; i++){
			int colsum=0;
			for(int j=0; j<10; j++){
				colsum+=input[j][i];
				count++;
			}
			if(colsum != 0){
				res.left=i;
				break;
			}
		}
		//find bottom
		for(int i=9; i>=0; i--){
			int rowsum=0;
			for(int j=0; j<10; j++){
				rowsum+=input[i][j];
				count++;
			}
			if(rowsum != 0){
				res.bottom=i;
				break;
			}
		}	
		//find right
		for(int i=9; i>=0; i--){
			int colsum=0;
			for(int j=0; j<10; j++){
				colsum+=input[j][i];
				count++;
			}
			if(colsum != 0){
				res.right=i;
				break;
			}
		}
		res.cellreads = count;
		return res;
	}

	/*
	 * The optimized method uses floodfill concept to update index during each recursive
	 * call, and stops moving forward if out of bounds or reached cells with a value 0. 
	 * This is still O(N^2) time, O(1) Space solution.
	 * Output:
	 * Cell Reads: 35
	 * Top: 1
	 * Left: 2
	 * Right: 6
	 * Bottom: 7
	 */

	public blobResult second_solve(int[][] input){
		blobResult res = new blobResult();
		//find the first 1
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				res.cellreads++;
				if(input[i][j]==1){
					res.top=i;
					res.left=j;
					dfs(input, i, j, res);
					return res;
				}
			}
		}
		return res;
	}

	//floodfill
	public void dfs(int[][] input, int x, int y, blobResult res){
		if(x<0 || x>9 || y<0 || y>9 || input[x][y]!=1) return;
		//mark visited
		input[x][y]=0;
		//update result
		res.cellreads++;
		if(x<res.top) res.top=x;
		if(x>res.bottom) res.bottom=x;
		if(y<res.left) res.left=y;
		if(y>res.right) res.right=y;
		//expand result
		dfs(input, x+1, y, res);
		dfs(input, x-1, y, res);
		dfs(input, x, y+1, res);
		dfs(input, x, y-1, res);
	}

	public static void main(String[] args) throws FileNotFoundException {
		blobBoundary b = new blobBoundary();
		b.print_result(b.first_solve(b.parse("test")));
		b.print_result(b.second_solve(b.parse("test")));
	}

}
