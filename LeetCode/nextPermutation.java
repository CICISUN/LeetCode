package LeetCode;

import java.util.Arrays;

public class nextPermutation {

    public static void nextPermutation(int[] nums) {
    	int i=nums.length-1;
    	while(i>0 && nums[i-1]>=nums[i]){
    		i--;
    	}
    	i--;
  
    	if(i<0) {
    		reverse(nums,0);
    		return ;
    	}
    	int j=nums.length-1;
    	while(j>i && nums[j]<=nums[i]){
    		j--;
    	}
      	 
    	//swap i,j
    	int tmp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=tmp;

    	//reverse the partition after i
    	reverse(nums, i+1);

    	return;
    }
    
   private static void reverse(int[] nums, int i){
	   int l=i, r=nums.length-1;
	   while(l<r){
			int tmp=nums[l];
			nums[l]=nums[r];
			nums[r]=tmp;
			l++;
			r--;
	   }
	   return;
   }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={3,2,1};
		nextPermutation(A);
	}

}
