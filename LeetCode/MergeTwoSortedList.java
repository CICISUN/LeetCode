
public class MergeTwoSortedList {


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode h=new ListNode(0);
		ListNode l=h;

		while(l1!=null&&l2!=null){

			if(l1.val<l2.val){
				l.next=l1;
				l1=l1.next;		
			}
			else{
				l.next=l2;
				l2=l2.next;
			}

			l=l.next;
		}

		if (l1==null) l.next=l2;
		else l.next=l1;

		return h.next;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
