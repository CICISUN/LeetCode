package LeetCode;

import java.util.HashMap;

public class copyRandomList {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        //copy current node value, next pointer
        if(map.get(head)!=null){
            return map.get(head);
        }
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head, newhead);
        newhead.next=copyRandomList(head.next);
        //random pointer
        newhead.random=copyRandomList(head.random);
        return newhead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
