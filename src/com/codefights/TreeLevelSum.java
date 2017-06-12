package com.codefights;

import org.omg.CORBA.PRIVATE_MEMBER;

public class TreeLevelSum {

	static int treeLevelSum(String tree, int k) {
		
		final char front = '(';
		final char back = ')';
		
		StringBuilder levelStringNum = new StringBuilder();
		char[] stringChar = tree.toCharArray();
		Integer level = 0;
		int sum = 0;
		
		for(int i = 0;i<stringChar.length;i++){
			if(stringChar[i]==front) {
				if(level == k+1 && levelStringNum.length() !=0)
					sum += Integer.parseInt(levelStringNum.toString());
				levelStringNum.setLength(0);
				level++;
			}
			else if(stringChar[i]==back) {
				if(level == k+1 && levelStringNum.length() !=0)
					sum += Integer.parseInt(levelStringNum.toString());
				levelStringNum.setLength(0);
				level--;
			}
			else{
				levelStringNum.append(stringChar[i]);
			}
		}
		return sum;

	}

	// tree = "(0(5(6()())(14()(9()())))(7(1()())(23()())))" and k = 2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tree = "(0(5()())(10))";
		System.out.println(treeLevelSum(tree, 3));
	}

}
