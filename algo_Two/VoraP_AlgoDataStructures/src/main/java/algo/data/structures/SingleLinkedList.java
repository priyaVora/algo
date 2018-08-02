package algo.data.structures;

public class SingleLinkedList<T> {
	private Node<T> head, tail;
	int count;

	public SingleLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.add("priya");
		list.add("priya1");
		list.add("priy2");
		list.add("priya");
		list.add("priya");
		list.add("Shreya");
		list.printLinkedList(list);
		System.out.println("Person: " + list.get(5));
		list.printLinkedList(list);
	}

	public void printLinkedList(SingleLinkedList<T> list) {
		System.out.println("\nPrint method");
		System.out.println("Head: " + head);
		System.out.println("Tail: " + tail);
		Node<T> currentNode = this.head;
		int listCount = 0;
		for (int i = 0; i < count; i++) {
			System.out.println(" ");

			System.out.println("Current: " + currentNode.getValue());
			if (currentNode.getNextNode() != null) {
				System.out.println("Next: " + currentNode.getNextNode().getValue());
			} else {
				System.out.println("Next: " + null);
			}
			currentNode = (Node<T>) currentNode.getNextNode();
		}
	}

	// a. Add(T val) – puts a new value at the Tail end of the list (Done)
	public void add(T val) {

		Node<T> temp = new Node<T>(null, val);
		count++;
		if (head == null) {
			head = temp;
			tail = head;
		} else {

			tail.setNextNode(temp);
			tail = temp;
		}
	}

	//check index
	public boolean isValid(int index) {
		boolean isValid = true;
		if(index < 0 || index >=count) { 
			isValid = false;
		}
		return isValid;
	}

	// b Insert(T val, int index) – inserts a new value at a given index, pushing
	// the
	// existing value at that index to the next index spot, and so on.
	// Insert may ONLY target indices that are currently in use.
	// In other words, if you have 5 elements in your list, you may insert at any
	// index between 0 and 4 inclusive.
	// Index 5 would be considered out of bounds as it is not currently in use
	// during the insertion process.
	// Any index less than zero or equal to or greater than Count should throw an
	// index out of bounds exception.

	public void insert(T val, int index) {
		
		boolean isValid = isValid(index);
		if(!isValid) { 
			throw new IndexOutOfBoundsException();
		}

		if (index <= count) {
			Node<T> currentHead = head;
			Node<T> insertingNode = new Node<T>(null, val);

			int postionOfInsert = index;

			if (postionOfInsert == 0) {
				insertingNode.setNextNode(head);
				head = insertingNode;
			} else {
				for (int i = 1; i < postionOfInsert; i++) {
					currentHead = currentHead.getNextNode();
				}
				insertingNode.setNextNode(currentHead.getNextNode());
				currentHead.setNextNode(insertingNode);
			}
			count++;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	// c. Count – returns the number of values in the list. This should be a
	// property in C#, but a method in Java. For efficiency, the count value should
	// be a managed value (stored and updated as needed) and not simply derived each
	// time Count is called. (Done)

	public Integer count() {
		return count;
	}

	// d. Get(int index) – returns the value at the given index. Any index less than
	// zero or equal to or greater than Count should throw an index out of bounds
	// exception

	public T get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> currentNode = this.head;
		int listCount = 0;
		while (currentNode != null) {
			if (listCount == index) {
				break;
			}
			currentNode = currentNode.getNextNode();
			listCount++;
		}
		return (T) currentNode.getValue();
	}

	// e. Remove – removes and returns the first value in the list
	public T remove() {
		T value = null;
		if (head != null) {
			value = head.getValue();
			if (count == 1) {
				if (head.getNextNode() != null) {
					head = head.getNextNode();
				} else {
					head = null;
					tail = null;
					count = 0;
				}
			} else {
				this.removeAt(0);
			}

		}
		return value;
	}

	// f. RemoveAt(int index) –removes and returns the value at a given index. Any
	// index less than zero or equal to or greater than Count should throw an index
	// out of bounds exception.
	public T removeAt(int index) {

		boolean isValid = isValid(index);
		if (!isValid) {
			throw new IndexOutOfBoundsException();
		}

		T value = this.get(index);
		if (index == 0) {
			head = head.getNextNode();
		} else {
			value = this.get(index);
			Node<T> currentNode = this.head;
			Node<T> backNode = null;
			int listCount = 0;
			int backNodeIndex = index - 1;
			while (currentNode != null) {
				if (listCount == backNodeIndex) {
					backNode = currentNode;
				}
				if (listCount == index) {
					backNode.setNextNode(currentNode.getNextNode());
					break;
				}
				currentNode = currentNode.getNextNode();
				listCount++;
			}
		}

		count--;
		return value;
	}

	// g. RemoveLast – removes and returns the last value in the list

	public T removeLast() {
		int index = count - 1;
		this.removeAt(index);
		index = count - 1;
		return this.get(index);
	}

	// h. ToString – an override method that creates and returns a string
	// representation of all the values in the list. The string must be in the
	// format of “v0, v1, v2, .., vn-1” where n-1 is the last index in the list. An
	// empty list should return an empty string (but not null). While every value in
	// the string is separated by a comma and space, the string must NOT have any
	// unnecessary commas or spaces at the beginning or end.

	// Override method
	@Override
	public String toString() {
		String returnValue = "";
		Node<T> currentNode = this.head;
		int listCount = 0;

		for (int i = 0; i < count; i++) {
			if (i == count - 1) {
				returnValue += currentNode.getValue();
				currentNode = currentNode.getNextNode();
				listCount++;
			} else {
				returnValue += currentNode.getValue() + ", ";
				currentNode = currentNode.getNextNode();
				listCount++;

			}
		}

		returnValue = returnValue.trim();
		return returnValue;

	}

	// i. Clear – removes all values in the list.
	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

	// j. Search(T val) – searches for a value in the list and returns the first
	// index of that value when found. If the key is not found in the list, the
	// method returns -1.
	public Integer search(T val) {
		int returnValue = -1;
		for (int i = 0; i < count; i++) {
			T tempValue = this.get(i);
			if (tempValue.equals(val)) {
				returnValue = i;
				return returnValue;
			}
		}
		return returnValue;
	}
}
