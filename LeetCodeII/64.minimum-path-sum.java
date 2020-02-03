import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class minPathSum {

    // dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
    // Space O(mn) Time O(mn)
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if(row==0 && col==0) continue;
                int up = row > 0 ? dp[row-1][col] : Integer.MAX_VALUE;
                int left = col > 0 ? dp[row][col-1] : Integer.MAX_VALUE;
                dp[row][col] = grid[row][col] + Math.min(up, left);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


    // Space O(n) Time O(mn)
    public int minPathSum2(int[][] grid) {
        int w = grid[0].length;
        int[] dist = new int[w];
        for (int i = 1; i < w; i++) dist[i] = Integer.MAX_VALUE;
        for (int[] r : grid) {
            dist[0] += r[0];
            for (int i = 1; i < w; i++) {
                dist[i] = r[i] + Math.min(dist[i], dist[i - 1]);
            }
        }
        return dist[w - 1];
    }

    public static void main(String[] args) {
        minPathSum s = new minPathSum();
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(s.minPathSum2(grid));

    }
}
// @lc code=end

