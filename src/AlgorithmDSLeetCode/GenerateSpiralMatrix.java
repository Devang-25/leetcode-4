package AlgorithmDSLeetCode;

import java.util.Arrays;

public class GenerateSpiralMatrix {

	public static int[][] generateMatrix(int n) {
		
		if(n==0) {

			int[][] spiralMatrix = new int[n][n];
			return spiralMatrix;
		
		}
		else if(n==1) {
			
			int[][] spiralMatrix = new int[n][n];
			spiralMatrix[0][0]=1;
			return spiralMatrix;
		}
		else{

		int minRow = -1, maxRow = n, minCol = -1, maxCol = n;
		int rowPointer = minRow + 1, colPointer = minCol + 1, value = 0;
		boolean horizontalFwdKey = true, verticalDownKey = false, horizontalBackKey = false, verticalUpKey = false;

		int[][] spiralMatrix = new int[n][n];
		spiralMatrix[rowPointer][colPointer] = ++value;
		//System.out.println("OUT rowPointer:" + rowPointer + " colPointer:" + colPointer + " value:" + value + " minCol:"+ minCol+ " maxCol:"+ maxCol + " minRow:"+ minRow+ " maxRow:"+ maxRow);
		for (int i = 0; i < (n * n - 1); i++) {
			// spiralMatrix[rowPointer][colPointer] = ++value;
			if (horizontalFwdKey) {

				spiralMatrix[rowPointer][++colPointer] = ++value;
				if(colPointer == (maxCol - 1)){
					minRow++;horizontalFwdKey=false;verticalDownKey=true;
				}
				//System.out.println("FIRST rowPointer:" + rowPointer + " colPointer:" + colPointer + " value:" + value + " minCol:"+ minCol+ " maxCol:"+ maxCol + " minRow:"+ minRow+ " maxRow:"+ maxRow);

			} else if (verticalDownKey) {
				spiralMatrix[++rowPointer][colPointer] = ++value;
				if(rowPointer == (maxRow - 1)){
					maxCol--;verticalDownKey=false;horizontalBackKey=true;
				}
				//System.out.println("SECOND rowPointer:" + rowPointer + " colPointer:" + colPointer + " value:" + value + " minCol:"+ minCol+ " maxCol:"+ maxCol + " minRow:"+ minRow+ " maxRow:"+ maxRow);

			} else if (horizontalBackKey) {
				spiralMatrix[rowPointer][--colPointer] = ++value;
				if(colPointer == (minCol + 1)){
					maxRow--;horizontalBackKey=false;verticalUpKey=true;
				}
				//System.out.println("THIRD rowPointer:" + rowPointer + " colPointer:" + colPointer + " value:" + value + " minCol:"+ minCol+ " maxCol:"+ maxCol + " minRow:"+ minRow+ " maxRow:"+ maxRow);

			} else if (verticalUpKey) {
				spiralMatrix[--rowPointer][colPointer] = ++value;
				if(rowPointer == (minRow + 1)){
					minCol++;verticalUpKey=false;horizontalFwdKey=true;
				}
//				System.out
//						.println("FOURTH rowPointer:" + rowPointer + " colPointer:" + colPointer + " value:" + value + " minCol:"+ minCol+ " maxCol:"+ maxCol + " minRow:"+ minRow+ " maxRow:"+ maxRow);

			}
		}

		return spiralMatrix;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(generateMatrix(10)));
	}

}
