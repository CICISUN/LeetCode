import java.util.HashMap;

/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class NumberOfSubarrays {

    //sliding window
    public int numberOfSubarrays(int[] nums, int k) {
        return getMostK(nums, k) - getMostK(nums, k-1);
    }

    public int getMostK(int[] nums, int k) {
        int oddCount=0, start=0, res=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) {
                oddCount++;
            }
            while(oddCount > k) {
                if(nums[start++] % 2 == 1) {
                    oddCount--;
                }
            }
            res+= i-start+1;
        }
        return res;
    }

    // prefix sum
    public int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int currCount = 0;
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1) currCount++;
            map.put(currCount, map.getOrDefault(currCount, 0)+1);
            ans+=map.getOrDefault(currCount - k, 0);
        }
        
        return ans;
        
    }

    public static void main(String[] args) {
        int[] A = {2,2,2,1,2,2,1,2,2,2};
        NumberOfSubarrays s = new NumberOfSubarrays();
        System.out.println(s.numberOfSubarrays2(A, 2));
    }
}
// @lc code=end

