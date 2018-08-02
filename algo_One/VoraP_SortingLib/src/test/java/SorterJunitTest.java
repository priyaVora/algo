import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import sorting.library.Sorter;

public class SorterJunitTest {
	 
	@Test
	public void insertionSortIntegersAlreadySorted() {
		Integer[] junitTestValues = new Integer[5];
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < junitTestValues.length; i++) {
			junitTestValues[i] = i;
		}

		System.out.println("\nInsertion Sort: ");
		Sorter.insertionSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void bubbleSortIntegersAlreadySorted() {
		Integer[] junitTestValues = new Integer[5];
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < junitTestValues.length; i++) {
			junitTestValues[i] = i;
		}

		System.out.println("\nBubble Sort: ");
		Sorter.bubbleSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void selectionSortIntegersAlreadySorted() {
		Integer[] junitTestValues = new Integer[5];
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };
		for (int i = 0; i < junitTestValues.length; i++) {
			junitTestValues[i] = i;
		}

		System.out.println("\nSelection Sort: ");
		Sorter.selectionSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void bubbleSortIntegersReverseSort() {
		Integer[] junitTestValues = { 4, 3, 2, 1, 0 };
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };

		System.out.println("\nInsertion Sort: ");
		Sorter.bubbleSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void insertionSortIntegersReverseSort() {
		Integer[] junitTestValues = { 4, 3, 2, 1, 0 };
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };

		System.out.println("\nInsertion Sort: ");
		Sorter.insertionSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void insertionSortIntegersRandomlySorted() {
		Integer[] junitTestValues = { 4, 3, 2, 5, 1 };

		Integer[] randomlySorted = { 1, 2, 3, 4, 5 };

		System.out.println("\nInsertion Sort: ");
		Sorter.insertionSort(junitTestValues);
		for (int i = 0; i < randomlySorted.length; i++) {
			if (randomlySorted[i] != junitTestValues[i]) {
				System.out.println("Already is : " + randomlySorted[i]);
				System.out.println("Junit Value is : " + junitTestValues[i]);
				System.out.println("Priya");
				assertFalse(true);
			}
		}
	}

	@Test
	public void selectionSortIntegersReverseSort() {
		Integer[] junitTestValues = { 4, 3, 2, 1, 0 };
		Integer[] alreadySortedValues = { 0, 1, 2, 3, 4 };

		System.out.println("\nSelection Sort: ");
		Sorter.selectionSort(junitTestValues);

		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				assertFalse(true);
			}
		}
	}

	@Test
	public void bubbleSortIntegersRandomlySorted() {
		Integer[] junitTestValues = { 4, 3, 2, 5, 1 };

		Integer[] randomlySorted = { 1, 2, 3, 4, 5 };

		System.out.println("\nBubble Sort: ");
		Sorter.bubbleSort(junitTestValues);
		for (int i = 0; i < randomlySorted.length; i++) {
			if (randomlySorted[i] != junitTestValues[i]) {
				System.out.println("Already is : " + randomlySorted[i]);
				System.out.println("Junit Value is : " + junitTestValues[i]);
				System.out.println("Priya");
				assertFalse(true);
			}
		}
	}

	@Test
	public void selectionSortIntegersRandomlySorted() {
		Integer[] junitTestValues = { 4, 3, 2, 5, 1 };

		Integer[] alreadySortedValues = { 1, 2, 3, 4, 5 };

		System.out.println("\nSelection Sort: ");

		Sorter.selectionSort(junitTestValues);
		for (int i = 0; i < alreadySortedValues.length; i++) {
			if (alreadySortedValues[i] != junitTestValues[i]) {
				System.out.println("Already is : " + alreadySortedValues[i]);
				System.out.println("Junit Value is : " + junitTestValues[i]);
				System.out.println("Priya");
				assertFalse(true);
			}
		}
	}

}
