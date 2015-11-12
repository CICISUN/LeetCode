package Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MountainArea {

	//Google

	HashSet<ArrayList<Integer>> pacific = new HashSet<ArrayList<Integer>>();
	HashSet<ArrayList<Integer>> atlantic = new HashSet<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> find(int[][] A){
		int n=A.length;
		int[][] visited = new int[n][n];
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dfs(A, i, j, visited);
			}
		}
		System.out.println(pacific);
		System.out.println(atlantic);
		return res;
	}

	//0-unvisited
	//1-visited-gray
	//2-pacific
	//3-atlantic
	public int dfs(int[][] A, int i, int j, int[][] visited){
		if((i<=0 || j<=0) && (i>=A.length-1 || j>=A.length-1)){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i); tmp.add(j);
			atlantic.add(tmp);
			pacific.add(tmp);
			return 2;
		}
		if(i<=0 || j<=0){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i); tmp.add(j);
			atlantic.add(tmp);
			return 2;
		} 
		if(i>=A.length-1 || j>=A.length-1) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i); tmp.add(j);
			pacific.add(tmp);
			return 3;
		}
		visited[i][j]=1;
		if(i<A.length-1 && A[i][j]>A[i+1][j]){
			if(dfs(A, i+1, j, visited)==2){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				atlantic.add(tmp);}
			if(dfs(A, i+1, j, visited)==3){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				pacific.add(tmp);}
		}
		if(i>0 && A[i][j]>A[i-1][j]){
			if(dfs(A, i-1, j, visited)==2){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				atlantic.add(tmp);}
			if(dfs(A, i-1, j, visited)==3){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				pacific.add(tmp);}
		}
		if(j<A.length-1 && A[i][j]>A[i][j+1]){
			if(dfs(A, i, j+1, visited)==2){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				atlantic.add(tmp);}
			if(dfs(A, i, j+1, visited)==3){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				pacific.add(tmp);}
		}
		if(j>0 && A[i][j]>A[i][j-1]){
			if(dfs(A, i, j-1, visited)==2){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				atlantic.add(tmp);}
			if(dfs(A, i, j-1, visited)==3){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i); tmp.add(j);
				pacific.add(tmp);}
		}
		return 0;
	}



	public void find2(int[][] A){
		HashSet<int[]> p = bfs(A, 0, 0);
		HashSet<int[]> a = bfs(A, A.length-1, A.length-1);
		System.out.println("a");
		for(int[] tmp : a){
			System.out.println(tmp[0]+","+tmp[1]);
		}
		System.out.println("p");
		for(int[] tmp : p){
			System.out.println(tmp[0]+","+tmp[1]);
		}
	}

	public HashSet<int[]> bfs(int[][] A, int startx, int starty){
		HashSet<int[]> p = new HashSet<int[]>();
		int[] cur = new int[2];
		boolean[][] visited = new boolean[A.length][A.length];
		cur[0]=startx; cur[1]=starty;
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.offer(cur);
		while(!q.isEmpty()){
			int[] current= q.poll();
			int x=current[0]; int y=current[1];
			if(visited[x][y]) continue;
			visited[x][y]=true;
			p.add(current);
			if( (x+1) < A.length && A[x][y] <= A[x+1][y] && !visited[x+1][y]){
				int[] down=new int[2];
				down[0]=x+1; down[1]=y;
				q.offer(down);
			}
			if( (y+1) < A.length && A[x][y] <= A[x][y+1] && !visited[x][y+1]){
				int[] right=new int[2];
				right[0]=x; right[1]=y+1;
				q.offer(right);
			}	
			if( y > 0 && A[x][y] <= A[x][y-1] && !visited[x][y-1]){
				int[] left=new int[2];
				left[0]=x; left[1]=y-1;
				q.offer(left);
			}
			if( x > 0 && A[x][y] <= A[x-1][y] && !visited[x-1][y]){
				int[] up=new int[2];
				up[0]=x-1; up[1]=y;
				q.offer(up);
			}
		}
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A={{1,1,1},{1,2,1},{1,1,1}};
		MountainArea m = new MountainArea();
		m.find(A);
		m.find2(A);
	}

}
