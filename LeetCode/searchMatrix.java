package LeetCode;

public class searchMatrix {
	 public boolean searchMatrix(int[][] a, int target) {
	        int row=0;
	        while(row<a.length){
	            int l=0,r=a[row].length-1;
	            while(l<=r){
	                int mid=(l+r)/2;
	                if(target<a[row][mid]){
	                    r=mid-1;
	                }
	                else if(target>a[row][mid]){
	                    l=mid+1;
	                }
	                else return true;
	            }
	            row++;
	        }
	        return false;
	    }
	 
    public boolean searchMatrix2(int[][] a, int target) {
        int row=0, col=a[0].length-1;
        while(row<a.length && col>=0){
        	if(target > a[row][col]) row++;
        	else if(target < a[row][col]) col--;
        	else return true;
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
