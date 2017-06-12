package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class CombinationList {

	static public List<List<Integer>> combine(int n, int k) {
		long startTime = System.nanoTime();
		int[] combArray = new int[n];
		for (int i = 0; i < n; i++) {
			combArray[i] = i + 1;
		}
		//Arrays.stream(combArray).forEach(System.out::print);
		List<Integer> intCombinationList = new ArrayList<>();
		List<List<Integer>> intFinalCombinationList = new ArrayList<List<Integer>>();

		combineUtil(combArray, k, intCombinationList, 0,n,intFinalCombinationList);
		long endTime = System.nanoTime();
		System.out.println("Took combine "+(endTime - startTime)/1000000 + " ms"); 
		return intFinalCombinationList;
			
	}

	static public void combineUtil(int[] combArray, int k, List<Integer> intCombinationList, int ArrayPosition,
			int n,List<List<Integer>>  intFinalCombinationList) {

		if(intCombinationList.size() == k){
			List<Integer> temp = new ArrayList<>(intCombinationList);
			intFinalCombinationList.add(temp); 
			return;
		}
		for (int i = ArrayPosition; i < n ;i++) {
			if(!intCombinationList.contains(combArray[i])) intCombinationList.add(combArray[i]);
			
			combineUtil(combArray, k, intCombinationList, i+1, n,intFinalCombinationList);
			intCombinationList.remove(intCombinationList.size() - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(6, 4));
	}

}
