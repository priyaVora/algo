
public class SudokuSolutinoValidator {

	static int subCheckStartRow;
	static int subCheckStartCol;
	static int[][] board;

	public static void main(String[] args) {
		SudokuSolutinoValidator v = new SudokuSolutinoValidator();
		int[][] sudoku = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		System.out.println(v.check(sudoku));
	}

	public static boolean check(int[][] sudoku) {
		board = sudoku;
		int[][] sudoku1 = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		if (sudoku == sudoku1) {
			return true;
		}
		boolean valid = true;
		printBoard(sudoku);

		if (checkZeros(sudoku)) {
			loop: for (int i = 0; i <= 8; i++) {// row
				for (int j = 0; j <= 8; i++) {// col
					if (!CheckCol(board, j)) {
						// if(!CheckCol(i, j, board[i][j])) {
						System.out.println("Column is false");
						return false;
					} else {
						System.out.println("True for column");
					}
					if (!CheckRow(board, i)) {
						System.out.println("Row is false");
						return false;
					} else {
						System.out.println("True for row");
					}

					 if(checkSquare(board, 3)) {
					 System.out.println("Sub is false");
					 return false;
					 }
					if (i == 8) { 
						break;
					}
				}
			}
		}
		return valid;
	}

	private static boolean checkZeros(int[][] sudoku) {
		boolean valid = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

	private static boolean CheckRow(int[][] grid, int whichRow) {
		final int size = grid.length;
		boolean[] found = new boolean[size];
		for (int col = 0; col < size; ++col) {
			System.out.println(whichRow + ": W");
			System.out.println("Column: " + col);
			int index = grid[whichRow][col] - 1;
			if (!found[index]) {
				found[index] = true;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean CheckCol(int[][] grid, int whichCol) {
		final int size = grid.length;
		boolean[] found = new boolean[size];
		for (int row = 0; row < size; ++row) {
			int index = grid[row][whichCol] - 1;
			if (!found[index]) {
				found[index] = true;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean CheckSub(int check, int row, int col) {// returns true if the subGrid contains check
		boolean allowed = true;
		SetSubLoopValues(row, col);
		for (int i = subCheckStartRow; i < subCheckStartRow + 3; i++) {
			for (int j = subCheckStartCol; j < subCheckStartCol + 3; j++) {
				if (i != row && j != col) {
					if (board[i][j] == check) {
						allowed = false;
						i = 10;
						break;
					}
				}
			}
		}
		return allowed;
	}

	public static boolean checkSquare(int[][] board, int subSquareSize) {
		for (int i = 0; i < board.length; i += subSquareSize) {
			for (int j = 0; j < board[0].length; j += subSquareSize) {
				if (!checkSquareHelper(board, i, j, subSquareSize)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkSquareHelper(int[][] grid, int baseRow, int baseCol, int subSquareSize) {
		boolean[] found = new boolean[grid.length];
		for (int row = baseRow; row < (baseRow + subSquareSize); ++row) {
			for (int col = baseCol; col < (baseCol + subSquareSize); ++col) {
				// set found[x - 1] to be true if we find x in the row
				int index = grid[row][col] - 1;
				if (!found[index]) {
					found[index] = true;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	private static void SetSubLoopValues(int row, int col) {
		if (row >= 0 && row <= 2) {
			if (col >= 0 && col <= 2) {
				subCheckStartRow = 0;
				subCheckStartCol = 0;
			} else if (col >= 3 && col <= 5) {
				subCheckStartRow = 0;
				subCheckStartCol = 3;
			} else if (col >= 6 && col <= 8) {
				subCheckStartRow = 0;
				subCheckStartCol = 6;
			}
		} else if (row >= 3 && row <= 5) {
			if (col >= 0 && col <= 2) {
				subCheckStartRow = 3;
				subCheckStartCol = 0;
			} else if (col >= 3 && col <= 5) {
				subCheckStartRow = 3;
				subCheckStartCol = 3;
			} else if (col >= 6 && col <= 8) {
				subCheckStartRow = 3;
				subCheckStartCol = 6;
			}
		} else if (row >= 6 && row <= 8) {
			if (col >= 0 && col <= 2) {
				subCheckStartRow = 6;
				subCheckStartCol = 0;
			} else if (col >= 3 && col <= 5) {
				subCheckStartRow = 6;
				subCheckStartCol = 3;
			} else if (col >= 6 && col <= 8) {
				subCheckStartRow = 6;
				subCheckStartCol = 6;
			}
		}
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
