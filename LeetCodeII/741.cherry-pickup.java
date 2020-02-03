import java.util.Arrays;

/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start

//https://leetcode.com/problems/cherry-pickup/discuss/329945/Very-easy-to-follow-%3A-step-by-step-recursive-backtracking-with-memoization-N4

/**
 *  11100
    00101
    10100
    00100
    00111

    backtracking + DP
    Let dp[r1][c1][c2] be the most number of cherries obtained by two people starting at (r1, c1) and (r2, c2) and walking towards (N-1, N-1) picking up cherries, where r2 = r1+c1-c2.
    Space O(n^3) Time )(n^3)
*/
class cherryPickup {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid.length][grid.length];
        return Math.max(0, dfs(grid, 0, 0, 0, 0, dp));
    }

    private int dfs(int[][] grid, int col1, int row1, int col2, int row2, int[][][] dp) {
        if(col1 > grid.length-1 || col2 > grid.length-1 || 
            row1 > grid[0].length-1 || row2 > grid[0].length-1 ||
            grid[col1][row1] == -1 || grid[col2][row2] == -1 ) {
                return Integer.MIN_VALUE;
        }
        if(col1 == grid.length-1 && row1 == grid[0].length -1) {
            return grid[col1][row1];
        }
        if(dp[col1][row1][col2] != 0) {
            return dp[col1][row1][col2];
        }
        int count=grid[col1][row1];
        if(col2 != col1 && row2 != row1) {
            count+=grid[col2][row2];
        }
        count+= Math.max(
            Math.max(
                dfs(grid, col1+1, row1, col2+1, row2, dp), 
                dfs(grid, col1, row1+1, col2, row2+1, dp)),  
            Math.max(
                dfs(grid, col1+1, row1, col2, row2+1, dp), 
                dfs(grid, col1, row1+1, col2+1, row2, dp)));
        dp[col1][row1][col2] = count;
        return count;
    }

    // At time n, let dp[i][p] be the most cherries that we can pick up for two people going from 
    // (0, 0) to (i, j) and (0, 0) to (p, q), where j = n-i, q = n-p. 
    // T(n, i, p) = grid[i][n-i] + grid[p][n-p] + max{T(n-1, i-1, p-1), T(n-1, i-1, p), T(n-1, i, p-1), T(n-1, i, p)}.
    // Space O(n^2) Time )(n^3)
    public int cherryPickup2(int[][] grid) {
        int N = grid.length, M = (N << 1) - 1;
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
            
        for (int n = 1; n < M; n++) {
            for (int i = N - 1; i >= 0; i--) {
                for (int p = N - 1; p >= 0; p--) {
                    int j = n - i, q = n - p;
                    
                    if (j < 0 || j >= N || q < 0 || q >= N || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1;
                        continue;
                     }
             
                     if (i > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                     if (p > 0) dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                     if (i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
             
                     if (dp[i][p] >= 0) dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                 }
             }
        }
        
        return Math.max(dp[N - 1][N - 1], 0);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,-1},
            {1,0,-1},
            {1,1,1}
        };
        cherryPickup s = new cherryPickup();
        System.out.println(s.cherryPickup2(grid));
    }
}
// @lc code=end

