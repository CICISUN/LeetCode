package LeetCode;

import java.util.ArrayList;

public class numSquares {
	
    public int numSquares(int n) {
        int uppernum = (int)Math.sqrt(n) + 1;
        int[] minlen= {Integer.MAX_VALUE};
        dfs(n, uppernum, 1, new ArrayList<Integer>(),minlen,0);
        return minlen[0];
    }
    
    public void dfs(int n, int uppernum, int start, ArrayList<Integer> list, int[] minlen, int cursum){
        if(list.size()>=minlen[0] || cursum>n){
            return;
        }
        if(cursum==n){
            minlen[0]=Math.min(minlen[0], list.size());
            return;
        }
        for(int i=start; i<=uppernum; i++){
            list.add(i);
            dfs(n, uppernum, i, list, minlen, cursum+i*i);
            list.remove(list.size()-1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numSquares n = new numSquares();
		System.out.println(n.numSquares(10));
	}

}
