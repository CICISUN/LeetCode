package LeetCode;

public class swapPairs {
	

	public static ListNode swapPairs(ListNode head) {
		ListNode dummyhead = new ListNode(0);
		dummyhead.next = head; //use dummyhead to deal with null case
		ListNode first = dummyhead;
		ListNode second =head;

		while(second!=null && second.next!=null){//when second is null (odd), or second next is null(even
		ListNode tmp = second.next.next; //record next start
		second.next.next = second; //reverse
		first.next = second.next; // link to second
		second.next = tmp; // link to next start
		first=second; // move to next
		second = second.next; //move to next
		}
		return dummyhead.next;
		}

		public static void main(String[] args){
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		a.next=b;
		System.out.println(swapPairs(a).val);
		}
}