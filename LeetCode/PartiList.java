 
public class PartiList {
	
 
	public static ListNode partition(ListNode head, int x) {
	        
//	    check if the head is null, then return empty linkedlist    
		if (head == null) {
	            return null;
	        }
	        
//	    LeftDummy as the head of the smaller list    
		ListNode leftDummy = new ListNode(0);
		System.out.println("leftDummy: "+leftDummy);
//	    RightDummy as the head of the larger/equal list    
		ListNode rightDummy = new ListNode(0);
		System.out.println("rightDummy: "+rightDummy);
//	    Initialize the two sub-list
		ListNode left = leftDummy, right = rightDummy;
		
	
	        
	        while (head != null) {
//	    If current node is smaller, insert it to the smaller-list, move left pointer next keeping it always on the end     	
	            if (head.val < x) {
	                left.next = head;
	                System.out.println("left-next: "+left.next);
	                System.out.println("leftDummy-next: "+leftDummy.next);
	                left = head;
	                System.out.println("left-next2: "+left.next);
	                System.out.println("leftDummy-next2: "+leftDummy.next);
	            } else {
//	    If current node is bigger/equal, insert it to the bigger/equal-list, move right pointer next keeping it always on the end   
	                right.next = head;
	                right = head;
	            }
	            head = head.next;
	        }
	        
//	    Merge the two lists (left.next=rightDummy.next), set the tail (right.next) to null   
	        
	    	System.out.println("leftDummy: "+leftDummy);
	    	System.out.println("leftDummy-next: "+leftDummy.next);
	        System.out.println("rightDummy: "+rightDummy);
			System.out.println("rightDummy-next: "+rightDummy.next);
	        
	        right.next = null;
	        left.next = rightDummy.next;
	        return leftDummy.next;
	        
	    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n4=new ListNode(2,null);
		ListNode n3=new ListNode(4,n4);
		ListNode n2=new ListNode(5,n3);
		ListNode n1=new ListNode(1,n2);
		
		ListNode result= partition(n1,4);
		System.out.println(result);
		
	}
}

