import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		int[][] temp = new int[3][3];
		temp[0][0] = 1;
		temp[0][1] = 2;
		temp[0][2] = 3;
		temp[1][0] = 1;
		temp[1][1] = 2;
		temp[1][2] = 2;
		temp[2][0] = 2;
		temp[2][1] = 3;
		temp[2][2] = 2;

		temp = floodFill(temp, 1, 0, 4);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static List<String> checkedPoints = new ArrayList<String>();

	public static int[][] floodFill(int[][] array, int col, int row, int newValue) {
		int numOfCols = array[0].length;
		int numOfRows = array.length;
		int checkValue = array[row][col];
		spotCheck(array, col, row, checkValue, numOfRows, numOfCols, newValue);
		array[row][col] = newValue;
		return array;
	}

	private static void spotCheck(int[][] array, int col, int row, int checkValue, int numOfRows, int numOfCols,
			int newValue) {
		checkedPoints.add(row + "," + col);
		String checkLeft = (row - 1) + "," + col;
		String checkRight = (row + 1) + "," + col;
		String checkUp = row + "," + (col + 1);
		String checkDown = row + "," + (col - 1);
		if (row > 0 && !checkedPoints.contains(checkUp)) {// all items above initial value
			if (array[row - 1][col] == checkValue) {
				array[row - 1][col] = newValue;
				spotCheck(array, col, row - 1, checkValue, numOfRows, numOfCols, newValue);
			}
		}
		if (row < numOfRows - 1 && !checkedPoints.contains(checkDown)) { // all items below initial value
			if (array[row + 1][col] == checkValue) {
				array[row + 1][col] = newValue;
				spotCheck(array, col, row + 1, checkValue, numOfRows, numOfCols, newValue);
			}
		}

		if (col > 0 && !checkedPoints.contains(checkLeft)) { // all items left of initial value
			if (array[row][col - 1] == checkValue) {
				array[row][col - 1] = newValue;
				spotCheck(array, col - 1, row, checkValue, numOfRows, numOfCols, newValue);
			}
		}
		if (col < numOfCols - 1 && !checkedPoints.contains(checkRight)) { // all items right of initial value
			if (array[row][col + 1] == checkValue) {
				array[row][col + 1] = newValue;
				spotCheck(array, col + 1, row, checkValue, numOfRows, numOfCols, newValue);

			}
		}
	}
}
