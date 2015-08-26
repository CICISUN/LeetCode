package LeetCode;

import java.util.ArrayList;

public class countIslands {



	public ArrayList<Integer> countIslands(int[][] mat){
		//stop when 0/boundary found
		int one,count;
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[][] mark = new int[mat.length][mat[0].length];

		if(mat == null || mat.length == 0) return res;

		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){

				if(mark[i][j]!=1 && mat[i][j]==1){
					res.add(dfs(i,j, mat, mark));
				}
			}
		}
		return res;
	}

	public int dfs(int i, int j, int[][] mat, int[][] mark){
		if(i<0 || j<0 || i>mat.length-1 || j>mat[0].length-1 || mat[i][j]==0 || mark[i][j]==1)
			return 0;
		mark[i][j] = 1;
		return 1+dfs(i-1,j,mat,mark)+dfs(i+1,j,mat,mark)+dfs(i,j-1,mat,mark)+dfs(i,j+1,mat,mark);
	}

	public static void main(String[] args) {
		int[][] test = {{0, 1, 0, 0, 1} ,{1, 1, 1, 0, 0}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 1}};
		countIslands c = new countIslands();
		System.out.println(c.countIslands(test));
	}

}