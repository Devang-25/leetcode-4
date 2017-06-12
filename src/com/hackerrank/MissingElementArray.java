package com.hackerrank;

import java.util.Arrays;

public class MissingElementArray {

	static int missingElement(int[] input){
	
		return (input.length+1)*(input.length+2)/2 -  Arrays.stream(input).sum();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int[] input = {1,2,3,4,5,7,8};
			System.out.println(missingElement(input));
	}

}
