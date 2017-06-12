package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class DistributedCandies {

	static public int distributeCandies(int[] candies) {
		
		HashSet<Integer> answer = new HashSet(Arrays.stream( candies ).boxed().collect( Collectors.toList() ));
		
		return answer.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,2,2,3,3};
		System.out.println(distributeCandies(input));
	}

}
