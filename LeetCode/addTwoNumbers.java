package LeetCode;

public class addTwoNumbers {
	
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 
		 if(l1==null && l2==null) return null;
		 ListNode head=new ListNode(0);
		 ListNode cur=head;
		 int carries=0;
		 while(l1!=null&&l2!=null){
			 int sum=l1.val+l2.val+carries;
			 carries=sum/10;
			 ListNode n=new ListNode(sum%10);
			 cur.next=n;
			 
			 l1=l1.next;
			 l2=l2.next;
			 cur=cur.next; 
		 }
		 
		 while(l1!=null){
			 int sum=carries+l1.val;
			 cur.next=new ListNode(sum%10);
			 carries=sum/10;
			 cur=cur.next;
			 l1=l1.next;
		 }
		 
		 while(l2!=null){
			 int sum=carries+l2.val;
			 cur.next=new ListNode(sum%10);
			 carries=sum/10;
			 cur=cur.next;
			 l2=l2.next;
		 }
		 
		 if(carries!=0){
			 cur.next=new ListNode(carries%10);
		 }
		 
		 return head.next;
		    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
