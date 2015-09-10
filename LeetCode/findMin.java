package LeetCode;

public class findMin {

    public static int findMin(int[] nums) {
    	int low=0, high=nums.length-1;
    	while(low<high){
    		int mid=(low+high)/2;
    		if(nums[low]<=nums[mid] && nums[mid]<=nums[high]) return nums[low];
    		else if(nums[mid]<=nums[low] && nums[mid]<=nums[high]){
    			high=mid;
    		}
    		else if(nums[mid]>=nums[low] && nums[mid]>=nums[high]){
    			low=mid+1;
    		}
    	}
    	return nums[low];
    }
    
    public static int findMin2(int[] nums) {
    	int low=0, high=nums.length-1;
    	while(low<high){
    		int mid=(low+high)/2;
    		while(nums[low]==nums[mid] && low<mid) low++;
    		while(nums[high]==nums[mid] && high>mid) high--;
    		if(nums[mid]>nums[high]){
    			low=mid+1;
    		}
    		else{
    			high=mid;
    		}
    	}
    	return nums[low];
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={7,0,1,2,4,4,5,6};
		int[] B={3,3,1,3};
		System.out.println(findMin(B));
	}

}
