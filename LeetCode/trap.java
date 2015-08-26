
public class trap {
	public int trap(int[] A) {
		if (A == null || A.length == 0) {  
			return 0;  
		}  
		int i, n=A.length,vol=0,max=0,left[]=new int[n],right[]=new int[n];
		//left to right
		for(i=1, max=A[0], left[0]=A[0]; i<n;i++ ){
			if(A[i]>max) {max=A[i]; left[i]=A[i];}
			else left[i]=max;
		}
		//right to left
		for(i = n-2, max=A[n-1],right[n-1]=A[n-1];i>=0;i--){
			if(A[i]>max){max=A[i]; right[i]=max;}
			else right[i]=max;
		}

		for(i =1;i<n-1;i++){
			int tmp= 1 * (Math.min(left[i],right[i])-A[i]);
			if(tmp!=0) vol+=tmp;
		}
		return vol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
