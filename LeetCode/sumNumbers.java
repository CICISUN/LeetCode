package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class sumNumbers {
	public int sumNumbers(TreeNode root) {
        ArrayList<Integer> path=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return 0;
        dfs(root, path, res);
        return getsum(res);
    }
    
    private static void dfs(TreeNode cur, ArrayList<Integer> path, List<List<Integer>> res){
        path.add(cur.val);
        if(cur.left==null || cur.right==null){
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        if(cur.left!=null){
            dfs(cur.left, path, res);
        }
        if(cur.right!=null){
            dfs(cur.right, path, res);
        }
        path.remove(path.size()-1);
    }
    
    private int getsum(List<List<Integer>> res){
        int sum=0;
        for(List<Integer> path: res){
        	System.out.println(res);
            int subsum=0;
            for(int i=0;i<path.size();i++){
                subsum=10*subsum+path.get(i);
            }
            sum+=subsum;
        }
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
