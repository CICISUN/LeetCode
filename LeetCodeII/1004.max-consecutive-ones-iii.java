import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class LongestOnes {

    // a q to store K 0s flipped, if reached K, revert from first 0s until qualifies
    public int longestOnes(int[] A, int K) {
        int curMax = 0, start = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<A.length; i++) {
            if(A[i] == 0){
                q.offer(i);
                A[i] = 1;
            }
            while(q.size() > K) {
                int revertIndex = q.pollFirst();
                A[revertIndex] = 0;
                start = revertIndex+1;
            }
            curMax = Math.max(curMax,i-start+1);
        }
        return curMax;
    }

    // a simplier two pointer way of method 1
    public int longestOnes3(int[] A, int K) {
        int start = 0, res=0;
        for(int i=0; i<A.length; i++) {
            if (A[i] == 0) K--;
            while(K < 0) {
                if(A[start++] == 0) K++;
            }
            res = Math.max(res, i-start+1);
        }
        return res;
    }

    // keep expanding [start,i] window
    // If A[i] ~ A[j] has zeros <= K, we continue to increment j.
    // If A[i] ~ A[j] has zeros > K, we increment i.
    public int longestOnes2(int[] A, int K) {
        int start=0, i;
        for(i=0; i<A.length; i++) {
            if(A[i] == 0) K--;
            if(K<0 && A[start++]==0) {
                K++;
            }
        }
        return A.length-start;
    }


    public static void main(String[] args) {
        LongestOnes s = new LongestOnes();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(s.longestOnes3(A, 3));
    }
}
// @lc code=end

