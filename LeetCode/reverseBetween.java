import java.util.Stack;


public class reverseBetween {
	
	
	
	
	public ListNode reverseBetween(ListNode head, int m, int n){
		ListNode pre=null,post=null;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode preM=dummy,cur=null;
		for (int i =1;i<=n;i++){
			if(i<m)
				preM=preM.next;
			else if(i==m){
				pre=preM.next;
				cur=pre.next;
			}
			else{
				pre.next=cur.next;
				cur.next=preM.next;
				preM.next=cur;
				cur=pre.next;
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseBetween r= new reverseBetween();
		ListNode n4=new ListNode(4,null);
		ListNode n3=new ListNode(3,n4);
		ListNode n2=new ListNode(2,n3);
		ListNode n1=new ListNode(1,n2);
		
		ListNode result= r.reverseBetween(n1,2,3);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);
		System.out.println(result.next.next.next.val);
	}

}
