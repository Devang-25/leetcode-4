package com.codefights;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BitsMaxShiftOne {

	 static long[] bits(long[] numbers) {
		 
		 long[] result = new long[numbers.length];
		 for (int i = 0; i < numbers.length; i++) {
			result[i]=Long.parseLong(((Long.toBinaryString(numbers[i]).lastIndexOf('1') != Long.toBinaryString(numbers[i]).indexOf('1'))
					&& Long.toBinaryString(numbers[i]).indexOf('0') < Long.toBinaryString(numbers[i]).lastIndexOf('1')
					&& Long.toBinaryString(numbers[i]).indexOf('0') > -1)
							? bitsHelper(Long.toBinaryString(numbers[i]), Long.toBinaryString(numbers[i]).indexOf('0'),
									Long.toBinaryString(numbers[i]).lastIndexOf('1'), '1', '0')
							: Long.toBinaryString(numbers[i]),2);
			}
		 
		 return result;
	
	 }

	static String bitsHelper(String bitsLong, int zero, int one, char zeroChar, char oneChar) {
		StringBuilder stringBuilder = new StringBuilder(bitsLong);
		stringBuilder.setCharAt(zero, zeroChar);
		stringBuilder.setCharAt(one, oneChar);
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long[] l ={27, 44, 64, 30, 25};
		System.out.println(LongStream.of(bits(l)).mapToObj(Long::toString).collect(Collectors.joining(", ")));
		

	}

}
