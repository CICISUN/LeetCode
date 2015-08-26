
public class rotateRight {
	
	 public ListNode rotateRight(ListNode head, int n) {
	        int k=1;
	        ListNode cur=head;
	        if(cur==null||cur.next==null) return head;
	        while(cur.next!=null){cur=cur.next;k++;}
	        cur.next=head;
	        cur=head;
	        if((k-n)==0) return head;
	        for(int i=1;i<k-n;i++){
	            cur=cur.next;
	        }
	        ListNode tmp=cur.next;
	        cur.next=null;
	        return tmp;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotateRight r= new rotateRight();
		ListNode n4=new ListNode(4,null);
		ListNode n3=new ListNode(3,n4);
		ListNode n2=new ListNode(2,n3);
		ListNode n1=new ListNode(1,n2);

		ListNode result= r.rotateRight(n1, 4);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
		System.out.println(result.next.next.next.val);
	}

}
