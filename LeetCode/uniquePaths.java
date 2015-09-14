package LeetCode;

public class uniquePaths {

	public static int uniquePaths(int m, int n) {
		int[][] dp=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 || j==0){
					dp[i][j]=1;
				}
				else{
					dp[i][j]=dp[i-1][j] +dp[i][j-1]; 
				}
			}
		}
		return dp[m-1][n-1];
	}

	public static int uniquePathsWithObstacles(int[][] a)
	{
		int m=a.length; int n=a[0].length;
		int[][] dp=new int[m][n];
		int i=0;
		while(i<m){
			if(a[i][0]==1) break;
			else {dp[i][0]=1;i++;}
		}
		int j=0;
		while(j<n){
			if(a[0][j]==1) break;
			else {dp[0][j]=1;j++;}
		}

		for(i=1;i<m;i++){
			for(j=1;j<n;j++){
			        if(a[i][j]==1) dp[i][j]=0;
					else dp[i][j]= (a[i-1][j]==1 ? 0 : dp[i-1][j]) + (a[i][j-1]==1 ? 0 : dp[i][j-1]); 
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0,0},{0,0}};
		System.out.println(uniquePathsWithObstacles(a));
	}

}
