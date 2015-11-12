package LeetCode;

import java.util.Arrays;


public class firstMissingPositive {


	public int firstMissingPositive(int A[]) {
		int n= A.length;
		int i=0;
		int tmp=0;
		
		while(i<n){
			if(A[i]>0 && A[i]<n && A[i]!=A[A[i]-1])
			{
				tmp=A[A[i]-1];
				A[A[i]-1]=A[i];
				A[i]=tmp;
			}
			else i++;
		}
		
		for(i=0;i<n;i++){
			if(A[i]!=i+1) return i+1;
		}
		return n+1;
		
//		if(n==0) return 1;
//		Arrays.sort(A);
//		while(i<n && A[i]<=0) i++;
//	
//		for(;i<n;i++){
//			if(i>0&&A[i]==A[i-1]) continue;
//			else if(A[i]-index!=1) return index+1;
//			else index=A[i];
//		}
//		return index+1;  
	}

	public static void main(String[] args) {
		
		firstMissingPositive d=new firstMissingPositive();
		int[] A={3,4,-1,1};
		int n=4;
		int r=d.firstMissingPositive(A);
		System.out.println(r);
		
	}

}
