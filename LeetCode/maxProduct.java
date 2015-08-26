package LeetCode;

public class maxProduct {
	//LTE....
	public int maxProduct(int[] A){
		int maxvalue=0;
		for(int i=0;i<A.length;i++){
			for(int j=i;j<A.length;j++){
				int tmp=1;
				for(int k=i;k<=j;k++){
				tmp*=A[k];
						}
				if(tmp>maxvalue){
					maxvalue=tmp;
				}
			}
		}
		return maxvalue;
	}
	
	public int maxProduct2(int[] A){
		int maxvalue=Integer.MIN_VALUE;
		int minval=1, maxval=1;
		for(int i=0;i<A.length;i++){
    	    int a=A[i] * minval;
    	    int b=A[i] * maxval;
    	    maxval=Math.max(Math.max(a,b),A[i]);
    	    minval=Math.min(Math.min(a,b),A[i]);
    	    maxvalue=Math.max(maxvalue,Math.max(a,b));
		}
		return maxvalue;

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxProduct m=new maxProduct();
		int[] A={-5,2,4,1,-2,2,-6,3,-1,-1,-1,-2,-3,5,1,-3,-4,2};
		System.out.println(m.maxProduct(A));
	}

}
