package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {
    private static List<String> res = new ArrayList<>();
    static public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return res;
        int len = s.length();
        List<List<Integer>> idx = new ArrayList<List<Integer>>(len + 1);//record each idx of s
        for(int i = 0; i <= len; i++) {
            idx.add(new ArrayList<Integer>());
        }
        idx.get(0).add(0);
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(!idx.get(j).isEmpty() && wordDict.contains(s.substring(j, i))) {
                    idx.get(i).add(j);
                }
            }
        }
        System.out.println(idx);
        if(!idx.get(len).isEmpty()) {
            dfs(idx, s, len, "");
        }
        return res;
    }
    static private void dfs(List<List<Integer>> idx, String s, int curr, String sb) {
        if(curr == 0) {
            res.add(sb.substring(0, sb.length() - 1)); //the last char is a space
            return;
        }
        for(int i : idx.get(curr)) {
            dfs(idx, s, i, s.substring(i, curr) + " " + sb);
        }
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		List<String> inputList = new ArrayList<>();
		inputList.add("cat");
		inputList.add("cats");
		inputList.add("and");
		inputList.add("sand");
		inputList.add("dog");
		System.out.println(wordBreak(s, inputList));
	}

}
