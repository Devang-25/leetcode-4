package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> result = new ArrayList<>();
		
		combinationSum(candidates, target, results, result, 0, 0);
		return results;
		
		
    }
	
	static void combinationSum(int[]candidates, int target, List<List<Integer>> results, List<Integer> result,int tempSum,
			int currentIndex){
	
	if(target>tempSum){
		for (int i = currentIndex; i < candidates.length && target >= (tempSum+candidates[i]);i++) {
			result.add(candidates[i]);
			combinationSum(candidates, target, results, result,tempSum+candidates[i],i);
			result.remove(result.size() - 1);
		}
	}
	else if(tempSum==target){
		List<Integer> temp = new ArrayList<>(result);
		results.add(temp);
	}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,6,7};
		System.out.println(combinationSum(input, 7));
	}

}
