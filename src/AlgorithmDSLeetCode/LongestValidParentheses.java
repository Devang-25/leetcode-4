package AlgorithmDSLeetCode;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		
		final char left = '(';
		final char right = ')';
		if(s.length()<=1) return 0;
		
		//System.out.println(s.length());
		
		//Stack<Character> stk = new Stack<Character>();
		int  leftParanCount=0,pairs=0,tempCount=0,cumPairs=0;
		
		for (int i=0;i<s.length();i++){
			
			if(s.charAt(i)==left){
				leftParanCount++;
				tempCount++;
				
			}
			
			if(s.charAt(i)==right && leftParanCount>0){
				leftParanCount--;
				tempCount++;
				pairs++;
			}
			
//			if( leftParanCount==0 && tempCount>0 )
//			{	pairs = pairs+tempCount/2;
//				tempCount=0;
//				leftParanCount=0;
//			}
			
			if(s.charAt(i)==right && leftParanCount==0 && tempCount>0){
				leftParanCount=0;
				tempCount=0;
				if(cumPairs<pairs) cumPairs=pairs;
				pairs=0;
			}
			
			System.out.println("loop counter "+ i + " tempCount "+ tempCount +" leftParanCount "+ leftParanCount+ " pairs "+pairs);
			
		}
		if(cumPairs<pairs) cumPairs=pairs;
		return cumPairs*2;
	}
	
	public static void main(String args[]){
		LongestValidParentheses validPara = new LongestValidParentheses();
		System.out.println(validPara.longestValidParentheses(")()())"));
	}

}
