package com.codefights;

import java.util.Arrays;

public class MineSweeper {
	static int[][] minesweeper(boolean[][] matrix) {
		 
		//create a new matrix based on the same size of the initial matrix
		int[][] minesweepAns = new int[matrix.length][matrix[0].length];
		for(int row= 0;row<matrix.length;row++){
			for(int col= 0;col<matrix[0].length;col++){
				minesweepAns[row][col]=minesweeperHelper(matrix, row, col);
			}
		}
		return minesweepAns;
	}
	
	static int  minesweeperHelper(boolean[][] matrix,int row,int col) {
		
		int cellValue = 0;
		
		//row,col+1
		cellValue = (col+1 < matrix[0].length) ? (cellValue + ((matrix[row][col+1]) ? 1 : 0)) : cellValue;
		//row+1,col
		cellValue = (row+1 < matrix.length) ? (cellValue + ((matrix[row+1][col]) ? 1 : 0)) : cellValue;
		//row+1,col+1
		cellValue = (col+1 < matrix[0].length && row+1 < matrix.length) ? (cellValue + ((matrix[row+1][col+1]) ? 1 : 0)) : cellValue;
		//row,col-1
		cellValue = (col-1 >= 0) ? (cellValue + ((matrix[row][col-1]) ? 1 : 0)) : cellValue;
		//row-1,col
		cellValue = (row-1 >= 0) ? (cellValue + ((matrix[row-1][col]) ? 1 : 0)) : cellValue;
		//row-1,col-1
		cellValue = (col-1 >= 0 && row-1 >= 0) ? (cellValue + ((matrix[row-1][col-1]) ? 1 : 0)) : cellValue;
		//row+1,col-1
		cellValue = (col-1 >=0 && row+1 < matrix.length) ? (cellValue + ((matrix[row+1][col-1]) ? 1 : 0)) : cellValue;
		//row-1,col+1
		cellValue = (col+1 < matrix[0].length && row-1 >= 0) ? (cellValue + ((matrix[row-1][col+1]) ? 1 : 0)) : cellValue;
		
		return cellValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] matrix = 
			{{true, false, false},
			{false, true, false},
			{false, false, false}};
		
		System.out.println(" matrix.length "+ matrix.length + " matrix[0].length "+ matrix[0].length);
		
		int[][] ans = minesweeper(matrix);
		
		for(int i = 0; i<ans.length; i++)
		{
		    for(int j = 0; j<ans[0].length; j++)
		    {
		        System.out.print(ans[i][j]+" ");
		    }
		    System.out.println();
		}
		}
	}

