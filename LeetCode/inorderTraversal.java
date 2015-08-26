package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class inorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res= new ArrayList<Integer>();
		Stack<TreeNode> stk=new Stack<TreeNode>();
		if(root==null) return res;
		stk.push(root);
		while(!stk.isEmpty()){
			TreeNode tmp = stk.pop();
			if(tmp == null){
				res.add(stk.pop().val);
			}
			else{
				if(tmp.right!=null){stk.push(tmp.right);}
				stk.push(tmp);
				stk.push(null);
				if(tmp.left!=null){stk.push(tmp.left);}
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
