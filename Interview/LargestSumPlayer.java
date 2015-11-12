package Interview;

public class LargestSumPlayer {

	//Snapchat

	public static int largest(int[] A){
		int len=A.length;
		int[][] dp1=new int[len][len];
		int[][] dp2=new int[len][len];
		for(int i=0;i<len;i++){
			dp1[i][i]=A[i];
			dp2[i][i]=0;
		}
		for(int i=1;i<len;i++){//step length
			for(int j=0;j<len-i;j++){
				if(A[j]+dp2[j+1][j+i]>A[i+j]+dp2[j][j+i-1]){
					dp1[j][j+i]=A[j]+dp2[j+1][j+i];
					dp2[j][j+1]=dp1[j+1][j+i];
				}
				else{
					dp1[j][j+i]=A[i+j]+dp2[j][j+i-1];
					dp2[j][j+i]=dp1[j][j+i-1];
				}
			}
		}

		return dp1[0][len-1];
	}

	public static int largesttwo(int[] A){
		int len=A.length;
		int[][] dp=new int[len][len];
		for(int i=len-1;i>=0;i--){//[...j...i..]
			for(int j=i;j<len;j++){
				if(i==j){
					dp[i][j]= A[i];
					continue;
				}
				int a = A[i], b = A[j];
				if(i<len-2){
					a = a + Math.min(dp[i+1][j-1], A[i]+dp[i+2][j]);
				}
				if(j>1){
					b = b + Math.min(dp[i+1][j-1], A[j]+dp[i][j-2]);
				}
				dp[i][j]=Math.max(a, b);
			}
		}
		return dp[0][len-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={10, 1000, 80, 6};
		System.out.println(largest(test));
		System.out.println(largesttwo(test));
	}

}
