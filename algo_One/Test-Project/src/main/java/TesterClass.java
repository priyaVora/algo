import sorting.library.Sorter;

public class TesterClass {

	public static void main(String[] args) {
		//Sorter<Comparable<? super T>>.bubbleSort(dataArray);
		Integer[] randomeMerge = {1,5,3,8,5,9,99,33,44};
		Integer[] orderedMerge = {1,2,3};
		Integer[] reverseMerge = {5,4,3,2,1,0};
		Sorter.mergeSort(randomeMerge);
		Sorter.mergeSort(orderedMerge);
		Sorter.mergeSort(reverseMerge);
		
		Sorter.quickSort(randomeMerge);
		Sorter.quickSort(orderedMerge);
		Sorter.quickSort(reverseMerge);
	}
}
