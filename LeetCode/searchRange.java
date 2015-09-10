package LeetCode;

import java.util.ArrayList;

public class searchRange {

    public static int[] searchRange(int[] nums, int target) {
        int low=0, mid=0; 
        int high=nums.length-1;
        int[] result = new int[2];
     
        while(low<=high){
        	mid=(low+high)/2;
        	if(nums[mid]<target) low=mid+1;
        	else if(nums[mid]>target) high=mid-1;
        	else{
        		int l=mid, r=mid;
        		result[0]=mid; result[1]=mid;
        		System.out.println(result[0] + ":" +result[1]);
        		while(l>=0 && nums[l]==target){			
        			result[0]=l;
        			l--;
        		}
        		
        		while(r<=nums.length-1 && nums[r]==target){
        			result[1]=r;
        			r++;
        		}
        		
        		System.out.println(result[0] + ":" +result[1]);
                return result;	
        	}
        }
        
        return new int[]{-1,-1};
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,2};
		System.out.println(searchRange(A, 1));
	}

}
