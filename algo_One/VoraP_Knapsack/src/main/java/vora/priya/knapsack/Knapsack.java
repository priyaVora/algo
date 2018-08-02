package vora.priya.knapsack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Knapsack {
	private static int maximumWeightCapacity;
	private static int numberOfUniqueItems;
	private static int totalValueOfKnapSack;
	int lowNumber = Integer.MIN_VALUE;
	public static ArrayList<Item> allItems = new ArrayList<Item>();

	public static void main(String[] args) throws IOException {
		Knapsack ks = new Knapsack();

		allItems = getData();
		int numberOfItems = numberOfUniqueItems;

		int[] weightList = getWeightList(allItems);
		int[] valueList = getValueList(allItems);

		int totalWeight = maximumWeightCapacity;

		ks.knapSackSolution(weightList, valueList, totalWeight, numberOfItems);
	}

	private static String promptUser() {
		boolean endLoop = false;
		String path = null;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a valid path to a file: \n");
			String line;
			try {
				line = br.readLine().trim();
				path = line;
				File file = new File(path);
				if (!file.isDirectory()) {
					if (file.exists()) {
						endLoop = true;
					}
				} else {
					endLoop = false;
				}
				// System.out.println("\nUser Path: " + path);
			} catch (IOException e) {

				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

	private static int max(int firstValue, int secondValue) {
		return (firstValue > secondValue) ? firstValue : secondValue;
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
				// System.out.println(st);
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

				if (lineCount == 1) {
					maximumWeightCapacity = Integer.parseInt(st);
					count++;
				} else if (lineCount == 2) {
					numberOfUniqueItems = Integer.parseInt(st);
					count++;
				}
			}
		}
		// System.out.println("Line Count: " + lineCount);
		// System.out.println(" Maximum Capacity: " + maximumWeightCapacity);
		// System.out.println(" Number of Items: " + numberOfUniqueItems);
		br.close();
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

	public void knapSackSolution(int[] weightList, int[] valueList, int totalWeight, int numberOfItems) {

		int[][] grid = new int[numberOfItems + 1][totalWeight + 1];

		boolean[][] gridSol = new boolean[numberOfItems + 1][totalWeight + 1];

		for (int row = 1; row <= numberOfItems; row++) {
			for (int column = 0; column <= totalWeight; column++) {
				int calculatedValue = grid[row - 1][column];
				int comparingValue = lowNumber;
				if (column >= weightList[row]) {
					comparingValue = grid[row - 1][column - weightList[row]] + valueList[row];
				}
				grid[row][column] = max(calculatedValue, comparingValue);

				if (comparingValue > calculatedValue) {
					gridSol[row][column] = true;
				} else {
					gridSol[row][column] = false;
				}
			}
		}
		// printGrid(grid);

		boolean[] selected = findSelectedItems(numberOfItems, totalWeight, gridSol, weightList);
		grabFinalItems(numberOfItems, selected);

	}

	public boolean[] findSelectedItems(int numberOfItems, int totalWeight, boolean[][] gridSol, int[] weightList) {
		boolean[] selected = new boolean[numberOfItems + 1];
		for (int numItems = numberOfItems, w = totalWeight; numItems > 0; numItems--) {

			if (gridSol[numItems][w] != false) {
				selected[numItems] = true;
				w = w - weightList[numItems];
			} else {
				selected[numItems] = false;
			}
		}
		return selected;
	}

	public void grabFinalItems(int numberOfItems, boolean[] selected) {
		System.out.println("\nOutput:");
		int totalValue = 0;
		for (int i = 1; i < numberOfItems + 1; i++) {
			if (selected[i] == true) {
				System.out.println(" " + allItems.get(i - 1).getName());
				totalValue += allItems.get(i - 1).getValue();
			}
		}
		totalValueOfKnapSack = totalValue;
		System.out.println(" " + maximumWeightCapacity + " pounds");
		System.out.println(" $" + totalValueOfKnapSack);
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

}