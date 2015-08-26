
public class sortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length-1);
    }
    
    private TreeNode helper(int[] num,int l, int r){
        if(l>r) return null;
        int mid=(l+r)/2;
        TreeNode newnode=new TreeNode(num[mid]);
        System.out.println("mid: "+mid+" l "+l+" r "+r);
        newnode.left=helper(num, l, mid-1);
        newnode.right=helper(num, mid+1, r);
        System.out.println("val: "+newnode.val);
        return newnode;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sortedArrayToBST s=new sortedArrayToBST();
		int[] n={1,3,4,5,6,7};
		TreeNode r=s.sortedArrayToBST(n);

	}

}
