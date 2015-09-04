package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class combine {

	public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, tmp, n, k, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start){
        if(tmp.size()==k){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i=start; i<=n;i++){
            if(tmp.contains(i)) continue;
            tmp.add(i);
            dfs(res,tmp,n,k,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
