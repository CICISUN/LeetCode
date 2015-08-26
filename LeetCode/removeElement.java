
public class removeElement {
	
	 public int removeElement(int[] A, int elem) {
	        int r=A.length-1;
	        int i=0;
	        int tmp=0;
	        if(A.length==0) return 0;
	        while(i<=r){
	            if(A[i]==elem){
//	            	A[i]=A[r];
	                tmp=A[i];
	                A[i]=A[r];
	                A[r]=tmp;
	                r--;
	            }
	            else i++;
	        } return r+1;
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeElement r=new removeElement();
		int[] A={1,0};
		System.out.println(r.removeElement(A, 1));
		System.out.println(A[0]);
		System.out.println(A[1]);

	}

}
