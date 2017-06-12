package com.codefights;

import java.util.HashSet;

public class SudokuValid {
	static boolean sudoku2(char[][] grid) {

		HashSet<Character> gridSet = new HashSet<>();

		// For Row Layout rule
		for (int rows = 0; rows < 9; rows++) {
			gridSet.clear();
			for (int columns = 0; columns < 9; columns++) {
				if (grid[rows][columns] != '.') {
					if (gridSet.contains(grid[rows][columns])) {
						return false;
					} else {
						gridSet.add(grid[rows][columns]);
					}
				}
			}
		}

		// For Column Layout rule
		for (int columns = 0; columns < 9; columns++) {
			gridSet.clear();
			for (int rows = 0; rows < 9; rows++) {
				if (grid[rows][columns] != '.') {
					if (gridSet.contains(grid[rows][columns])) {
						return false;
					} else {
						gridSet.add(grid[rows][columns]);
					}
				}
			}
		}

		// For all 3*3 Sub-Grids 
		for (int sub_grid_row = 0; sub_grid_row < 9; sub_grid_row += 3) {

			for (int sub_grid_cols = 0; sub_grid_cols < 9; sub_grid_cols += 3) {
				gridSet.clear();
				for (int columns = sub_grid_cols; columns < sub_grid_cols + 3; columns++) {

					for (int rows = sub_grid_row; rows < sub_grid_row + 3; rows++) {
						if (grid[rows][columns] != '.') {
							if (gridSet.contains(grid[rows][columns])) {
								return false;
							} else {
								gridSet.add(grid[rows][columns]);
							}
						}
					}
				}
			}
		}

		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
