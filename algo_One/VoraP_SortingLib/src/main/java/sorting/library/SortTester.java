package sorting.library;

public class SortTester {
	public static void main(String[] args) {

		System.out.println("Start...");
		System.out.println("\nRandom Sorted:");
		String[] dataArrayRandom = { "Nainesh", "Ankita", "Priya", "Shreya", "Anya" };
		Sorter.mergeSort(dataArrayRandom);
		System.out.println("\n\nEnd...");

		System.out.println("Start...");
		System.out.println("Already Sorted: ");
		String[] dataArrayAlreadySorted = { "Ankita", "Anya", "Nainesh", "Priya", "Shreya" };
		Sorter.mergeSort(dataArrayAlreadySorted);
		System.out.println("\n\nEnd...");
		
		System.out.println("Start...");
		System.out.println("Reverse Sorted: ");
		String[] dataArrayReverseSorted = { "Shreya", "Priya", "Nainesh", "Anya", "Ankita" };
		Sorter.mergeSort(dataArrayReverseSorted);
		System.out.println("\n\nEnd...");

		// Integer[] dataArray = {1, 44,6,86,3,8,555,999,4444,76};
		// Sorter.quickSort(dataArray);
		// Integer[] dataArray = {15,3,2,1,9,5,7,8,6};
		// Integer[] dataArray = {15,3,2,1,9,5,7,8,6};
		// Double[] list = new Double[4];
		//
		// list[0] = 5.5;
		// list[1] = 3.0;
		// list[2] = 33.3;
		// list[3] = 0.0;
		// System.out.println("\nUnordered List:");
		//
		// for (Double value : list) {
		// System.out.println("\t" + value);
		// }
		//
		// String[] list2 = new String[5];
		// list2[0] = "Priya";
		// list2[1] = "Sherya";
		// list2[2] = "Mira";
		// list2[3] = "Natasha";
		// list2[4] = "Ankita";
		// System.out.println("\nUnordered List: \n");
		// for (String value : list2) {
		// System.out.println("\t" + value);
		// }
		//
		// System.out.println("\nBubble Sort:");
		// Sorter.bubbleSort(list);
		// System.out.println("\nInsertion Sort:");
		// Sorter.insertionSort(list);
		// System.out.println("\nSelection Sort: ");
		// Sorter.selectionSort(list);
		//
		// System.out.println("\nBubble Sort: ");
		// Sorter.bubbleSort(list2);
		// System.out.println("\nInsertion Sort: ");
		// Sorter.insertionSort(list2);
		// System.out.println("\nSelection Sort: ");
		// Sorter.selectionSort(list2);
		//
		// Integer[] junitTestValues = new Integer[5];
		// junitTestValues[0] = 2527;
		// junitTestValues[1] = 76;
		// junitTestValues[2] = 4458;
		// junitTestValues[3] = 1038;
		// junitTestValues[4] = 2759;
		//
		// System.out.println("\nBubble Sort: ");
		// Sorter.bubbleSort(junitTestValues);
		// System.out.println("\nInsertion Sort: ");
		// Sorter.insertionSort(junitTestValues);
		// System.out.println("\nSelection Sort: ");
		// Sorter.selectionSort(junitTestValues);

	}
}
