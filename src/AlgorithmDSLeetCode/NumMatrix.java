package AlgorithmDSLeetCode;

public class NumMatrix {

private int[][] T;
 public NumMatrix(int[][] matrix) {
        T = matrix;
    }
    
     public int sumRegion(int row1, int col1, int row2, int col2) {
    	int sumRect=0;
        for (int rows = row1;rows<=row2;rows++){
        	 for (int cols = col1;cols<=col2;cols++){
        		 sumRect+=T[rows][cols];
        	 }
        }
        return sumRect;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
				};
		NumMatrix matrix2 = new NumMatrix(matrix);
		System.out.println(matrix2.sumRegion(2, 1, 4, 3));
		System.out.println(matrix2.sumRegion(1, 1, 2, 2));
		System.out.println(matrix2.sumRegion(1, 2, 2, 4));
//		sumRegion(1, 1, 2, 2) -> 11
//		sumRegion(1, 2, 2, 4) -> 12
	}

}
