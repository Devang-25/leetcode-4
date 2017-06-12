package com.codefights;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;
import java.util.HashMap;

public class SumofTwoArray {

	static boolean sumOfTwo(int[] a, int[] b, int v) {

		if (a.length == 0 || b.length == 0 || a == null || b == null) {
			return false;
		} else {
			Arrays.sort(a);
			Arrays.sort(b);
			HashMap<Integer, Integer> mapSum = new HashMap<Integer, Integer>();
			if (a.length >= b.length) {
				for (int i = 0; i < b.length; i++) 
					mapSum.put(v - b[i], i);
				for (int i = a.length-1; i > 0; i--) {
					if (mapSum.containsKey(a[i])) {
						return true;
					}
				}
			}
			if (b.length >= a.length) {
				for (int i = 0; i < a.length; i++) 
					mapSum.put(v - a[i], i);
				for (int i = b.length-1; i > 0; i--) {
					if (mapSum.containsKey(b[i])) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1, 2, 32}; int b[] = {10, 20, 30, 4}, v = 42;
		System.out.println(" Value for SumofTwoArray: "+ sumOfTwo(a, b, v));
	}

}
