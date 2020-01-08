import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] prefixSumArr = new int[A.length+1];
        for(int i=1; i<A.length+1; i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + A[i-1];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        for(int i=0; i<A.length+1; i++) {
            while(!q.isEmpty() && prefixSumArr[q.peekLast()] >= prefixSumArr[i]) {
                q.removeLast();
            }
            while(!q.isEmpty() && prefixSumArr[i] - prefixSumArr[q.peekFirst()] >= K) {
                res = Math.min(res, i-q.removeFirst());
            }
            q.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] arr = {84,-37,32,40,95};
//        s.shortestSubarray(arr, 167);
//    }
}