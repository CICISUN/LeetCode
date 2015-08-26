package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class permute {
	
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	dfs(result,tmp,nums);
    	return result;
    }
    
    private static void dfs(List<List<Integer>> result,List<Integer> tmp, int[] nums){
    	if(tmp.size() == nums.length) {
    		result.add(new ArrayList<Integer>(tmp));
    		return;}
    	 
    	for(int i=0;i<nums.length;i++){
    		if(tmp.contains(nums[i])) continue;
			 tmp.add(nums[i]);
			 dfs(result, tmp, nums);
			 tmp.remove(tmp.size()-1);
    		}
    	return;
    }
    
    public static ArrayList<ArrayList<Integer>> permute2(int[] nums) {
        ArrayList<ArrayList<Integer>> permutations
             = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        
        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        stack.add(-1);
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            
            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }
            
            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }
            
            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums[stack.get(i)]);
            }
            permutations.add(permutation);
        }
        
        return permutations;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		System.out.println(permute2(A));
	}

}
