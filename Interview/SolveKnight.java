package Interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SolveKnight {
	
	//Goldman Phone

	public int[][] Dir ={{2,-1},{2,1},{-2,1},{-2,-1},{1,-2},{1,2},{-1,2},{-1,-2}};
	
	public double SolveKnight(int n, int[] input){
		int[][] board = new int[8][8];
		int count=0, step=0;
		if(n==0) return 1;
		Queue<int[]> curlevel = new ArrayDeque<int[]>();
		Queue<int[]> nextlevel = new ArrayDeque<int[]>();
		curlevel.offer(input);
		while(!curlevel.isEmpty()){
			int[] cur = curlevel.poll();
			for(int d=0; d<Dir.length; d++){
				int[] next = isValid(Dir[d], cur);
				if(next!=null){
					nextlevel.offer(next);
				}
			}
			if(curlevel.isEmpty()){
				step++;
				if(step>=n) break;
				else{
					curlevel=nextlevel;	
					nextlevel=new ArrayDeque<int[]>();
				}
			}
		}
		return nextlevel.size()/(Math.pow(8, n));
	}
	
	public int[] isValid(int[] steps, int[] cur){
		int[] res= new int[2];
		int x = cur[0] + steps[0];
		int y = cur[1] + steps[1];
		if(x<0 || x>=8 || y<0 || y>=8){return null;}
		else{
			res[0]=x;
			res[1]=y;
		}
		return res;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolveKnight s= new SolveKnight();
		int[] A={0,0};
		System.out.println(s.SolveKnight(3, A));
	}

}
