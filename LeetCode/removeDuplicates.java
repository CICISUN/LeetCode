
public class removeDuplicates {

	
	
	   public int removeDuplicates(int[] A) {
//	        int n=A.length;
//	        int count=0;
//	        if(A.length==0) return 0;
//	        for(int i=0;i<n;i++){
//	            if(A[i]!=A[count]){A[++count]=A[i];}
//	        }return count+1;
		   
		   
			if (A.length <= 2)
				return A.length;
	 
			int prev = 1; // point to previous
			int curr = 2; // point to current
	 
			while (curr < A.length) {
				if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
					curr++;
				} else {
					prev++;
					A[prev] = A[curr];
					curr++;
				}
			}
	 
			return prev + 1;
	              
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		removeDuplicates r=new removeDuplicates();
		int[] A={1,1,1,2,2,3};
		System.out.println(r.removeDuplicates(A));
		System.out.println(A[0]);
		System.out.println(A[1]);
		System.out.println(A[2]);
		System.out.println(A[3]);
		System.out.println(A[4]);
		System.out.println(A[5]);
	}

}
