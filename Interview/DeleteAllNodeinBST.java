package Interview;

import LeetCode.TreeNode;

public class DeleteAllNodeinBST {
	//Google Phone II
	
	//O(n) space, O(n) time 
	public void recursiveDel(TreeNode r){
		if(r!=null){
			recursiveDel(r.left);
			recursiveDel(r.right);
			r.val=0;
			r=null;
		}
	}

	//O(1) space, O(n) time - Morris Traversal
	//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
	public void inorderMorrisTraversal(TreeNode r){
		TreeNode cur=r, pre=null;
		while(cur!=null){
			if(cur.left==null){//1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
				System.out.println(cur.val);
				cur.val=0;
				cur=cur.right;
			}
			else{
				//2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
				pre=cur.left;
				while(pre.right!=null && pre.right!=cur){
					pre=pre.right;
				}
				if(pre.right==null) //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
				{
					pre.right=cur;
					cur=cur.left;
				}
				else{//如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
					pre.right=null;
					System.out.println(cur.val);
					cur.val=0;
					cur=cur.right;
				}
			}
		}
	}
	
	
	////O(n) space, O(n) time - Rotate Tree
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(7);
		root.left=a;
		root.right=e;
		root.left.left=b;
		root.left.right=c;
		root.left.right.left=d;
		
		DeleteAllNodeinBST del = new DeleteAllNodeinBST();
		del.inorderMorrisTraversal(root);
		del.inorderMorrisTraversal(root);

	}

}
