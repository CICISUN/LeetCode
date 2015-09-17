package LeetCode;

public class climbStairs {
    public static int climbStairs(int n) {
        int[] ways={0};
        climb(ways, 0, n);
        return ways[0];   
    }
    private static 
    void climb(int[] ways, int len, int n){
        if(len>n) return;
        if(len==n){ways[0]++;return;}
        climb(ways, len+1, n);
        climb(ways, len+2, n);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(3));
	}

}
