package AlgorithmDSLeetCode;

public class BinarySearch {

	// Input is pre sorted
	// Beak into two halfs and search into it and again break.

	public boolean binarySearch(int[] arr, int value)

	{
		int low = 0;
		int high = arr.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (value == arr[mid]) {
				return true;
			} else if (value < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return false;

	}

	public static void main(String[] args) {

		BinarySearch bs = new BinarySearch();

		int[] myList = { 1, 5, 7, 8, 14, 16, 18, 20,1000 };

		boolean result = bs.binarySearch(myList, 5);

		System.out.println("value found : " + result);

	}
}

