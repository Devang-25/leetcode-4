package AlgorithmDSLeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;import javax.swing.JFormattedTextField.AbstractFormatter;

import org.omg.CORBA.INTERNAL;

public class StackWithQueues {

		Queue<Integer> q1 = new LinkedList<>();	
		
	    /** Push element x onto stack. */
	    public void push(int x) {
	        Queue<Integer> qTemp = new LinkedList<>();
	        qTemp.add(x);
	        qTemp.addAll(q1);
	        q1=qTemp;
	        System.out.println("After Push of :"+x+" stack is "+q1 );
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        int pop = q1.remove();
	        return pop;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	if (!(q1 ==null)) {
	    		return q1.peek();
			}
	        return Integer.MIN_VALUE;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithQueues obj = new StackWithQueues();
		obj.push(1);
//		obj.push(2);
//		System.out.println("IN TOP: "+obj.top());
//		System.out.println("IN POP: "+obj.pop());
//		System.out.println("IN POP: "+obj.pop());
		System.out.println("IN EMPTY: "+obj.empty());
		
	}

}
