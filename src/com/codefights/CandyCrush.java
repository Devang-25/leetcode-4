package com.codefights;

public class CandyCrush {

	static boolean candyCrush1(char[][] gameboard) {
		if (gameboard.length < 3 ) {
			 	for (int rows = 0; rows <= gameboard.length - 1; rows++) {
			 		for (int cols = 0; cols <= gameboard[0].length - 3; cols++){
			 			if (gameboard[rows][cols] == gameboard[rows][cols + 2]
							&& gameboard[rows][cols] == gameboard[rows][cols + 1]) {
						return true;
						
					}
				}
			}
		
		return false;
		}
		// for other cases
		else if (gameboard[0].length < 3 ) {
			// rows comparison
			for (int cols = 0; cols <= gameboard[0].length - 1; cols++) {
			for (int rows = 0; rows <= gameboard.length - 3; rows++) {
				if (gameboard[rows][cols] == gameboard[rows + 2][cols]
							&& gameboard[rows][cols] == gameboard[rows + 1][cols]) {
						return true;
					}
				}
			}

			return false;

		}
		
		else {

			for (int cols = 0; cols <= gameboard[0].length - 1; cols++) {
			for (int rows = 0; rows <= gameboard.length - 3; rows++) {
				if (gameboard[rows][cols] == gameboard[rows + 2][cols]
							&& gameboard[rows][cols] == gameboard[rows + 1][cols]) {
						return true;
					}
				}
			}
			 	for (int rows = 0; rows <= gameboard.length - 1; rows++) {
			 		for (int cols = 0; cols <= gameboard[0].length - 3; cols++){
			 			if (gameboard[rows][cols] == gameboard[rows][cols + 2]
							&& gameboard[rows][cols] == gameboard[rows][cols + 1]) {
						return true;
					}
				}
			}
		
		return false;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gameboard = { {'R','B','G','G','G','R','B','O','P','Y'} };
		System.out.println(candyCrush1(gameboard));
	}

}
