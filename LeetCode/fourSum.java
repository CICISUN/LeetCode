package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	    	Arrays.sort(nums);
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	 
	        for(int i=0; i<nums.length-3; i++){
				if (i > 0 && nums[i] == nums[i-1])
					continue;
	            for(int j=i+1; j<nums.length-2; j++){
	            	if (j>i+1 && nums[j]==nums[j-1])
						continue;
	                int left = j+1;
	                int right = nums.length-1;
	                
	                while(left<nums.length && left<right){
	                	
		                if(nums[left]+ nums[right] == target-nums[i]-nums[j]) {
		                    ArrayList<Integer> tmp = new ArrayList<Integer>();
		                    int leftnum = nums[left]; 
		                    tmp.add(nums[i]);
		                    tmp.add(nums[j]);
		                    tmp.add(nums[left]);
		                    tmp.add(nums[right]);
		                    res.add(tmp);
		                    while(left<nums.length && nums[left] == leftnum){
		                    	left++;
		                    }
		                }
		                else if(nums[left]+ nums[right] > target-nums[i]-nums[j]){
		                	right--;
		                }
		                else{
		                	left++;
		                }
	                }
	            }
	        }      
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// -3,-2,-1,0,0,1,2,3
		int[] A ={-1,0,1,2,-1,-4};
		System.out.println(fourSum(A, -1));
	}

}
