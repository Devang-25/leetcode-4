package AlgorithmDSLeetCode;

public class CyclicLinkedListNode {
	public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        int count=0;
        while(fast != null && fast.next != null){
        //	ListNode tempSlow = slow;
        	
        	slow = slow.next;
            fast = fast.next.next;
            count++;
            if(slow == fast && slow == head) return head;
            else if(slow == fast && slow != head)  
            	{
            	while(count!=0){
            	 		head = head.next;
            	 		slow = slow.next;
            	 		count--;
            	 		if(head==slow) return head;
            	}
            	}
            	
        }
 
        return null;
	    }
}
