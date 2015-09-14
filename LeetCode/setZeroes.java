package LeetCode;

public class setZeroes {

	public static void setZeroes(int[][] a) {
	       boolean rhavezero=false;
	       boolean chavezero=false;
	       
	       for(int i=0;i<a[0].length;i++){
	           if(a[0][i]==0) {rhavezero=true; break;}
	       }
	       for(int i=0;i<a.length;i++){
	           if(a[i][0]==0) {chavezero=true; break;}
	       }
	       for(int i=1;i<a.length;i++){//start from 1, to avoid a[0][0]=0 case to destroy two index rows
	           for(int j=1;j<a[0].length;j++){
	               if(a[i][j]==0){
	                   a[i][0]=0;
	                   a[0][j]=0;
	               }
	           }
	       }
	       for(int i=1;i<a[0].length;i++){
	           if(a[0][i]==0){
	               for(int j=1;j<a.length;j++){
	                   a[j][i]=0;
	               }
	           }
	       }
	       for(int i=1;i<a.length;i++){
	           if(a[i][0]==0){
	               for(int j=1;j<a[0].length;j++){
	                   a[i][j]=0;
	               }
	           }
	       }
	       if(rhavezero){
	            for(int i=0;i<a[0].length;i++){ a[0][i]=0;}
	       }
	       if(chavezero){
	            for(int i=0;i<a.length;i++){ a[i][0]=0;}
	       }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A={{1,0}};
		setZeroes(A);
		//System.out.println(A.toString());
	}

}
