package LeetCode;

import java.util.Stack;

public class maximalRectangle {
	public static int maximalRectangle(char[][] m) {
		if(m==null || m.length==0) return 0;
		int[] bar = new int[m[0].length+1];
		int maxarea=0;
		//increment histogram
		for(int i=0;i<m.length;i++){//for each row
			Stack<Integer> stk = new Stack<Integer>();
			for(int j=0;j<(m[0].length+1);j++){//cols
				if(j<m[0].length){
					if(m[i][j] - '0' == 1){
						bar[j]+=1;
					}
					else bar[j]=0;
				}
				//check if increasing
				if(stk.isEmpty() || bar[j]>=bar[stk.peek()]){
					stk.push(j);
				}
				else{
					while(!stk.isEmpty() && bar[j]<bar[stk.peek()]){
						int pre = stk.pop();
						int h = bar[pre];
						int w = stk.isEmpty() ? j : (j-1-stk.peek());
						maxarea = Math.max(maxarea, w * h);
					}
					stk.push(j);
				}
			}
		}
		return maxarea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] A = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
		System.out.println(maximalRectangle(A));


	}
}
