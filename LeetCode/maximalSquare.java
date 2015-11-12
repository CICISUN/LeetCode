package LeetCode;

public class maximalSquare {
	
	public static int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length == 0) return 0;
        int maxside=0;
        int[][] dp = new int[matrix.length][matrix[0].length]; //max square length with i,j as right-bottom corner
        //init
        for(int i=0; i<matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - '0';
            maxside = Math.max(maxside, dp[0][i]);
        }
        for(int i=0; i<matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            maxside = Math.max(maxside, dp[i][0]);
        }
        //fill
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length;j++){
                if((matrix[i][j] - '0') == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    maxside = Math.max(maxside, dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return maxside * maxside;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
