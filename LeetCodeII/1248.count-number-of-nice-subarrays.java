import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    // public int numberOfSubarrays(int[] nums, int k) {
    //     Map<Integer, Integer> window = new HashMap<>();
    //     int oddCount = 0;
    //     for(int i=0; i<nums.length; i++) {
    //         int count = window.getOrDefault(nums[i], 0) + 1;
    //         if(nums[i] % 2 == 1) {
    //             oddCount+=1;
    //         }
    //     }
    // }
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        int currCount = 0;
        
        map.put(0, 1);
        
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1) currCount ++;
            if(map.containsKey(currCount - k)) ans += map.get(currCount - k);
            if(!map.containsKey(currCount)) map.put(currCount, 1);
            else map.put(currCount, 1 + map.get(currCount));
        }
        
        return ans;
        
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,1,1};
        Solution s = new Solution();
        System.out.println(s.numberOfSubarrays(A, 3));
    }
}
// @lc code=end

