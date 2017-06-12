package AlgorithmDSLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNonRepeating {
	static public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;
		
		int subStringCount = 0, duplicatePosition = -1;
		//boolean flag=false;
		Map<Character, Integer> charMap = new HashMap<>();
		int i=0;
		while(i<s.length()) {
			if (!charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i),i);
				subStringCount = Math.max(subStringCount, i-duplicatePosition);
				i++;
			}
				
			else {
				// this flag is for those conditions where there are no duplicates.
				//flag=true;
				duplicatePosition=Math.max(charMap.put(s.charAt(i),i),duplicatePosition);
				subStringCount = Math.max(subStringCount, i-duplicatePosition);
				i++;
			}

		}
		return subStringCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring("abc"));
	}

}
