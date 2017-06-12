package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	static public boolean wordBreak(String s, List<String> wordDict) {

		int charPosition = 0,  wordPosition = 0;

		List<String> wordList = new ArrayList<>();

		
		while (wordDict.size()!=0) {
			for (int i=0; i < wordDict.size(); i++) {
				//System.out.println(i+" "+charPosition+" wordDict.get(i) "+wordDict.get(i));
				if (s.indexOf(wordDict.get(i), charPosition) > -1) {
					wordList.add(wordDict.get(i));
					charPosition += wordDict.get(i).length();
					if(charPosition==s.length()){
						System.out.println(wordList);return true;
					}
				}
				else{
					wordDict.remove(i);
				}
			}
		}
		//System.out.println(wordDict);
		//System.out.println(wordList);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordDict = new ArrayList<>();
		//men, mentor, torment, man
//		wordDict.add("men");
//		wordDict.add("mentor");
//		wordDict.add("torment");
//		wordDict.add("man");
//		wordDict.add("manchod");
//		wordDict.add("buttchod");
//		wordDict.add("manly");
//		wordDict.add("mk");
//		System.out.println(wordBreak("mentorman", wordDict));
		
		int n=11;
        int count=0;
        for(int i=1;i<=32;i++){
           count+=n&1;
           n = n >>1;
        }
        
        System.out.println(count);
		//System.out.println(0^1^2^4^3^1^4^2^1^3^4^3^2);
	}

}
