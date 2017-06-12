package AlgorithmDSLeetCode;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

Show Hint 

 */

public class UglyNumberII {

	public static void primeFactors(int n) {
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}

		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
			System.out.print(n);
	}

	public static long nthUglyNumber(int n) {
		// Print the number of 2s that divide n
		long startTime = System.nanoTime();
		ArrayList<Long> uglyList = new ArrayList<>();
		// Record the distinct prime factors
		//HashSet<Integer> primeFactors = new HashSet<>();

		uglyList.add(1L);
		uglyList.add(2L);
		uglyList.add(3L);
		uglyList.add(4L);
		uglyList.add(5L);
		long listCopy = 0;

		for (long i = 6; i <= n*1000000 ; i++) {
			listCopy=i;
			//System.out.println("before listCopy "+listCopy+" before final member" +uglyList.get(uglyList.size()-1));
			
			while (i % 2 == 0) {
				i /= 2;
			}
			

			if (i > 2) {
				for (int j = 3; j <= 5; j += 2) {
					while (i % j == 0) {
						i /= j;
					}
				}
				//System.out.println("i "+ i);
				if (i<=1) uglyList.add(listCopy);
			}
			else  uglyList.add(listCopy);
			
			i=listCopy;
			//System.out.println("listCopy "+listCopy+" final member" +uglyList.get(uglyList.size()-1));
		}
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		return (long) uglyList.get(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// primeFactors(91);
		System.out.println(nthUglyNumber(1690));
	}

}
