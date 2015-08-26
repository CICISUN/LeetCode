package LeetCode;

public class findMedianSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(nums1.length == 0) return len % 2 == 0 ? (nums2[len/2] + nums2[len/2 - 1]) / 2.0 : nums2[len/2];
        if(nums2.length == 0) return len % 2 == 0 ? (nums1[len/2] + nums1[len/2 - 1]) / 2.0 : nums1[len/2];
        if(len % 2 != 0){ return findkth(nums1, 0, nums2, 0, len/2 + 1);}
        else return (findkth(nums1, 0, nums2, 0, len/2) + findkth(nums1, 0, nums2, 0, len/2 + 1)) / 2.0;
    }
    
    public static double findkth(int[] A, int a, int[] B, int b, int k){
        //first, put the shorter array up-front
        if(A.length-a > B.length-b) return findkth(B, b, A, a, k);
        //second, if the smaller array overflows, find the k-1 th in B
        if(a >= A.length) return B[b+k-1];
        //third, if k is down to 1, return the smaller one in current two arrays
        if(k == 1) return Math.min(A[a], B[b]);
        //else, compare two medians and cut off the smaller portion
        int mida = Math.min(k/2, A.length-a);
        int midb = k - mida;
        if(A[a+mida-1] < B[b+midb-1]){
            //if mida is smaller, find k-mida in
            return findkth(A , mida+a, B, b, k-mida);
        }
        else if(A[a+mida-1] > B[b+midb-1]){
            //if mida is bigger, find k-mid
            return findkth(A, a, B, midb+b, k-midb);
        }
        else{
            //mida equals to midb, return anyone of them
            return A[a+mida-1];
        }
        
    }
	        
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int[] B = {2,3};
		System.out.println(findMedianSortedArrays(A,B));

	}

}
