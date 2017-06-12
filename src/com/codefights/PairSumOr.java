package com.codefights;

public class PairSumOr {

	static long pairSumOr(int[] arr) {
		if (arr.length == 0)
			return 0;
		else if (arr.length == 1)
			return arr[0];
		else {
			long pairSumOr = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					pairSumOr += arr[i] | arr[j];
				}
			}
			return pairSumOr;
		}
	}
	// Returns value of "arr[0] & arr[1] + arr[0] & arr[2] + 
	// ... arr[i] & arr[j] + ..... arr[n-2] & arr[n-1]"
	static long pairSumOrBit(int arr[])
	{
	    long ans = 0;  // Initialize result
	 
	    // Traverse over all bits
	    for (long i = 0; i < 32; i++)
	    {
	        // Count number of elements with i'th bit set
	        long k = 0,arrLength = arr.length;  // Initialize the count
	        for (int j = 0; j < arr.length; j++)
	        {	
	        	if( ((arr[j]) & (1 << i)) !=0)
	                k++;
	        }
	        // There are k set bits, means k(k-1)/2 pairs.
	        // Every pair adds 2^i to the answer. Therefore,
	        // we add "2^i * [k*(k-1)/2]" to the answer.
	        
	        ans += (arrLength-k)<=1L ? (1L<<i) * (arrLength*(arrLength-1L)/2L): (1L<<i) * ( (arrLength*(arrLength-1L)/2L)-(arrLength-k)*(arrLength-k-1L)/2L)  ;
		    System.out.println("ans: " + (ans));
	    }
	 
	    return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7, 2147483647 };

		System.out.println(pairSumOr(arr));
		System.out.println(pairSumOrBit(arr));
		
		//System.out.println(1073742142L + 10L *536870912 );

	}

}
