package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(res, tmp, candidates, target, 0);
        return res;
    }
    
    private static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start){
    	if(target==0) {
    		res.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	
    	if(target<0) return;
    	
    	for(int i=start;i<candidates.length;i++){
    		if(target<candidates[i]) break;
    		tmp.add(candidates[i]);
    		dfs(res,tmp,candidates,target-candidates[i],i);
    		tmp.remove(tmp.size()-1);
    	}
    }
    
    
   
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={2,3,6,7};
		int[] B={10,1,2,7,6,1,5};
		System.out.println(combinationSum(B,8));
	}

}
