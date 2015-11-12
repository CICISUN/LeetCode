package LeetCode;

public class PaintFence {
	
    public int numWays(int n, int k) {
        if (n < 2 || k == 0) {
            return n * k; 
        } 
        
        int s = k;
        int d1 = k;
        int d2 = k * (k - 1); 
        for (int i = 2; i < n; i++) { 
            s = d2;
            d2 = (k - 1) * (d1 + d2);
            d1 = s;
        } 
        return s + d2;
    }


}
