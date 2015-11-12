package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class mergeKLists {


	public ListNode mergeKLists(List<ListNode> lists) {

		if(lists == null || lists.isEmpty()) return null;


		Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
			public int compare(ListNode left, ListNode right) {
				if (left == null) {
					return 1;
				} else if (right == null) {
					return -1;
				}
				return left.val - right.val;
			}
		};

		Queue<ListNode> heap=new PriorityQueue<ListNode>(lists.size(),  ListNodeComparator);

		for(int i=0; i<lists.size(); i++){
			if(lists.get(i) != null){
				heap.add(lists.get(i));
			}
		}

		ListNode h=new ListNode(0);
		ListNode l=h;
		while(!heap.isEmpty()){
			ListNode head=heap.poll();
			l.next=head;
			l=head;
			if(head.next != null){
				heap.add(head.next);
			}

		}

		return h.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
