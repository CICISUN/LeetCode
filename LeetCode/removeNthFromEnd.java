
public class removeNthFromEnd {
	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 
		 ListNode cur=head;
		 ListNode p=head;
		 
		 for(int i=0;i<n;i++){cur=cur.next;}
		 if(cur==null) head=head.next;
		 else {while(cur.next!=null){p=p.next;cur=cur.next;}
		
		 p.next=p.next.next;}
		 return head;
	       
		 
//		 ListNode cur=head;
//	        int i=0;
//	        while(cur!=null){cur=cur.next;i++;}
//	        System.out.println(i);
//	         ListNode cur2=head;
//	         
//	         if(n==i){head=head.next;}
//	         
//	        for(int j=0;j<i-n-1;j++){
//	        	
//	        	System.out.println(j);
//	        	cur2=cur2.next;
//	        }
//	        if (cur2.next == null) {
//                return null;
//            }
//	        else cur2.next=cur2.next.next;
//	        return head;
//	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode n4=new ListNode(2,null);
//		ListNode n3=new ListNode(4,n4);
//		ListNode n2=new ListNode(5,n3);
//		ListNode n1=new ListNode(1,n2);
//		removeNthFromEnd n=new removeNthFromEnd();
//		ListNode result= n.removeNthFromEnd(n1, 3);
//		System.out.println(result.val);
//		System.out.println(result.next.val);
//		System.out.println(result.next.next.val);
		ListNode n3=new ListNode(3,null);
		ListNode n2=new ListNode(2,n3);
		ListNode n1=new ListNode(1,n2);
		removeNthFromEnd n=new removeNthFromEnd();
		ListNode result= n.removeNthFromEnd(n1, 1);
		System.out.println(result.val);
	}

}
