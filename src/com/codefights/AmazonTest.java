package com.codefights;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest {

		// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
		public static int totalScore(String[] blocks, int n)
		{
		    
			int finalScore = 0,prevScore1 = 0,prevScore=0,lastScore =0;
		    if(n==0){
		        return 0;
		    }
		    else if(n==1){
		        if(blocks[0].charAt(0)=='X'||blocks[0].charAt(0)=='+'||blocks[0].charAt(0)=='Z') 
		        finalScore= 0;
		        else finalScore=Integer.parseInt(blocks[0]);
		        return finalScore;
		    }
		    else{
		    	
		    	List<Integer> intList = new ArrayList<>();
		    	
		    for (int count = 0;count<n;count++){
//		        if(count==2) {
//		            
//		            if(blocks[0].charAt(0)=='X'||blocks[0].charAt(0)=='+'||blocks[0].charAt(0)=='Z'){
//		                prevScore1=0;
//		            }
//		            else prevScore1=Integer.parseInt(blocks[0]);
//		            
//		            if(blocks[1].charAt(0)=='X'||blocks[1].charAt(0)=='+'||blocks[1].charAt(0)=='Z'){
//		                prevScore=0;
//		            }
//		            else prevScore=Integer.parseInt(blocks[1]);
//		            
//		        }
		        if(count==1) {
		            if(blocks[0].charAt(0)=='X'||blocks[0].charAt(0)=='+'||blocks[0].charAt(0)=='Z'){
		                prevScore=0;
		            }
		            else prevScore=Integer.parseInt(blocks[0]);
		        }
		       
		        if(blocks[count].charAt(0)=='X') {
		        	lastScore=2 * prevScore;
		            prevScore1=prevScore;
		            prevScore=lastScore;
		            finalScore+=lastScore;
		        }
		        else if(blocks[count].charAt(0)=='+') {
		            lastScore=prevScore1 + prevScore;
		            prevScore1=prevScore;
		            prevScore=lastScore;
		            finalScore+=lastScore;
		        }
		        else if(blocks[count].charAt(0)=='Z') {
		            finalScore-=lastScore;
		            prevScore1=prevScore;
		            prevScore=lastScore;
		        }
		        else {
		            lastScore=Integer.parseInt(blocks[count]); 
		            finalScore+=lastScore;
		        }
		        
		        
		        System.out.println("lastScore: "+lastScore+" finalScore:"+finalScore+" blocks[count] :"+blocks[count]);
		        
		        System.out.println("prevScore1: "+prevScore1+" prevScore:"+prevScore);
		    }
		    }
		    return finalScore;
		}
		// METHOD SIGNATURE ENDS
		
		public static int totalScoreList(String[] blocks, int n)
		{
		    
			int finalScore = 0,prevScore1 = 0,prevScore=0,lastScore =0;
		    if(n==0){
		        return 0;
		    }
		    else if(n==1){
		        if(blocks[0].charAt(0)=='X'||blocks[0].charAt(0)=='+'||blocks[0].charAt(0)=='Z') 
		        finalScore= 0;
		        else finalScore=Integer.parseInt(blocks[0]);
		        return finalScore;
		    }
		    else{
		    	//This will hold all the recent values
		    	// A List(Memory) function was opted since there could be a consecutive set of Z in the input
		    	//String thereby leading to choose a memory of O(n) for this problem.
		    	List<Integer> intList = new ArrayList<>();
		    	
		    for (int count = 0;count<n;count++){
		       
		    	if(blocks[count].charAt(0)=='X'||blocks[count].charAt(0)=='+'||blocks[count].charAt(0)=='Z') {
		        if(blocks[count].charAt(0)=='X') {
		        	if(intList.size() >=1){
		            finalScore=finalScore +  2 * intList.get(intList.size()-1);
		            intList.add(2 * intList.get(intList.size()-1));
		        	}
		        }
		        else if(blocks[count].charAt(0)=='+') {
		        	if(intList.size() >=1){
		        	finalScore= finalScore + intList.get(intList.size()-1) + intList.get(intList.size()-2);
		        	intList.add(intList.get(intList.size()-1) + intList.get(intList.size()-2));
		        	}
		        }
		        else if(blocks[count].charAt(0)=='Z') {
		        	
		        	if(intList.size() >=1){
		        		
		        	finalScore=finalScore - intList.get(intList.size()-1);
		        	System.out.println("IN Z "+ count+"  intList.get(intList.size()-1) :"+intList.get(intList.size()-1)+" intList.size()-1:"+(intList.size()-1));
		        	intList.remove(intList.size()-1);
		        	System.out.println("IN Z "+ count+"  after remove");
		        	
		        	}
		        }
		    	}
		        else {		        	
		        	intList.add(Integer.parseInt(blocks[count]));
		            finalScore=finalScore + intList.get(intList.size()-1);
		        }
		        
		        
		        System.out.println("lastScore: "+(intList.size()-1)+" finalScore:"+finalScore+" blocks[count] :"+blocks[count]+" value at "
		        		+ "intList.size()-1: "+intList.get(intList.size()-1));
		        
		        
		    }
		    }
		    return finalScore;
		}
	public static void main(String[] args) {
		
		String[] input = {"1","Z","Z","9","+","+"};
		System.out.println(totalScoreList(input,8));
		
	}

}
