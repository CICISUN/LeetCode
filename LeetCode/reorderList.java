package LeetCode;

public class reorderList {
	
	   public static void reorderList(ListNode head) {
	        if(head==null || head.next==null) return;
	        ListNode slow=head, fast=head;
	        while(fast.next!=null && fast.next.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	        }
	        ListNode cur=slow.next, post=cur, pre=null;
	        slow.next=null;
	        while(cur!=null){
	            post=cur.next;
	            cur.next=pre;
	            pre=cur;
	            cur=post;
	        }
	        while(pre!=null && head!=null){
	            post=head.next;
	            head.next=pre;
	            pre=pre.next;
	            head.next.next=post;
	            head=post;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
