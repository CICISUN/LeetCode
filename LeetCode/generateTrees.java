package LeetCode;

import java.util.ArrayList;

public class generateTrees {
	
    public ArrayList<TreeNode> generateTrees(int n) {
    	return buildTrees(1,n);
        
    }
    
    public ArrayList<TreeNode> buildTrees(int min, int max){
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if(min>max){res.add(null); return res;}
    	for(int i=min;i<=max;i++){
    		ArrayList<TreeNode> l = buildTrees(min,i-1);
    		ArrayList<TreeNode> r = buildTrees(i+1,max);
    		for(TreeNode j: l){
    			for(TreeNode k:r){
    				TreeNode root =  new TreeNode(i);
    				root.left = j;
    				root.right = k;
    				res.add(root);
    			}
    		}
    	}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees g = new generateTrees();
		System.out.println(g.buildTrees(1, 3));

	}

}
