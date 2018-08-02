package algo.data.structures;

public class Node<T> {
	public Node nextNode;
	public T value;

	public Node(Node nextNode, T value) {
		setNextNode(nextNode);
		setValue(value);
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
