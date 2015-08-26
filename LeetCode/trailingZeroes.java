package LeetCode;

public class trailingZeroes {
	
	 public int trailingZeroes(int n) {
	        if(n<5) return 0;
	        int count_of_five=0;
	        while(n>1){
	            n=n/5;
	            count_of_five+=n;
	        }
	        return count_of_five;
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trailingZeroes t = new trailingZeroes();
		System.out.println(t.trailingZeroes(100));
 
	}

}
