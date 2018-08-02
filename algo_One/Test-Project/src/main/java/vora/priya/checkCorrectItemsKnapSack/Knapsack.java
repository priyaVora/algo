package vora.priya.checkCorrectItemsKnapSack;
/**
 ** Java Program to Implement Knapsack Algorithm
 **/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/** Class Knapsack **/
public class Knapsack {
	private static int maximumWeightCapacity;
	private static int numberOfUniqueItems;
	public static ArrayList<Item> allItems = new ArrayList<Item>();

	private static String promptUser() {
		boolean endLoop = false;
		String path = null;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a path to a file: \n");
			String line;
			try {
				line = br.readLine().trim();
				path = line;
				System.out.println("\nUser Path: " + path);
				endLoop = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

	private static ArrayList<Item> getData() throws IOException {
		int lineCount = 0;
		String pathToFile = promptUser();
		File file = new File(pathToFile);

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Item> itemsList = new ArrayList<Item>();
		int count = 0;
		String st;
		while ((st = br.readLine()) != null) {
			if (!(st.contains("//"))) {
				System.out.println(st);
				st = st.trim();
				if (count > 1 && !(st.trim().isEmpty())) {
					Item item = new Item();

					String[] itemData = st.split(",");
					String name = itemData[0];
					Integer weight = Integer.parseInt(itemData[1]);
					Integer value = Integer.parseInt(itemData[2]);

					item.setName(name);
					item.setValue(value);
					item.setWeight(weight);
					itemsList.add(item);
				}
				lineCount++;

				String name = "";
				if (lineCount == 1) {
					maximumWeightCapacity = Integer.parseInt(st);
					count++;
				} else if (lineCount == 2) {
					numberOfUniqueItems = Integer.parseInt(st);
					count++;
				}
			}
		}
		System.out.println("Line Count: " + lineCount);
		System.out.println(" Maximum Capacity: " + maximumWeightCapacity);
		System.out.println(" Number of Items: " + numberOfUniqueItems);
		return itemsList;
	}

	private static int[] getValueList(ArrayList<Item> itemsList) {
		int[] valueList = new int[itemsList.size() + 1];

		int index = 1;
		for (Item eachItem : itemsList) {
			valueList[index] = eachItem.getValue();
			index++;
		}
		return valueList;
	}

	private static int[] getWeightList(ArrayList<Item> itemsList) {
		int[] weightList = new int[itemsList.size() + 1];

		int index = 1;
		for (Item eachItem : itemsList) {
			weightList[index] = eachItem.getWeight();
			index++;
		}
		return weightList;
	}

	public void solve(int[] wt, int[] val, int W, int N) {
		int NEGATIVE_INFINITY = Integer.MIN_VALUE;
		int[][] m = new int[N + 1][W + 1];
		int[][] sol = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				int m1 = m[i - 1][j];
				int m2 = NEGATIVE_INFINITY;
				if (j >= wt[i])
					m2 = m[i - 1][j - wt[i]] + val[i];
				/** select max of m1, m2 **/
				m[i][j] = Math.max(m1, m2);
				sol[i][j] = m2 > m1 ? 1 : 0;
			}
		}
		printGrid(sol);
		/** make list of what all items to finally select **/
		int[] selected = new int[N + 1];
		for (int n = N, w = W; n > 0; n--) {
			System.out.println("N: " + N);
			System.out.println("W:" + W);

			if (sol[n][w] != 0) {
				selected[n] = 1;
				w = w - wt[n];
			} else
				selected[n] = 0;
		}
		/** Print finally selected items **/
		System.out.println("\nItems selected : ");
		for (int i = 1; i < N + 1; i++)
			if (selected[i] == 1)
				System.out.print(i + " ");
		System.out.println();
	}

	private void printGrid(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(" " + sol[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	/**
	 * Main function
	 * 
	 * @throws IOException
	 **/
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Knapsack Algorithm Test\n");
		/** Make an object of Knapsack class **/
		Knapsack ks = new Knapsack();

		System.out.println("Enter number of elements ");
		int n = scan.nextInt();
		//
		int[] wt = new int[n + 1];
		int[] val = new int[n + 1];
		// allItems = getData();
		// int[] wt = getWeightList(allItems);
		// int[] val = getValueList(allItems);

		 System.out.println("\nEnter weight for " + n + " elements");
		 for (int i = 1; i <= n; i++)
		 wt[i] = scan.nextInt();
		 System.out.println("\nEnter value for " + n + " elements");
		 for (int i = 1; i <= n; i++)
		 val[i] = scan.nextInt();

		System.out.println("\nEnter knapsack weight ");
		int W = scan.nextInt();

		ks.solve(wt, val, W, n);
	}
}