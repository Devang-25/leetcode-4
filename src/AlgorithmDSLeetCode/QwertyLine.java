package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QwertyLine {

	
    public static String[] findWords(String[] words) {
        Set row1 = new HashSet(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set row2 = new HashSet(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set row3 = new HashSet(Arrays.asList('z','x','c','v','b','n','m'));
        int count1=0,count2=0,count3 =0;
        String[] res=null;
        ArrayList<String> result = new ArrayList();
        for(int i=0;i<words.length;i++){
            char[] word = words[i].toLowerCase().toCharArray();
            int count =word.length;
            for(char ch:word){
                if (row1.contains(ch)) count1++;
                if(row2.contains(ch)) count2++;
                if(row3.contains(ch)) count3++;
                
            }
            if(count1==count||count2==count||count3==count){
            	//System.out.println(word.toString());
            	result.add(String.copyValueOf(word));
            }
        }
        
       //result.stream().forEach(System.out::println);
        String[] resultString = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
        	resultString[i] = result.get(i);
        }
        return resultString;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method st
		String[] input = {"Hello","Alaska","Dad","Peace"};
		System.out.println(Arrays.toString(findWords(input)));
	}

}
