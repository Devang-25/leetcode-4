package com.codefights;

import java.util.ArrayList;
import java.util.List;

public class ReciprocalSolution {

	static int reciprocalHelper(int n, int d) {
		long startTime = System.nanoTime();
		if (n == 1) {
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");

			return 0;
		} else {
			int divisorPosition = d, value = 1;
			int dividend = value * 10, temp = 0;
			List<Integer> digits = new ArrayList<>();
			while (divisorPosition > 0) {
				temp = dividend / n;
				dividend = dividend - (temp * n);
				digits.add(temp);
				// System.out.println("temp "+temp+" dividend "+dividend);
				--divisorPosition;

				if (dividend % n != 0) {
					dividend *= 10;
				} else if (dividend == 0 && divisorPosition > 0) {

					System.out.println("digits of divisor" + digits);
					long endTime = System.nanoTime();
					System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");

					return 0;
				}

			}
			System.out.println("digits of divisor" + digits);
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");

			return digits.get(d - 1);
		}
	}

	static int reciprocal(int n, int d) {

		long startTime = System.nanoTime();
		int value = n, countRep = 0, final_digit, temp = 0;

		if (countRep > d || d <= 1) {
			final_digit = d;

		} else {
			while (true) {
				if (value % 2 == 0) {
					value = value / 2;
					//System.out.println("Value after division by 2 of decimal places: " + value);
					countRep++;
				} else {
					break;
				}

			}
			//System.out.println("Value after division by 2 of decimal places: " + value);
			while (true) {
				if (value % 5 == 0) {
					value = value / 5;
					countRep++;
				} else {
					break;
				}

			}

			System.out.println("Value after division by 5 of decimal places: " + value + " countRep " + countRep);
			int countRep9 = 0;
			List<Integer> remList = new ArrayList<>();
			if (value != 1) {
				int valueString = value;

				remList.add(1);
				value = 10;
				// countRep9++;

				while (true) {
					if (value % valueString != value) {
						temp = value / valueString;
						value = value - (temp * valueString);
						countRep9++;
						//System.out.println("value in loop is " + value + " countRep9 " + countRep9);
						if (remList.contains(value)) {
							break;
						}
						remList.add(value);

						value = 10 * value;

					} else {
						remList.add(value);
						value *= 10;
						countRep9++;
					}

				}
			}
			System.out.println("remList is " + remList);
			System.out.println("From reciprocalNew: n is " + n + " countRep " + countRep + " countRep9 " + countRep9
					+ " remList size is " + remList.size());
			final_digit = countRep9 == 0 ? d
					: (d - countRep) % countRep9 == 0 ? countRep9 +countRep : (d - countRep) % countRep9 + countRep;
			if (final_digit > d)
				final_digit = d;
		}
		System.out.println("final_digit " + final_digit);
		if (n == 1) {
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");
			return 0;
		} else {
			int divisorPosition = final_digit;
			value = 1;
			int dividend = value * 10;
			temp = 0;
			List<Integer> digits = new ArrayList<>();
			while (divisorPosition > 0) {
				temp = dividend / n;
				dividend = dividend - (temp * n);
				digits.add(temp);
				//System.out.println("temp " + temp + " dividend " + dividend + " n " + n);
				--divisorPosition;

				if (dividend % n != 0) {
					dividend *= 10;
				} else if (dividend == 0 && divisorPosition > 0) {

					System.out.println("Actual digits of divisor" + digits);
					long endTime = System.nanoTime();
					System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");

					return 0;
				}

			}
			System.out.println("digits of divisor" + digits);
			long endTime = System.nanoTime();
			System.out.println("Took reciprocal " + (endTime - startTime) / 1000 + " micros");

			return digits.get(final_digit - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(100000%12345);
		int digit = 483209498, n = 97913;
		//System.out.println(reciprocalHelper(n, digit));
		System.out.println(reciprocal(n, digit));
	}

}
