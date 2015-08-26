package LeetCode;


public class DListNode {
 
		DListNode prev;
		DListNode next;
		TreeNode val;
		
		DListNode(TreeNode r){
			this.val = r;
		}
		
		DListNode(){
			this.val = null;
		}
		
		void setprev(DListNode n){
			this.prev = n;
		}

		void setnext(DListNode n){
			this.next = n;
		}
}
