package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ContactSolution {

	private static List<String> list = new ArrayList<>();
	private static List<String> listFinal = new ArrayList<>();
	static public void add(String s) {
		//System.out.println(" added :"+s);
		list.add(s);
	}

	static public void find(String pattern) {
		Integer patternMatch = 0;

		patternMatch = (int) list.stream().filter(l -> l.indexOf(pattern) > -1).count();
		//System.out.println(" patternMatch in find :"+patternMatch);
		listFinal.add(patternMatch.toString());
	}

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numQueries = Integer.parseInt(br.readLine());
		  
		String[] nextString ;
		//String query = new String();
		for (int i = 1; i <= numQueries; i++) {
			nextString = br.readLine().split(" ");
			if (nextString[0].equals("add"))
				add(nextString[1]);
			else if (nextString[0].equals("find"))
				find(nextString[1]);
			else {
				System.out.println("A wrong input.. Please provide a correct one.. like find... or add ...");
				continue;
			}
		}
		
		listFinal.stream().forEach(System.out::println);
		
	}
}