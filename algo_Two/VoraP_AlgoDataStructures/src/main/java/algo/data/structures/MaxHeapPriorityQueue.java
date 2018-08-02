package algo.data.structures;

public class MaxHeapPriorityQueue {
	PQNode[] priorityList = new PQNode[500];
	BinaryMaxHeap maxHeap = new BinaryMaxHeap(500);

	// Takes the arguments and creates a new PQNode with this data, adds the node to
	// the queue, adjusts the count, and heapifies as needed.
	// When heapifying, a child node with equal priority to its parent does NOT
	// promote and the heapifying of that particular child node stops.

	public static void main(String[] args) {
		MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue();
		pq.enqueue(5, 5);
		pq.enqueue(84, 848);
		pq.enqueue(54, 345);
		pq.enqueue(22, 19);
		pq.enqueue(454, 45);

		pq.enqueue(600, 45);

		pq.toSortedArray();
		pq.toString();
		pq.toSortedArray();
		pq.maxHeap.print();

	}

	public void enqueue(int priority, int value) {
		PQNode newNode = new PQNode(priority, value);
		maxHeap.insert(newNode);
		maxHeap.reOrder();
	}

	// returns the root node of the queue (without removing it). Yes, return the
	// whole node.
	public PQNode peek() {
		return maxHeap.findMaxNode();
	}

	// Removes the root node of the queue, adjusts the count, and heapifies as
	// needed. This method should return the removed PQNode.
	public PQNode dequeue() {
		PQNode removedNode = maxHeap.remove();
		System.out.println("removed: " + removedNode.toString());
		// maxHeap.setSize(maxHeap.getSize()-1);
		System.out.println("\n\nPRINTS REMOVE: ");
		maxHeap.print();
		return removedNode;
	}

	// Returns the total number of nodes in the queue. In Java this is a method, but
	// in C# this must be a property with a public get and a private/protected set.
	public Integer count() {
		return maxHeap.getSize();
	}
	// This method override returns a string containing the elements of the
	// Array-Heap as they are found in memory (i.e. you iterate over the array). The
	// string will have the following format:
	// p1:v1, p2:v2, p3:v3,...,pn:vn

	// Using heapsort, produce and return an array of PQNode instances sorted in
	// non-decreasing order by priority. Despite the typical convention of ignoring
	// index 0 of the backing array, the array you return from this method should
	// start at 0 and continue to index n-1 (like a typical array in Java or C#).
	@Override
	public String toString() { // p1:v1, p2:v2, p3:v3,...,pn:vn
		//PQNode[] bk = this.toSortedArray();
		PQNode[] bk = this.maxHeap.heap;
		System.out.println(" ");
		String state = "";
		for (int i = 1; i <= this.count(); i++) {
			state += bk[i].getPriority() + ":" + bk[i].getValue() + " ";
		}
		state = state.trim();
		state = state.replace(" ", ", ");
		//System.out.println(state);
		return state;
	}

	public void printMaxHeap() {
		this.maxHeap.print();
	}

	public PQNode[] toSortedArray() {
		PQNode[] bk = this.maxHeap.sortMax_Least();
		return bk;

	}
}
