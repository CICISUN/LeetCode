package LeetCode;

public class minCut {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isP = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i]=i;
            for(int j=i; j>=0; j--){
                if(s.charAt(i)==s.charAt(j) && ((i-j)<2 || isP[j+1][i-1])){//[i,j]is palindrom, s.i must equal s.j
                    isP[j][i]=true;
                    if(j==0){//if is palindrome from start of s
                        dp[i]=0;
                    }
                    else{//else take cut before j
                        dp[i]=Math.min(dp[j-1]+1, dp[i]);
                    }
                }
            }
        }
        return dp[n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("leetcode".substring(0, 3));
	}

}
