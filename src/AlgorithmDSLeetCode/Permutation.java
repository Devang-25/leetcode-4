package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
	
	public static List<List<Integer>> permuteDFS (int[] nums) {
		long startTime = System.nanoTime();
	    List<List<Integer>> results = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
	        return results;
	    }
	    List<Integer> result = new ArrayList<>();
	    dfs(nums, results, result);
	    long endTime = System.nanoTime();
		System.out.println("Took permuteDFS "+(endTime - startTime) + " ns"); 
	    return results;
	}

	public static void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
	    if (nums.length == result.size()) {
	        List<Integer> temp = new ArrayList<>(result);
	        results.add(temp);
	    }        
	    for (int i=0; i<nums.length; i++) {
	        if (!result.contains(nums[i])) {
	            result.add(nums[i]);
	            dfs(nums, results, result);
	            result.remove(result.size() - 1);
	        }
	    }
	}

	public static List<ArrayList<Integer>> permute(int[] nums) {
		
		
		long startTime = System.nanoTime();

		if (nums.length <= 1)
			return null;
		else {
			List<ArrayList<Integer>> permuteList = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < nums.length; i++) {
				 System.out.println("Calling arrayTraversalAscending for nums[i] " + nums[i] + " and i " + i);
				 permuteList.addAll(arrayTraversalAscending(nums, nums[i],i));
				//System.out.println("Calling arrayTraversalDescending for nums[i] " + nums[i] + " and i " + i);
				//permuteList.addAll(arrayTraversalDescending(nums, nums[i], i));
			}
			// System.out.println("in the method output:" + permuteList);
			
			long endTime = System.nanoTime();
			System.out.println("Took permute "+(endTime - startTime) + " ns"); 
			return permuteList;
		}
	}

public static List<List<Integer>> permuteLinked(int[] nums) {
	long startTime = System.nanoTime();
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    res.add(new ArrayList<Integer>());
    for (int n : nums) {
        int size = res.size();
        for (; size > 0; size--) {
            List<Integer> r = res.pollFirst();
            for (int i = 0; i <= r.size(); i++) {
                List<Integer> t = new ArrayList<Integer>(r);
                t.add(i, n);
                res.add(t);
            }
        }
    }
    long endTime = System.nanoTime();
	System.out.println("Took permuteLinked "+(endTime - startTime) + " ns");
    return res;}
	private static List<ArrayList<Integer>> arrayTraversalAscending(int nums[], int num, int position) {

		List<ArrayList<Integer>> permuteFinal = new ArrayList<ArrayList<Integer>>();

		int count1 = 0, count = 0, x = position, position1 = position;
		while (count < nums.length - 1) {
			ArrayList<Integer> permuteTemp = new ArrayList<>();
			permuteTemp.add(num);
			while (count1 < nums.length) {
				if (x != position) {
					permuteTemp.add(nums[x]);
					x = cyclicCount(x, nums.length - 1);

				} else {
					x = cyclicCount(x, nums.length - 1);

				}
				count1++;
			}

			++count;
//			System.out.println("BEFORE outer permuteTemp " + permuteTemp + " x " + x + " position1 " + position1
//					+ " count " + count + "outer temp permuteFinal " + permuteTemp);
			position1 = cyclicCount(position1, nums.length - 1);
			x = cyclicCount(position1, nums.length - 1);
			count1 = 0;
			permuteFinal.add(permuteTemp);
//			System.out.println("outer permuteTemp " + permuteTemp + " x " + x + " position1 " + position1 + " count "
//					+ count + "outer temp permuteFinal " + permuteTemp);
		}
		System.out.println("hello permuteFinal: " + permuteFinal);
		return permuteFinal;

	}

	private static List<ArrayList<Integer>> arrayTraversalDescending(int nums[], int num, int position) {

		List<ArrayList<Integer>> permuteFinal = new ArrayList<ArrayList<Integer>>();

		int count1 = 0, count = 0, x = nums.length - 1, position1 = nums.length - 1;
		x = position; position1 = position;
		while (count < nums.length - 1) {
			ArrayList<Integer> permuteTemp = new ArrayList<>();
			permuteTemp.add(num);
			while (count1 < nums.length) {
				if (x != position) {
					permuteTemp.add(nums[x]);
					x = revserCyclicCount(x, nums.length - 1);

				} else {
					x = revserCyclicCount(x, nums.length - 1);

				}
				count1++;
			}

			++count;
			System.out.println("BEFORE outer permuteTemp " + permuteTemp + " x " + x + " position1 " + position1
					+ " count " + count + "outer temp permuteFinal " + permuteTemp);
			position1 = revserCyclicCount(position1, nums.length - 1);
			x = revserCyclicCount(x, nums.length - 1);
			x = position1;
			count1 = 0;
			permuteFinal.add(permuteTemp);
			System.out.println("AFTER outer permuteTemp " + permuteTemp + " x " + x + " position1 " + position1
					+ " count " + count + "outer temp permuteFinal " + permuteTemp);
		}
		//System.out.println("hello permuteFinal: " + permuteFinal);
		return permuteFinal;

	}

	private static int cyclicCount(int x, int length) {
		if (x == length) {
			// System.out.println("cyclic x " +0);
			return 0;
		} else {
			// System.out.println("cyclic x " +x++);
			return ++x;
		}
	}

	private static int revserCyclicCount(int x, int length) {
		if (x == 0)
			return length;
		else
			return --x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sample[] = { 1, 2, 3 ,4,5,6};
		//System.out.println("sample output:" + permute(sample));
		//System.out.println("sample output:" + permuteLinked(sample));
		System.out.println("sample output:" + permuteDFS(sample));
	}

}
