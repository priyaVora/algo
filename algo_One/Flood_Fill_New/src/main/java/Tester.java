
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Tester {
	private static int count = 0;
	private static Queue<Point> queueList;
	private static int numOfRows;
	private static int numOfColumns;

	public static void main(String[] args) {
		queueList = new LinkedList<Point>();
		for (Point string : queueList) {
			System.out.println("Value: " + string);
		}
		int[][] data = new int[3][3];
		data[0][0] = 1;
		data[0][1] = 2;
		data[0][2] = 3;
		data[1][0] = 1;
		data[1][1] = 2;
		data[1][2] = 2;
		data[2][0] = 2;
		data[2][1] = 3;
		data[2][2] = 2;
		long start = System.nanoTime();    
		System.out.println("Start: " + start);
				FloodFill(data, 0, 0, 4);
		long elapsedTime = System.nanoTime() - start;
		System.out.println("End: " + elapsedTime);
		long value = (long) ((elapsedTime - start) / 1000000000);
		System.out.println("Time: " + value);

	}

	public static int[][] FloodFill(int[][] array, int y, int x, int newValue) {
		int[][] updatedArray = implementQueue(0, 0, array, newValue);
		printBoard(updatedArray);
		return updatedArray;
	}

	private static void printBoard(int[][] array) {
		System.out.println(" ");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(" " + array[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static int[][] implementQueue(int x, int y, int[][] array, int newValue) {

		numOfRows = array.length;
		numOfColumns = array[0].length;

		if (count == 0) {
			queueList.add(new Point(x, y));

		}
		printBoard(array);

		while (queueList != null && queueList.size() > 0) {
			int startMove = 0;
			Point currentPoint = queueList.peek();

			int xValue = (int) currentPoint.getX();
			int yValue = (int) currentPoint.getY();

			if (array[xValue][yValue] == 2) {
				array[xValue][yValue] = 4;
			}

			Point topPoint = new Point(xValue - 1, yValue);
			Point bottomPoint = new Point(xValue + 1, yValue);
			Point leftPoint = new Point(xValue, yValue - 1);
			Point rightPoint = new Point(xValue, yValue + 1);

			if (xValue > 0) {
				if (array[xValue - 1][yValue] == 2) {
					queueList.add(topPoint);
				}
			}
			if (xValue < numOfRows - 1) {
				if (array[xValue + 1][yValue] == 2) {
					queueList.add(bottomPoint);
				}
			}

			if (yValue > 0) {
				if (array[xValue][yValue - 1] == 2) {
					queueList.add(leftPoint);
				}
			}
			if (yValue < numOfColumns - 1) {
				if (array[xValue][yValue + 1] == 2) {
					queueList.add(rightPoint);
				}
			}
			queueList.poll();
		}
		return array;
	}
}

// if (currentPoint != null) {
// if (array[xValue][yValue] == 2) {
// array[xValue][yValue] = newValue;
// }
//
// if (xValue > 0) {
// if (array[xValue - 1][yValue] == 2) {
// queueList.add(new Point(xValue - 1, yValue));
// }
// }
// if (xValue < numOfRows - 1) {
// if (array[xValue + 1][yValue] == 2) {
// queueList.add(new Point(xValue + 1, yValue));
// }
// }
//
// if (yValue > 0) {
// if (array[xValue][yValue - 1] == 2) {
// queueList.add(new Point(xValue, yValue - 1));
// }
// }
// if (yValue < numOfColumns - 1) {
// if (array[xValue][yValue + 1] == 2) {
// queueList.add(new Point(xValue, yValue + 1));
// }
// }
//
// }