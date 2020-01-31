import java.util.LinkedList;
import java.util.List;

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        return getMostSum(A, S) - getMostSum(A, S-1);
    }

    private int getMostSum(int[] A, int S){
        int count = 0;
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