package LeetCode;

public class kthSmallest {

	private static class TreeNodeWithCount{
		int val;
		int count;
		TreeNodeWithCount left;
		TreeNodeWithCount right;
		TreeNodeWithCount(int x) {val = x; count = 1;};
	}
	
	private static TreeNodeWithCount buildtree(TreeNode root){
        if (root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildtree(root.left);
        rootWithCount.right = buildtree(root.right);
        if (rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
        if (rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
	}
	
	public static TreeNodeWithCount findkthsmallest(TreeNodeWithCount root, int k){
		int count=0;
		if(root.left!=null)  count=root.left.count;
		if(count>=k){
			return findkthsmallest(root.left, k);
		}
		else if(count<k-1){
			return findkthsmallest(root.right, k-count-1);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode left1=new TreeNode(0);
		TreeNode right1=new TreeNode(2);
		TreeNode right2=new TreeNode(3);
		root.left=left1;
		root.right=right1;
		right1.right=right2;

		TreeNodeWithCount r=buildtree(root);
		TreeNodeWithCount result = findkthsmallest(r, 1);
		System.out.println(result.val);
	}

}
