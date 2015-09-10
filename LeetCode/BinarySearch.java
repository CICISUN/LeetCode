package LeetCode;

public class BinarySearch {
    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(int key, int[] a) {
        return search(key, a, 0, a.length);
    }
    public static int search(int key, int[] a, int lo, int hi) {
        // possible key indices in [lo, hi)
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (a[mid]>key) return search(key, a, lo, mid);
        else if (a[mid]<key) return search(key, a, mid+1, hi);
        else              return mid;
    }
    
    public static int searc(int key, int[] A) {
    	if(A==null||A.length==0)
            return -1;
           
          int low = 0;
          int high = A.length-1;
         
          while(low <= high){
              int mid = (low + high)/2;
              if(key < A[mid]){
            	  high=mid-1;
              }
              else if(key > A[mid]){
            	  low=mid+1;
              }
              else return mid;
          }
          return -1;
    }

    //Search in Rotated Sorted Array
    public static int search2(int[] nums, int target) {
    	int low=0, high=nums.length-1, mid=0;
    	while(low<high){
    		mid=(low+high)/2;
    		while(nums[low]==nums[mid] && low<mid) low++;
    		while(nums[high]==nums[mid] && high>mid) high--;
    		if(nums[mid]>nums[high]){
    			low=mid+1;
    		}
    		else{
    			high=mid;
    		}
    	}
    	int min=low;
    	System.out.println(min);
    	if(nums[nums.length-1]<target) {low=0;high=min-1;}
    	else {low=min; high=nums.length-1;}
        while(low <= high){
            mid = (low + high)/2;
            if(target < nums[mid]){
          	  high=mid-1;
            }
            else if(target > nums[mid]){
          	  low=mid+1;
            }
            else return mid;
        }
        return -1;	
    }
    //Search in Rotated Sorted Array
    public int search3(int [] A,int target){
        if(A==null||A.length==0)
          return -1;
         
        int low = 0;
        int high = A.length-1;
       
        while(low <= high){
            int mid = (low + high)/2;
            if(target < A[mid]){
                if(A[mid]<A[high])//right side is sorted
                  high = mid - 1;//target must in left side
                else
                  if(target<A[low])//target<A[mid]&&target<A[low]==>means,target cannot be in [low,mid] since this side is sorted
                     low = mid + 1;
                  else 
                     high = mid - 1;
            }else if(target > A[mid]){
                if(A[low]<A[mid])//left side is sorted
                  low = mid + 1;//target must in right side
                else
                  if(target>A[high])//right side is sorted. If target>A[high] means target is not in this side
                     high = mid - 1;
                  else
                     low = mid + 1;
            }else
              return mid;
        }
        
        return -1;
 }
    //Search in Rotated Sorted Array II 
    public static boolean search4(int [] A,int target){
        if(A==null||A.length==0)
          return false;
         
        int low = 0;
        int high = A.length-1;
       
        while(low <= high){
            int mid = (low + high)/2;
            if(target < A[mid]){
                if(A[mid]<A[high])//right side is sorted
                  high = mid - 1;//target must in left side
                else if(A[mid]==A[high]) high--; 
                else
                  if(target<A[low])//target<A[mid]&&target<A[low]==>means,target cannot be in [low,mid] since this side is sorted
                     low = mid + 1;
                  else 
                     high = mid - 1;
            }else if(target > A[mid]){
                if(A[low]<A[mid])//left side is sorted
                  low = mid + 1;//target must in right side
                else if(A[low]==A[mid]) low++;
                else
                  if(target>A[high])//right side is sorted. If target>A[high] means target is not in this side
                     high = mid - 1;
                  else
                     low = mid + 1;
            }else
              return true;
        }
        
        return false;
 }
    
    // whitelist, exception filter
    public static void main(String[] args) {
        int[] B={1,1,3,1};

    	System.out.print(search4(B, 3));
}
}
