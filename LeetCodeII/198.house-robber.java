/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class rob {

    // dp[i] = max(dp[i-1],dp[i-2] + nums[i])
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        } 
        return dp[nums.length-1];
    }

    // 2 variables dp
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int prevprev = 0;
        int prev = 0;
        for(int num: nums) {
            int tmp = prev;
            prev = Math.max(prevprev + num, prev);
            prevprev = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        rob s = new rob();
        int[] nums = {2,7,9,3,1};
        System.out.println(s.rob2(nums));
    }
}
// @lc code=end

