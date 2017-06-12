package AlgorithmDSLeetCode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicatesLinkedList {

	public ListNode deleteDuplicates(ListNode head) {

		Map<Integer,Integer> valList = new HashMap<>();
		if (head == null) {
            return null;
        }
		
		if (head.next ==null) {
            return head;
        }
		ListNode ans = head;
		while(ans !=null ){
			if(valList.containsKey(ans.val)){
				valList.put(ans.val, valList.get(ans.val)+1);
			}
			else 
				valList.put(ans.val, 1);
			ans = ans.next;
        }
		ans = head;
		ListNode ans1 = ans;
		while(ans !=null){
			
			if(valList.get(ans.val) >1){
				// to remove the node and redirect to the next node...
				
				ans1 = ans.next.next;
			}
			else {
				ans1 = ans.next;
			}
			
        }
		return ans1;
		
	}
}
