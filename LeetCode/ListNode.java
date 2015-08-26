package LeetCode; 

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
		
		ListNode(int x, ListNode n) {
			val = x;
			next = n;
			}
		}