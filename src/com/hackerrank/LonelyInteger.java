package com.hackerrank;
import java.util.*;

public class LonelyInteger {
     private static int lonelyInteger(int[] a) {
    	 
    	 Map<Integer,Integer> uniqueMap = new HashMap<>();
    	 
    	 for (int i = 0; i < a.length; i++) {
    		 if(uniqueMap.containsKey(a[i])) uniqueMap.put(a[i], uniqueMap.get(a[i])+1); 
    		 else {
    			 uniqueMap.put(a[i], 1); 
			}
			
		}
        return uniqueMap.keySet().stream().filter(s-> uniqueMap.get(s).equals(1)).reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}
