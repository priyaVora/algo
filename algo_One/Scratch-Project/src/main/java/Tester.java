import sorting.library.Sorter;

public class Tester {

	public static void main(String[] args) {
		Double[] list = new Double[4];
		list[0] = 5.5;
		list[1] = 3.0;
		list[2] = 33.3;
		list[3] = 0.0;
		System.out.println("\nUnordered List:");

		for (Double value : list) {
			System.out.println("\t" + value);
		}

		String[] list2 = new String[5];
		list2[0] = "Priya";
		list2[1] = "Sherya";
		list2[2] = "Mira";
		list2[3] = "Natasha";
		list2[4] = "Ankita";
		System.out.println("\nUnordered List: \n");
		for (String value : list2) {
			System.out.println("\t" + value);
		}

		System.out.println("\nBubble Sort:");
		Sorter.bubbleSort(list);
		System.out.println("\nInsertion Sort:");
		Sorter.insertionSort(list);
		System.out.println("\nSelection Sort: ");
		Sorter.selectionSort(list);

		System.out.println("\nBubble Sort: ");
		Sorter.bubbleSort(list2);
		System.out.println("\nInsertion Sort: ");
		Sorter.insertionSort(list2);
		System.out.println("\nSelection Sort: ");
		Sorter.selectionSort(list2);

		Integer[] junitTestValues = new Integer[5];
		junitTestValues[0] = 2527;
		junitTestValues[1] = 76;
		junitTestValues[2] = 4458;
		junitTestValues[3] = 1038;
		junitTestValues[4] = 2759;
		
		System.out.println("\nBubble Sort: ");
		Sorter.bubbleSort(junitTestValues);
		System.out.println("\nInsertion Sort: ");
		Sorter.insertionSort(junitTestValues);
		System.out.println("\nSelection Sort: ");
		Sorter.selectionSort(junitTestValues);
		
	}
}
