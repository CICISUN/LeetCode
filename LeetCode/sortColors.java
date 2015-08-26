
public class sortColors {
	
	public void sortColors(int[] A) {
        
        int n=A.length;
        int pr=0,pb=n-1,i=0;
        while(pr<n&&A[pr]==0) pr++;
        while(pb>0&&A[pb]==2) pb--;
        i=pr;
        while(i<=pb){
        	
            if(A[i]==0) {swap(A,i,pr); pr++;}
            if(A[i]==2) {swap(A,i,pb); pb--;}
            else i++;
        }
          
      }
    
    void swap(int[] A,int a, int b){
        int tmp=A[a];
        A[a]=A[b];
        A[b]=tmp;
    }
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sortColors s=new sortColors();
		int[] A={1,0};
		s.sortColors(A);
		System.out.println(A[0]);
		System.out.println(A[1]);
//		System.out.println(A[2]);
//		System.out.println(A[3]);
//		System.out.println(A[4]);

	}

}
