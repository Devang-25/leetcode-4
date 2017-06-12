package AlgorithmDSLeetCode;

import java.util.HashMap;
import java.util.List;

import javax.security.auth.kerberos.KeyTab;

public class LRUCache {
    
    private HashMap<Integer, Integer> map ;
    private int capacity;
    private int countElements;
    ListNode pHead;
    //ListNode tail;
    public LRUCache(int capacity) {
    	
        this.capacity = capacity ;
        countElements = 0;
        pHead = null;
        
    }
    
    public int get(int key) {
    	if((countElements==0)) return -1;
        if(!map.containsKey(key)) return -1;
        ListNode tempNext = pHead;
        ListNode prevHead = pHead;
        ListNode prev = pHead;
        while(tempNext!=null){
        	if(tempNext.val == key && tempNext==pHead) break;
        	if(tempNext.val == key) {
        		pHead = tempNext;
        		pHead.next = prevHead;
        		ListNode nextTemp = null;
        		if(tempNext.next!=null) {
        			tempNext = tempNext.next;
        		}
        		prev.next.next = nextTemp;
        		//break;
        	}
        	
        	prev = tempNext;
        	tempNext = tempNext.next;
        }
        System.out.println(" FOR GET pHead "+pHead.val + " key "+key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        //ListNode tail = null;
    	if(countElements !=0)
    		System.out.println(" FOR PUT pHead "+pHead.val +" key "+key);
        if(countElements ==0){
            pHead = new ListNode(key);
            HashMap<Integer,Integer> map1 = new HashMap<>();
            map1.put(key, value);
            map = map1;
            countElements++;
            System.out.println(" FOR PUT pHead "+pHead.val + " key "+key);
        }
        else if(countElements==capacity){
             ListNode prevHead = pHead;
             pHead = new ListNode(key);
             pHead.next = prevHead;
             map.remove(pHead.val);
             map.put(key,value);
        }
       else{
            ListNode prevHead = pHead;
            pHead = new ListNode(key);
            pHead.next = prevHead;
            map.put(key,value);
            countElements++;
       }
        
    }
    

    

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */public static void main(String[] args) {
		// TODO Auto-generated method stub
	 LRUCache obj = new LRUCache(2);
	 obj.put(1, 1);
	 obj.put(2, 2);
	 System.out.println(obj.get(1));
	 obj.put(3, 3);
	 System.out.println(obj.get(2));
	 obj.put(4, 4);
	 System.out.println(obj.get(1));
	 System.out.println(obj.get(3));
	 System.out.println(obj.get(4));
//	 obj.put(5, 5);
//	 System.out.println(obj.get(4));
//	 System.out.println(obj.get(3));
	}

}
