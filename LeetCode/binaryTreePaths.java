package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null) return res;
        StringBuilder sb = new StringBuilder();
        dfs(root, res, sb);
        return res;
    }
    private void dfs(TreeNode root, List<String> res, StringBuilder sb){
        if(root.left==null && root.right==null){
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if(root.left!=null){
            dfs(root.left, res, new StringBuilder(sb));
        }
        if(root.right!=null){
            dfs(root.right, res, new StringBuilder(sb));
        }
    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
