import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrowthTester {

	// 2) Design an algorithm to find all the common elements in two sorted lists of
	// numbers.
	// For example, for the lists 2, 5, 5, 5 and 2, 2, 3, 5, 5, 7, the output should
	// be 2, 5, 5.
	// a. What is the maximum number of comparisons your algorithm makes if the
	// lengths of the two given lists are m and n, respectively?
	public static void main(String[] args) {
		// findMinMaxAverage();
		ArrayList<Integer> listOne = new ArrayList<Integer>();
		ArrayList<Integer> listTwo = new ArrayList<Integer>();

		listOne.addAll(Arrays.asList(2, 5, 5, 5));
		listTwo.addAll(Arrays.asList(2, 2, 3, 5, 5, 7));
		findCommonElements(listOne, listTwo);
		// slowestToGreatestExpression();
	}

	public static void findCommonElements(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {

		ArrayList<Integer> collectionFrequency = new ArrayList<Integer>();

		System.out.println("List One: " + listOne);
		System.out.println("List Two: " + listTwo);

		int comparisons = 0;
		for (Integer integer : listOne) {
			comparisons++;
			boolean contains = listTwo.contains(integer);
			if (!contains == false) {
				
				int countFrequency1 = Collections.frequency(listOne, integer);
				int countFrequency2 = Collections.frequency(listTwo, integer);

				int limit = 0;
				if (countFrequency1 > countFrequency2) {
					limit = countFrequency2;
				} else if (countFrequency2 > countFrequency1) {
					limit = countFrequency1;
				} else if (countFrequency1 == countFrequency2){ 
					limit = countFrequency1;
				}

				int frequency = Collections.frequency(collectionFrequency, integer);

				if (frequency < limit) {

					collectionFrequency.add(integer);
				}
			}

		}

		System.out.println("Collection Frequency: " + collectionFrequency);
		System.out.println("Number of Comparisons: " + comparisons);
	}

	public static void findMinMaxAverage() {
		Integer[] integerList = new Integer[10];
		Random rand = new Random();
		for (int i = 0; i < integerList.length; i++) {
			int value = rand.nextInt(10);
			integerList[i] = value;
		}

		int min = integerList[0];
		int max = integerList[0];
		int average = 0;

		System.out.println("List Value: ");
		for (int i = 0; i < integerList.length; i++) {
			System.out.println("-" + integerList[i]);
			if (min > integerList[i]) {
				min = integerList[i];
			}
			if (max < integerList[i]) {
				max = integerList[i];
			}

			average = (average + integerList[i]);
		}
		average = (average / 2);

		System.out.println("\nMIN: " + min);
		System.out.println("MAX:" + max);
		System.out.println("Average: " + average);
	}

	public static void slowestToGreatestExpression() {
		ArrayList<Double> listOfExpressionValue = new ArrayList<Double>();
		listOfExpressionValue.add(400.0);
		listOfExpressionValue.add(2.095903);
		listOfExpressionValue.add(4.570882);
		listOfExpressionValue.add(3628800.0);
		listOfExpressionValue.add(59049.0);
		listOfExpressionValue.add(200.0);
		listOfExpressionValue.add(3.321928);
		listOfExpressionValue.add(2.0);

		Double[] sortedArray = new Double[listOfExpressionValue.size()];
		sortedArray = listOfExpressionValue.toArray(sortedArray);
		Arrays.sort(sortedArray);

		System.out.println("Sorted List of Expressions: \n");
		for (Double value : sortedArray) {
			System.out.println(value);
		}

	}
}
