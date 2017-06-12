package com.codefights;

import java.util.Arrays;

public class ChessQueenPosition {

	static String[] chessQueen(String q) {

		int[][] chess = new int[8][8];

		Arrays.fill(chess[0], 0);
		Arrays.fill(chess[1], 0);
		Arrays.fill(chess[2], 0);
		Arrays.fill(chess[3], 0);
		Arrays.fill(chess[4], 0);
		Arrays.fill(chess[5], 0);
		Arrays.fill(chess[6], 0);
		Arrays.fill(chess[7], 0);
		int i = 0;
		for (int rows = 0; rows < 8; rows++) {

			for (int cols = 0; cols < 8; cols++) {
				// Why was this required...
				/**
				 * For Straight Coding
				 */
				if (q.charAt(1) - '1' == rows || (int) (q.charAt(0) - 97) == cols) {
					chess[rows][cols] = 1;
					i++;
				}
				// Why was this required...
				/***
				 * For Diagonal Coding
				 */
				else if (Math.abs(((int) q.charAt(1) - '1' - (char) rows)) == Math
						.abs((int) (q.charAt(0) - 97) - cols)) {
					chess[rows][cols] = 1;
					i++;
				}

			}
		}
		/**
		 * Final output Array
		 */
		String[] result = new String[64 - i];
		i = 0;
		for (int rows = 0; rows < 8; rows++) {
			for (int cols = 0; cols < 8; cols++) {
				if (chess[rows][cols] == 0) {
					result[i] = ((char) (cols + 97) + "" + (rows + 1));
					i++;
				}

			}
		}
		Arrays.sort(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queen = "d4";
		// System.out.println((int) (queen.charAt(0) - 97));
		String[] result = chessQueen(queen);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
