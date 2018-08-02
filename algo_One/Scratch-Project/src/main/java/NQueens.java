
public class NQueens {

	
	public static int moveStart = 0;

	public static void main(String[] args) {
		start(4);
	}

	public static void start(int n) {

		String[][] boardArray = createBoard(n);
		printBoard(boardArray);
		placeQueen(boardArray, 0, 0);
	}

	private static void placeQueen(String[][] boardArray, int starting_X_Position, int starting_Y_Position) {
		System.out.println("Move is about to be made...");
		if (moveStart == 0) {
			boardArray[starting_X_Position][starting_Y_Position] = " Q ";
		} else {
			horizonalScan(boardArray, starting_X_Position, starting_Y_Position);
		}
		moveStart++;
		printBoard(boardArray);
		if (moveStart < 4) {
			placeQueen(boardArray, starting_X_Position, starting_Y_Position);
		}
	}

	private static void horizonalScan(String[][] boardArray, int starting_X_Position, int starting_Y_Position) {
		System.out.println("\nHorizontal Scan will take place...");
	}

	private static void printBoard(String[][] boardArray) {
		System.out.println(" ");
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				System.out.print(" " + boardArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static String[][] createBoard(int n) {
		String[][] boardArray = new String[n][n];
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				boardArray[i][j] = " __";
			}
		}
		return boardArray;
	}
}
