package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum2(candidates, target, results, result, 0, 0);
		return results;
		
		
    }
	
	static void combinationSum2(int[]candidates, int target, List<List<Integer>> results, List<Integer> result,int tempSum,
			int currentIndex){
	
	if(target>tempSum){
		for (int i = currentIndex; i < candidates.length ;i++) {
			if (i > currentIndex && candidates[i] == candidates[i-1]) continue;
			result.add(candidates[i]);
			combinationSum2(candidates, target, results, result,tempSum+candidates[i],i+1);
			result.remove(result.size() - 1);
		}
	}
	else if(tempSum==target){
		List<Integer> temp = new ArrayList<>(result);
		results.add(temp);
	}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int[] input = {10, 1, 2, 7, 6, 1,5, 5};
		System.out.println(combinationSum2(input, 8));

	}

}
