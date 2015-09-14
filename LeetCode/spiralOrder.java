package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<Integer>();
		return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
	}

	public static ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(m<=0||n<=0) return res;//corner case
		if(m==1&&n==1) {//菜心儿
			res.add(matrix[x][y]);
			return res;
		}
		for(int i=0;i<n-1;i++){//start from (x,y), go right until n-1
			res.add(matrix[x][y++]);
		}
		for(int i=0;i<m-1;i++){//start from (x,y), go down until m-1
			res.add(matrix[x++][y]);
		}
		if(m>1){//if >=2 rows left 
			for(int i=0;i<n-1;i++){//start from (x,y), go left until n-1
				res.add(matrix[x][y--]);
			}
		}
		if(n>1){//if >=2 columns left
			for(int i=0;i<m-1;i++){//start from (x,y), go up until m-1
				res.add(matrix[x--][y]);
			}
		}
		if(m==1||n==1)//一条线儿
			res.addAll(spiralOrder(matrix,x,y,1,1));
		else    
			res.addAll(spiralOrder(matrix,x+1,y+1,m-2,n-2));
		return res;
	}

	public static int[][] generateMatrix(int n) {
		int[][] res=new int[n][n];
		if(n==0) return res;
		generateMatrix(n,0,0,1,res);
		return res;
	}

	public static void generateMatrix(int n, int x, int y, int num, int [][] res){
		if(n<=0) return;//corner case
		if(n==1) {//菜心儿
			res[x][y]=num++;
			return;
		}
		for(int i=0;i<n-1;i++){//start from (x,y), go right until n-1
			res[x][y++]=num++;
		}
		for(int i=0;i<n-1;i++){//start from (x,y), go down until n-1
			res[x++][y]=num++;
		}
		for(int i=0;i<n-1;i++){//start from (x,y), go left until n-1
			res[x][y--]=num++;
		}
		for(int i=0;i<n-1;i++){//start from (x,y), go up until n-1
			res[x--][y]=num++;
		}
		generateMatrix(n-2,x+1,y+1,num,res);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a ={{2,3}};
		System.out.println(generateMatrix(2));
	}

}
