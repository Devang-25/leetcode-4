package AlgorithmDSLeetCode;

import java.awt.Dialog.ModalExclusionType;

public class ListPalindrome {
	static boolean isListPalindrome(ListNode l) {
	    
		if(l==null ||l.next==null )return true;
	    ListNode slow = l;
	    ListNode fast = l;
	    ListNode prev_slow = l;
	    
	    while(fast!=null && fast.next!= null){
	    	prev_slow=slow;
	    	slow=slow.next;
	        fast=fast.next.next;
	}
	    
	    ListNode mid = slow;
	    if(fast!=null){
	        mid = slow.next;
	    }
	    prev_slow.next=null;
	    slow=l;
	    ListNode temp = slow;
	    System.out.println("FOR THE FIRST ONE..");
	    while(temp!=null){
	    	
	    	System.out.print(temp.val+" ");
	    	temp = temp.next;
	    }
	    System.out.println("");
	    
	    mid= reverse(mid);
	    System.out.println("MID after reverse point:"+mid.val);
	    return equateList(slow,mid);

	}


     static ListNode reverse(ListNode head){
	    
	     ListNode prev=null;
	     ListNode curr = head;
	     ListNode next = null;
	    while(curr!=null){
	        next = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr=next;
	    }
	    
	    head=prev;
	    
	    ListNode temp = head;
	    System.out.println("FOR THE SECOND ONE..");
	    while(temp!=null){
	    	
	    	System.out.print(temp.val+" ");
	    	temp = temp.next;
	    }
	    System.out.println();
	    System.out.println("VALUE:"+head.val);
	    return head;
	}

	static boolean equateList(ListNode node1, ListNode node2){
	    
	    while(node2 !=null && node1!=null){
	    	System.out.println(" outside node1.val:"+node1.val + " node2.val:"+node2.val);
	        if(node1.val !=node2.val) {
	        	System.out.println("FALSE node1.val:"+node1.val + " node2.val:"+node2.val);
	        	return false;
	        }
	        else{
	        	System.out.println(" FOR TRUE node1.val:"+node1.val + " node2.val:"+node2.val);
	        }
	        node1=node1.next;
	        node2=node2.next;
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 1, 1000000000, -1000000000, -1000000000, 1000000000, 1
		ListNode listNode = new ListNode(1);
		listNode.next=new ListNode(1000000000);
		listNode.next.next=new ListNode(-1000000000);
		listNode.next.next.next=new ListNode(-1000000000);
		listNode.next.next.next.next=new ListNode(1000000000);
		listNode.next.next.next.next.next=new ListNode(1);
		System.out.println(isListPalindrome(listNode));
		
		//reverse(listNode);
		
	}

}
