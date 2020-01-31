import java.util.LinkedList;
import java.util.List;

class Solution {

    // prefix sum
    public int numSubarraysWithSum2(int[] A, int S) {
        int[] prefix_sum = new int[A.length];
        prefix_sum[0] = 1;
        int count = 0, sum=0;
        for(int i=0; i<A.length; i++) {
            sum+=A[i];
            if(sum >= S){
                count+= prefix_sum[sum-S];
            }
            prefix_sum[sum]+=1;
        }
        return count;
    }

    //sliding window
    public int numSubarraysWithSum(int[] A, int S) {
        return getMostSum(A, S) - getMostSum(A, S-1);
    }

    private int getMostSum(int[] A, int S){
        int count = 0;
        if(S<0) return 0;
        for(int i=0, start=0; i<A.length; i++) {
            S-=A[i];
            while(S<0) {
                S+=A[start++];
            }
            count+= i-start+1;
        }
        return count;
    }

    public static void main(String[] args) {
               int[] A = {1,0,1,0,1};
        
               Solution s = new Solution();
                System.out.println(s.numSubarraysWithSum(A, 2));
            }
}