package LeetCode;

public class sortList {

	public static ListNode mergetwosortedlist(ListNode a, ListNode b){
		ListNode head = new ListNode(0);
		ListNode h=head;
		while(a!= null && b!=null){
			if(a.val>b.val){
				h.next=b;
				b=b.next;
			}
			else{
				h.next=a;
				a=a.next;
			}
			h=h.next;
		}
		if(a==null) h.next=b;
		else h.next=a;
		return head;
	}

	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null &&  fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		fast=slow.next;//fast now points to mid
		slow.next=null;
		slow=sortList(head);//sort first half
		fast=sortList(slow);//sort second half
		return mergetwosortedlist(slow, fast);    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
