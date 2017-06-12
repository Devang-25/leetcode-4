package com.codefights;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstDuplicate {

	static int firstDuplicate(int[] a) {
		Map<Integer, Integer> dupMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (dupMap.containsKey(a[i]) && dupMap.get(a[i]) == 0) {
				dupMap.put(a[i], i);
			} else if (!dupMap.containsKey(a[i]))
				dupMap.put(a[i], 0);
		}
		// int minKey=0,minValue=0,value =0;

		System.out.println(dupMap);
		int minValue = Integer.MAX_VALUE, minKey = -1;
		for (Integer key : dupMap.keySet()) {
			int value = dupMap.get(key);
			//System.out.println("value " + value + " key " + key + " minValue " + minValue);
			if (value < minValue && value != 0) {
				minValue = value;
				minKey = key;
			}
		}
		if (minValue != 0 && minValue != Integer.MAX_VALUE)
			return minKey;
		else
			return -1;
	}

	static int printFirstRepeatingNeg(int a[]) {
		int i;

		for (i = 0; i < a.length; i++) {

			if (a[Math.abs(a[i])-1] >= 0){
				a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
				System.out.println("a[Math.abs(a[i])-1] " + a[Math.abs(a[i])-1]+" (i) "+ (i));
			}
			else
				return Math.abs(a[i]);
		}

		return -1;
	}
	
	
	static int printRepeatingMod(int a[]) {
		//int i;

		System.out.print("Array BEFORE :");
	    for (int i = 0; i < a.length; i++)
	    {
	    	System.out.print(a[i]+" ");
	    }
	    System.out.println("");
		// First check all the values that are
	    // present in an array then go to that
	    // values as indexes and increment by
	    // the size of array
	    for (int i = 0; i < a.length; i++)
	    {
	        int index = a[i] % a.length;
	        System.out.println("BEFORE a[index] " + a[index]+" index "+ index);
	        a[index] += a.length;
	        System.out.println("AFTER a[index] " + a[index]+" index "+ index);
	        
	    }
	    System.out.print("Array AFTER:");
	    for (int i = 0; i < a.length; i++)
	    {
	    	System.out.print(a[i]+" ");
	    }

	    System.out.println("");
	    for (int i = 0; i < a.length; i++)
	    {
	        if ((a[i]/a.length) > 1)
	            return i;
	    }

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,4, 3, 5,3,2, 1 };
		System.out.println("firstDuplicate with Map " + firstDuplicate(a));
		//System.out.println("printFirstRepeatingNeg with Array Neg " + printFirstRepeatingNeg(a));
		System.out.println("printRepeatingMod with Array Mod " + printRepeatingMod(a));

	}

}
