import java.util.*;

/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class SubarraysWithKDistinct {
    /**
     * O(n) with two pass sliding windows
     * number of subarrays ending at i = i-start+1 
     **/
    public int subarraysWithKDistinct(int[] A, int K) {
        return getCountAtMostK(A, K) - getCountAtMostK(A, K-1);
    }
    public int getCountAtMostK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, start = 0;
        for(int i=0; i<A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            while(map.size() > K) {
                map.put(A[start], map.get(A[start]) -1);
                map.remove(A[start], 0);
                start++;
            }
            res += i-start+1;
        }
        return res;
    }

    /**
     * O(n) with two sliding windows one pass
     * first window <= K with N subarrays,  seconde window < K with M subarrays
     * Total number of sub-arrays with 'exactly' K distinct integers = N - M,
        since N = i - start1
        and M = i - start2
        N - M = start2 - start1
     *  at each i, calculate count of valid subarrays ending at i 
     **/

    public int subarraysWithKDistinct2(int[] A, int K) {
        Map<Integer, Integer> w1 = new HashMap<>();
        Map<Integer, Integer> w2 = new HashMap<>();
        int res = 0;
        for(int i=0, start1=0, start2=0; i<A.length; i++) {
            w1.put(A[i], w1.getOrDefault(A[i], 0)+1);
            w2.put(A[i], w1.getOrDefault(A[i], 0)+1);
            while(w1.size() >= K) {
                w1.put(A[start1], w1.get(A[start1]) -1);
                w1.remove(A[start1], 0);
                start1++;
            }
            while(w2.size() > K) {
                w2.put(A[start2], w2.get(A[start2]) -1);
                w2.remove(A[start2], 0);
                start2++;
            }
            res+=start1-start2;
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinct s = new SubarraysWithKDistinct();
        int[] A = {1,2,1,2,3};
        System.out.println(s.subarraysWithKDistinct2(A, 2));
        
    }
}
// @lc code=end

