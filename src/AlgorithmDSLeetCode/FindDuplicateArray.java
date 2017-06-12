package AlgorithmDSLeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateArray {
	public int findDuplicate(int[] nums) {

		Map<Integer,Integer> dupMap = new HashMap<>();
		
		for (int i=0; i< nums.length;i++){
			if(dupMap.get(nums[i])!=null) return nums[i];
			dupMap.put(nums[i], 1);
		}
		return -1;
	}
	public static void main(String args[]){
		int[] array = {1,3,4,2,4};
		FindDuplicateArray dupArray = new FindDuplicateArray();
		System.out.println(dupArray.findDuplicate(array));
	}

}
