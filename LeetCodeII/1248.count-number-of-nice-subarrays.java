import java.util.*;

/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class numberOfSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
        return getMostK(nums, k) - getMostK(nums, k-1);
    }
    
    private int getMostK(int[] nums, int k) {
        int count = 0;
        for(int i=0, start=0; i<nums.length ; i++) {
            if(nums[i] % 2 == 1) {
                k-=1;
            }
            while(k<0) {
                if(nums[start] % 2 == 1) {
                    k+=1;
                }
                start++;
            }
            count += i-start+1;
        }
        return count;
    }
    
    public int numberOfSubarrays2(int[] nums, int k) {
        
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
    
    public int numberOfSubarrays3(int[] nums, int k) {
    	  LinkedList<Integer> deq = new LinkedList();
    	  deq.add(-1);
    	  int res = 0;
    	  for (int i = 0; i < nums.length; ++i) {
    	    if (nums[i] % 2 == 1) deq.add(i);
    	    if (deq.size() > k + 1) deq.pop();
    	    if (deq.size() == k + 1) res += deq.get(1) - deq.get(0);
    	  }
    	  return res;
    }

    public static void main(String[] args) {
//        int[] A = {1,1,2,1,1};
        int[] A = {2,2,1,2,1,2,2,1,2,1,2};

        numberOfSubarrays s = new numberOfSubarrays();
        System.out.println(s.numberOfSubarrays3(A, 2));
    }
}
// @lc code=end

