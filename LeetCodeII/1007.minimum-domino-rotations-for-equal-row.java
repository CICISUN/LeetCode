import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class minDominoRotations {

    // brute force O(12*N)
    public int minDominoRotations(int[] A, int[] B) {
        int res=Integer.MAX_VALUE;
        for(int i=1; i<=6; i++) {
            res = Math.min(res, rotate(A, B, i));
            res = Math.min(res, rotate(B, A, i));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int rotate(int[] A, int[] B, int val) {
        int opt=0;
        for(int i=0; i<A.length; i++) {
            if(A[i] == val) continue;
            if(B[i] != val) return Integer.MAX_VALUE;
            opt++;
        }
        return opt;
    }

    // If countA[i] + countB[i] - same[i] == A.length
    // we find a solution; otherwise, return -1;
    // return min(countA[i], countB[i]) - same[i] 
    // Time O(N), Space O(1)
    public int minDominoRotations2(int[] A, int[] B) {
        
        int[] countA = new int[7]; // countA[i] records the occurrence of i in A.
        int[] countB = new int[7]; // countB[i] records the occurrence of i in B.
        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
        for (int i = 0; i < A.length; i++) {
            ++countA[A[i]];
            ++countB[B[i]];
            if (A[i] == B[i]) { ++same[A[i]]; }
        }
        for(int i=1; i<=6; i++) {
            if(countA[i] + countB[i] - same[i] == A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }

    /**
     * Find intersection set s of all {A[i], B[i]}
        s.size = 0, no possible result.
        s.size = 1, one and only one result.
        s.size = 2, it means all dominoes are [a,b] or [b,a], try either one.
        s.size > 2, impossible.
        return min(countA[i], countB[i]) - same[i] 
        Time O(N), Space O(1)
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations3(int[] A, int[] B) {
        HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countA = new int[7], countB = new int[7];
        for (int i = 0; i < A.length; ++i) {
            s.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));
            countA[A[i]]++;
            countB[B[i]]++;
        }
        for (int i : s)
            return A.length - Math.max(countA[i], countB[i]);
        return -1;
    }
    public static void main(String[] args) {
        minDominoRotations s = new minDominoRotations();
        int[] A = {1,2,3,2,2};
        int[] B = {2,1,2,3,2};
        System.out.println(s.minDominoRotations3(A, B));
    }
}
// @lc code=end

