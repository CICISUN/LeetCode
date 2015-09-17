package LeetCode;

import java.util.Stack;

public class isPalindromeList {
    public static boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow=head, fast=head;
        Stack<Integer> stk=new Stack<Integer>();
        stk.push(head.val);
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            stk.push(slow.val);
        }
        
        //slow is now at the lower median
        if(fast.next==null && !stk.isEmpty()) stk.pop();//odd number, pop median
        slow=slow.next;
        while(slow!=null){
        	System.out.println(stk);
            if(slow.val!=stk.peek()) return false;
            stk.pop();
            slow=slow.next;
        }
        return true;
    }
    
    public static boolean isPalindrome2(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //slow is now at the lower median
        slow=slow.next;
        ListNode pre=null, cur=slow, post=cur;
        while(cur!=null){
            post=cur.next;
            cur.next=pre;
            pre=cur;
            cur=post;
        }
        while(head!=null && pre!=null){
            if(head.val!=pre.val) return false;
            head=head.next;
            pre=pre.next;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a=new ListNode(1);
		ListNode b=new ListNode(2);

		a.next=b;

		System.out.println(isPalindrome2(a));
	}

}
