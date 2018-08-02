package vora.priya.nqueens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueensTester {
	private static Integer upperBound;
	private static Integer currentNumberOfSteps = 0;
	private static Integer solutionCount = 0;

	public static void main(String[] args) {
		
		
		String board[][] = createBoard(10);
		queensLogic(board, 0, 10);
		System.out.println("count: "  + solutionCount);
//		start();
	}

	private static void start() {
		setUpperBound(promptUser());
		solve();
	}

	private static Integer promptUser() {
		boolean endLoop = false;
		int value = 0;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a positive numerical value below: \n");
			String line;
			try {
				line = br.readLine().trim();
				value = Integer.parseInt(line);
				System.out.println("Value: " + value);
				endLoop = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				endLoop = false;
				e.printStackTrace();
			} catch (NumberFormatException n) {
				System.out.print("\nInput must be a numerical value...Please try again...!\n\t");
				endLoop = false;
			}
		}
		return value;
	}

	private static void print(String board[][], int currentBound) {
		for (int i = 0; i < currentBound; i++) {
			for (int j = 0; j < currentBound; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	private static boolean isValid(String board[][], int currentRow, int currentColumn, int currentBound) {
		int xPosition, yPosition;
		boolean isValid = false;

		// left row
		for (xPosition = 0; xPosition < currentColumn; xPosition++) {
			if (board[currentRow][xPosition] == "Q") {
				return isValid;
			}
		}

		// left diagonal- up
		for (xPosition = currentRow, yPosition = currentColumn; xPosition >= 0 && yPosition >= 0; xPosition--, yPosition--) {
			if (board[xPosition][yPosition] == "Q") { 				
				return isValid;
			}
		}

		// left diagonal-down
		for (xPosition = currentRow, yPosition = currentColumn; yPosition >= 0 && xPosition < currentBound; xPosition++, yPosition--) {
			if (board[xPosition][yPosition] == "Q") {
				return isValid;
			}
		}
		return true;
	}

	private static boolean queensLogic(String board[][], int currentColumn, int currentBound) {
		// Check if all queens have been place, if so return true
//		if (currentColumn >= currentBound) { 			
//			return true;
//		}

		// place queens in each row
		for (int i = 0; i < currentBound; i++) {
			// increment the count for the steps...
			currentNumberOfSteps++;
			boolean isValid = isValid(board, i, currentColumn, currentBound);
			if (isValid) {
				// place queen on board
				board[i][currentColumn] = "Q";

				// try placing other queens
				if(currentColumn + 1 >= currentBound) {
					// Solution Found
					solutionCount++;
				}else {
					boolean placementOfOtherQueens = queensLogic(board, currentColumn + 1, currentBound);
				}
//				if (placementOfOtherQueens == true) { 					
//					return true;
//				}

				// backtrack the previous move of the queen
				board[i][currentColumn] = "_";
			}
		}
		return false;
	}

	public static String[][] createBoard(int value) {
		String board[][] = new String[value][value];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = "_";
			}
		}
		return board;
	}

	public static boolean solve() {
		boolean returnValue = true;

		for (int i = 1; i <= upperBound; i++) {
			System.out.println("_________________");
			System.out.println("*****************");
			currentNumberOfSteps = 0;
			System.out.println("N is : " + i);
			String board[][] = createBoard(i);
			if (queensLogic(board, 0, i) == false) {
				System.out.print("  Status: Failed...\n");
				returnValue = false;
			} else {
				System.out.println("\tBoard: ");
				print(board, i);
				System.out.println("\nSolved in " + currentNumberOfSteps + " Steps.");
				System.out.println("*****************");
				System.out.println("_________________");
			}

		}
		return returnValue;
	}

	public static void setUpperBound(Integer upperBound) {
		NQueensTester.upperBound = upperBound;
	}

}
