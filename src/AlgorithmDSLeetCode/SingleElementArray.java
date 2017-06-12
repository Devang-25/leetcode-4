package AlgorithmDSLeetCode;

public class SingleElementArray {

	public int singleNonDuplicate(int[] nums) {

		if (nums.length != 0) {
			boolean temp = true;
			for (int i = 0; i < nums.length - 2; i=i+2) {
				if (nums[i] != nums[i + 1]) {
					return nums[i];
				}
			}
		}

		return nums[nums.length - 1];

	}
}
