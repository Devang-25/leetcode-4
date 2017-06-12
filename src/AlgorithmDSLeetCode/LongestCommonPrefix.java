package AlgorithmDSLeetCode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];
		else {
			int breakflag = 0, charPosition = 0;
			for (int j = 0; j < strs.length; j++) {

				if (strs[j].length() == 0)
					return "";

			}
			
			String shortest = Arrays.asList(strs).stream()
			        .sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1)
			        .findFirst().get();

			for (int i = 0; i < shortest.length(); i++) {

				char tempChar = strs[0].charAt(i);
				for (int j = 0; j < strs.length; j++) {
					// String tempString = strs[j];
					if (strs[j].charAt(i) != tempChar) {
						breakflag = 1;
						break;
					}
				}
				if (breakflag == 1)
					break;
				charPosition = i+1;
				
			}
			if (charPosition == 0 && breakflag == 1 )
				return "";
			return strs[0].substring(0, charPosition);
		}
	}

}
