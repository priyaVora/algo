package algo.data.structures;

public class BinaryMaxHeap {
	public static PQNode[] heap;
	private int size;
	private int maxsize;

	private static final int firstIndex = 1;

	public BinaryMaxHeap(int maxSize) {
		this.maxsize = maxSize;
		this.size = 0;
		heap = new PQNode[this.maxsize + 1];
		PQNode maxNode = new PQNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
		heap[0] = maxNode;
	}

	private int parent(int position) {
		return position / 2;
	}

	private int leftChild(int position) {
		return (2 * position);
	}

	private int rightChild(int position) {
		return (2 * position) + 1;
	}

	private boolean isLeaf(int position) {
		if (position >= (size / 2) && position <= size) {
			return true;
		}
		return false;
	}

	private void swap(int firstPosition, int secondPosition) {
		PQNode tmp;
		tmp = heap[firstPosition];
		heap[firstPosition] = heap[secondPosition];
		heap[secondPosition] = tmp;
	}

	private void maxHeapify(int position) {
		if (!isLeaf(position)) {

			PQNode currentPosition = heap[position];
			PQNode leftChild = heap[leftChild(position)];
			PQNode rightChild = heap[rightChild(position)];

			if (rightChild != null && leftChild != null) {
				if (currentPosition.compare(currentPosition, leftChild) < 0
						|| currentPosition.compare(currentPosition, rightChild) < 0) {
					if (leftChild.compare(leftChild, rightChild) > 0) {
						swap(position, leftChild(position));
						maxHeapify(leftChild(position));
					} else {
						swap(position, rightChild(position));
						maxHeapify(rightChild(position));
					}
				}
			}
		}
	}

	public void empty() {
		heap = new PQNode[500];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void insert(PQNode addingElement) {

		heap[++size] = addingElement;
		int current = size;
		int count = 0;

		PQNode currentNode = heap[current];
		PQNode parentNode = heap[parent(current)];
		while (currentNode.compare(currentNode, parentNode) > 0) {
			swap(current, parent(current));
			current = parent(current);

			break;

		}
	}

	public void print() {
		maxHeap();
		if (size == 1) {
			System.out.print(
					"\n PARENT : " + heap[1] + " LEFT CHILD : " + heap[2 * 1] + " RIGHT CHILD :" + heap[2 * 1 + 1]);
			System.out.println();
		} else if (size == 0) {
			System.out.println("QUEUE IS EMPTY...");
		} else {

			for (int i = 1; i <= size / 2; i++) {

				System.out.print(
						"\n PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
				System.out.println();
			}

		}

	}

	public PQNode[] sortMax_Least() {
		PQNode[] priorityValues = new PQNode[size];
		for (int i = 1; i <= size; i++) {
			priorityValues[i - 1] = this.heap[i];
		}
		PQNode[] bk = selectionSort(priorityValues);

		return bk;
	}

	public static PQNode[] selectionSort(PQNode[] dataArray) {
		int minInteger;
		PQNode comparableValue;
		for (int i = 0; i < dataArray.length; i++) {
			minInteger = i;
			for (int k = i + 1; k < dataArray.length; k++) {
				if (dataArray[k] != null) {
					int state = dataArray[minInteger].compare(dataArray[minInteger], dataArray[k]);
					if (state > 0) {
						minInteger = k;
					}
				}

			}
			comparableValue = dataArray[minInteger];
			dataArray[minInteger] = dataArray[i];
			dataArray[i] = (PQNode) comparableValue;
		}

		PQNode[] backwards = new PQNode[dataArray.length];
		int backCount = 0;
		for (int i = dataArray.length - 1; i >= 0; i--) {
			backwards[backCount] = dataArray[i];
			backCount++;
		}
		return backwards;
	}

	public void maxHeap() {
		if (size == 1) {
			maxHeapify(0);
		}
		for (int position = (size / 2); position >= 1; position--) {
			maxHeapify(position);
		}
	}

	public void reOrder() {
		PQNode[] priorityValues = new PQNode[size];
		for (int i = 1; i <= size; i++) {
			priorityValues[i - 1] = heap[i];
		}
		BinaryMaxHeap newHeap = new BinaryMaxHeap(500);
		for (PQNode pqNodes : priorityValues) {
			newHeap.insert(pqNodes);
		}
		this.heap = newHeap.heap;
	}

	public PQNode remove() {
		int replaceIndex = size;
		PQNode toRemove = heap[firstIndex];
		System.out.println(size);
		PQNode temp = heap[size--];
		heap[firstIndex] = new PQNode(temp.getPriority(), temp.getValue());
		int count = size + 1;
		heap[replaceIndex] = null;

		//reOrder();
		maxHeap();
		return toRemove;
	}

	public PQNode findMaxNode() {

		PQNode toRemove = heap[firstIndex];

		if (toRemove.getPriority() == Integer.MAX_VALUE) {
			PQNode temp = heap[size--];
			heap[firstIndex] = temp;
			heap[size--] = null;
			maxHeapify(firstIndex);
			return toRemove;
		} else {
			toRemove = heap[1];

		}

		return toRemove;
	}
}
