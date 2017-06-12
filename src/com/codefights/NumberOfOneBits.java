package com.codefights;

public class NumberOfOneBits {

	static int numberOf1Bits(int n) {
		
		if(n<2)
			return n;
		else{
			int dividend=n,numberOf1Bits=1;
			while (dividend > 1) {
				numberOf1Bits+=dividend%2;
				dividend/=2;
			}
			return numberOf1Bits;
		}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Output for numberOf1Bits "+numberOf1Bits(28732358));
	}

}
