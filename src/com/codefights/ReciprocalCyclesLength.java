package com.codefights;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class ReciprocalCyclesLength {

	static long reciprocalCyclesLength(long n) {

		long startTime = System.nanoTime();
		long value = n, countRep = 0, temp = 0;

		if (n == 1) {
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");
			return 0;

		} else {
			while (true) {
				if (value % 2 == 0) {
					value = value / 2;
				} else {
					break;
				}

			}
			// System.out.println("Value after division by 2 of decimal places:
			// " + value);
			while (true) {
				if (value % 5 == 0) {
					value = value / 5;
				} else {
					break;
				}

			}

			System.out.println("Value after division by 2 & 5 of decimal places: " + value + " countRep " + countRep);
			if (value == 1){
				long endTime = System.nanoTime();
				System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");
				return 0;
			}
				
			HashMap<Long,Long> remList = new HashMap<>();

			long valueString = value;

			remList.put(1L,1L);
			value = 10;
			
			while (true) {
				if (value % valueString != value) {
					temp = value / valueString;
					value = value - (temp * valueString);
					if (remList.containsKey(value)) {
						break;
					}
					remList.put(value,value);

					value = 10 * value;

				} else {
					remList.put(value,value);
					value *= 10;
				}

			}
			
			//System.out.println("remList is " + remList);
			System.out.println("From reciprocalNew: n is " + n + " remList size is " + remList.size());
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");
			return remList.size();
//			BigInteger bigDividend = BigInteger.valueOf(10L);
//			System.out.println(bigDividend.toString(10));
//			int power = 1;
//			while (true){
//				bigDividend = bigDividend.subtract(BigInteger.valueOf(1));
//				if(bigDividend.remainder(BigInteger.valueOf(value)) == BigInteger.valueOf(0)){
//					return bigDividend.toString(10).length();
//				}
//				power++;
//				System.out.println("addition: " +bigDividend.toString(10));
//				bigDividend = BigInteger.valueOf(10L).pow(power);
//				System.out.println("Final after loop: " +bigDividend.toString(10));
//			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reciprocalCyclesLength(13L));
	}

}
