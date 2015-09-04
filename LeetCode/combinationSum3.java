package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res,tmp,k,n,1);
        return res;
    }
    private static void dfs(List<List<Integer>> res, List<Integer>tmp, int k, int n, int start){
    	if(tmp.size()==k && n==0){
    		res.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	if(n<0 || tmp.size()>k) return;
    	for(int i=start; i<=9; i++){
    		tmp.add(i);
    		dfs(res,tmp,k,n-i,i+1);
    		tmp.remove(tmp.size()-1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3,9));
	}

}
