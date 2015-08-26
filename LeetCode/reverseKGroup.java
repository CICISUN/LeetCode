
public class reverseKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pref=dummy, start, end;
		while(pref!=null){
			start=pref.next;
			end=pref;
			for (int i=0;i<k;i++){
				end=end.next;
				if(end==null) return dummy.next;
			}
			pref.next=reverse(start,end);
			for(int j=0;j<k;j++){pref=pref.next;}
		} return dummy.next;
	}

	public ListNode reverse(ListNode start,ListNode end){
		ListNode post=end.next,tmp;
		ListNode pre=start,cur=start.next;
		while(cur!=post){
			 tmp=cur.next;
			 cur.next=pre;
			 pre=cur;
			 cur=tmp;
		}
		start.next=post;
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseKGroup r= new reverseKGroup();
		ListNode n4=new ListNode(4,null);
		ListNode n3=new ListNode(3,n4);
		ListNode n2=new ListNode(2,n3);
		ListNode n1=new ListNode(1,n2);

		ListNode result= r.reverseKGroup(n1, 2);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
		System.out.println(result.next.next.next.val);
	}

}