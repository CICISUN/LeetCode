package LeetCode;

//Convert a given Binary Tree to Doubly Linked List

public class btreetolist {
	
	static DListNode pre = new DListNode();
	public static DListNode dummy = pre;
	
	public static void btreetolist(TreeNode r){
		if(r==null) return;
		btreetolist(r.left);
		DListNode cur = new DListNode(r);
		cur.prev = pre;
		pre.next = cur;
		pre = cur;
		btreetolist(r.right);
		}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode l = new TreeNode(1);
		TreeNode r = new TreeNode(3);
		root.left = l; root.right=r;
		btreetolist(root);
		System.out.println(dummy.next.val.val);
		System.out.println(dummy.next.next.val.val);
		System.out.println(dummy.next.next.next.val.val);
	}

}
