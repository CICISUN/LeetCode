package LeetCode;

public class isValidBST {
	
    public static int pre = Integer.MIN_VALUE; 
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val<=pre) return false;
        System.out.println(pre);
        pre=root.val;
        if(!isValidBST(root.right)) return false;
        return true;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValidBST i= new isValidBST();
		
		TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        
        System.out.println(i.isValidBST(root));

	}

}
