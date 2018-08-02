
public class Mergesort<T extends Comparable<? super T>> {
	// this represents input for Mergesort
	private static Comparable[] dataArray = new Comparable[20];

	private static Comparable[] tempMergeArray = new Comparable[20];

	public static void main(String[] args) {

		Mergesort ms = new Mergesort();
		// utility method for filling input array with random numbers
		ms.fillArray();
		// 0 represents start index, 19 represents end index
		// use inputArray.length ,if you don't know the length prior
		ms.mergeSortG(dataArray, tempMergeArray, 0, 19);
		// prints the sorted input array
		ms.printArray();
	}

	private void printArray() {
		System.out.println();
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(" " + dataArray[i]);
		}

	}

	private void fillArray() {
		for (int i = 0; i < dataArray.length; i++) {
			dataArray[i] = (int) (Math.random() * dataArray.length);
		}
	}

	// private void mergeSort(int begin, int end) {
	// int mid = (begin + end) / 2; // divide the input array into half
	//
	// /*
	// * incase of single element the indexes for begin and end are same. so already
	// * sorted
	// */
	//
	// if (begin == end)
	// return;
	// mergeSort(begin, mid); // sort the left sub array
	// mergeSort(mid + 1, end); // sort the right sub array
	// merge(begin, mid, end);
	//
	// }

	private void mergeSortG(Comparable[] dataArray, Comparable[] tempArr, int begin, int end) {
		int mid = (begin + end) / 2;
		if (begin == end) {
			return;
		}

		mergeSortG(dataArray, tempArr, begin, mid);
		mergeSortG(dataArray, tempArr, mid + 1, end);
		mergeG(dataArray, tempArr, begin, mid, end);

	}

	private void mergeG(Comparable[] inpArr, Comparable[] tempArr, int begin, int mid, int end) {
		for (int i = begin; i <= end; i++) {
			tempArr[i] = inpArr[i];
		}

		int left = begin;
		int right = mid + 1;

		for (int current = begin; current <= end; current++) {
			if (left == mid + 1) {
				inpArr[current] = tempArr[right++];
			} else if (right > end) {
				inpArr[current] = tempArr[left++];
			} else if (tempArr[left].compareTo(tempArr[right]) < 0) {
				inpArr[current] = tempArr[left++];
			} else {
				inpArr[current] = tempArr[right++];
			}
		}

	}

	private void merge(int begin, int mid, int end) {

		/*
		 * copy all the elements from input array to helper array from given positions
		 */

		for (int i = begin; i <= end; i++) {
			tempMergeArray[i] = dataArray[i];
		}

		int left = begin; // first index in left array
		int right = mid + 1; // first index in right array

		/*
		 * Sorting the sub array occurs here
		 */

		for (int current = begin; current <= end; current++) {

			/*
			 * this means all the elements in left sub array are over. therefore copy all
			 * the elements of right sub array to main array.
			 */

			if (left == mid + 1) {
				dataArray[current] = tempMergeArray[right++];
			}
			/*
			 * this means all the elements of right sub array are over. Therefore copy all
			 * the elements of left sub array to main array.
			 */
			else if (right > end) {
				dataArray[current] = tempMergeArray[left++];
			}
			/*
			 * comparing first elements of left and right sub arrays, and then inserting
			 * into input array
			 */
			else if ((tempMergeArray[left].compareTo(tempMergeArray[right])) < 0) {
				dataArray[current] = tempMergeArray[left++];
			} else {
				dataArray[current] = tempMergeArray[right++];
			}

		}
	}
}