package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs2(res, tmp, candidates, target, 0);
        return res;
    }
    
    private static void dfs2(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start){
    	 
    	if(target==0) {
    		res.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	
    	if(target<0) return;
    	
    	int prev=-1;
    	
    	for(int i=start;i<candidates.length;i++){
    		if(target<candidates[i]) break;
    		if(candidates[i]!=prev){
	    		tmp.add(candidates[i]);
	    		dfs2(res,tmp,candidates,target-candidates[i],i+1);
	    		prev=candidates[i];
	    		tmp.remove(tmp.size()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] B={1,1};
		System.out.println(combinationSum2(B,1));
	}


}
