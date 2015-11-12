package LeetCode;

public class maxProfit {
	
    public int maxProfit(int k, int[] prices) {
        if(prices.length<2) return 0;
        if(k > prices.length/2) return quicksolve(prices);
        int[][] dp = new int[k+1][prices.length];
        int maxsofar=0;
        for(int t = 1; t<=k; t++){
            dp[t][0] = 0;
            for(int i=1; i<prices.length; i++){
                for(int j=0;j<i;j++){
                    dp[t][i]=Math.max(dp[t][i-1], (prices[i] - prices[j] + dp[t-1][j]));
                    maxsofar = Math.max(maxsofar, dp[t][i]);
                }
            }
        }
        return maxsofar;
    }
    public int quicksolve(int[] prices){
        int max=0;
        for(int i=0; i<prices.length-1; i++){
            if((prices[i+1] - prices[i]) > 0){
                max+=prices[i+1] - prices[i];
            }
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
