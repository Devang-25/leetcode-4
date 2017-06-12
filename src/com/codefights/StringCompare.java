package com.codefights;

import java.util.HashMap;
import java.util.Map;

public class StringCompare {

	static int strstr(String s, String x) {
		long startTime = System.nanoTime();
		if (s.length() < x.length() || x.length() == 0 || s.length() == 0) {
			long endTime = System.nanoTime();
			System.out.println("Took strstr " + (endTime - startTime) / 1000 + " micros");
			return -1;

		} else if (s.length() == x.length()) {
			long endTime = System.nanoTime();
			System.out.println("Took strstr " + (endTime - startTime) / 1000 + " micros");
			return s.equals(x) ? 0 : -1;
		} else {
			char[] sChArr = s.toCharArray(), xChArr = x.toCharArray();
			boolean compareFlag = false, compareFlagValid = false;
			int sIndex = 0;

			while (sIndex + xChArr.length - 1 < sChArr.length) {
				if (xChArr[0] == sChArr[sIndex]) {
					if ( s.substring(sIndex, sIndex + xChArr.length).equals(x) ){
						long endTime = System.nanoTime();
						System.out.println("Took strstr " + (endTime - startTime) / 1000 + " micros");
						return sIndex;
					}
					else
					{
						System.out.println(s.substring(sIndex, sIndex + xChArr.length ) +" sIndex "+ sIndex+ " x string is "+ x);
						sIndex++;
					}
				} else {
					sIndex++;
				}

			}
			long endTime = System.nanoTime();
			System.out.println("Took strstr " + (endTime - startTime) / 1000 + " micros");
			return -1;
		}

	}
	
	static int strstrBoyer(String s, String x) {
		
		long startTime = System.nanoTime();
		char[] text = s.toCharArray(), pattern = x.toCharArray();
		int n = text.length,m=pattern.length;
		if (m == 0) {
			long endTime = System.nanoTime();
			System.out.println("Took strstr Boyer  " + (endTime - startTime) / 1000 + " micros");
			return 0;
		}
		Map<Character,Integer> last = new HashMap<>();
		for (int i=0; i < n; i++)
			last.put(text[i], -1);
		for (int k=0; k < m; k++)
			last.put(pattern[k], k); 
		int i = m-1;
		int k = m-1;
		while (i < n) {
			if (text[i] == pattern[k]) {
				if (k == 0) {
					long endTime = System.nanoTime();
					System.out.println("Took strstr Boyer " + (endTime - startTime) / 1000 + " micros");
					return i;
				}
				i--;k--;
			}
			else{
				i+=m- Math.min(k, 1+ last.get(text[i]));
				k=m-1;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Took strstr Boyer " + (endTime - startTime) / 1000 + " micros");
		
		return -1;
	}
	
static int strstrindexOf(String s, String x) {
		
		long startTime = System.nanoTime();
		int pos = s.indexOf(x);
		long endTime = System.nanoTime();
		System.out.println("Took strstr Index of Java Algorithm  " + (endTime - startTime) / 1000 + " micros "+ " length of s "+s.length()+ " length of x "+x.length() );
		return pos;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefghabcdefghijflgjfdlgklfdjgkfljlfdjglkfdjgkldfgjkljfkljfkldjgjfjlfdgjkfldgjkljfljfdlgjkfdlgjkfldgjfkdlgjfdlgjklfdgjfdklgjfdklgjfkljfldkgjkldfgjlkfdjglkfjlkdfgjlfkdjgeroitreoptiopreitporeitpejfsdsprewj;fjsd;fljgr;jdlkdjgdl;fjd;gjdf;gjdfgkjdfg;jdf;gjdf;ljgfd;jfl;ksjldjgdflkjglkdjgdlkgjgkljklfjslkfjlkjklfjkljlkgjfjdslkjdkljkdljkldjdkljdjjjfdklgjfdklgfjdfdgkljldjfdgkljdfdfkgjdf";
		String x = "slkjdkljkdljkldjdklggjfdklgjfdlkgjdffkdljlkjklfgjdflkgjflkfjdkljdkflgjkljfdklgjfkdlgjlkfdgjlfgjfjlddgdfljfkljfdklgjfdgkljflkdjdfgklj";

		System.out.println("First Occuerence of x in s :" + strstr(s, x));
		System.out.println("First Occuerence of x in s for Boyer Algorithm :" + strstrBoyer(s, x));
		System.out.println("First Occuerence of x in s for Index of Java Algorithm :" + strstrindexOf(s, x));

	}

}
