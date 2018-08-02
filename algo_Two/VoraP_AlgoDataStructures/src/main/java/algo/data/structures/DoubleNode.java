package algo.data.structures;

public class DoubleNode<T> extends Node {
	public DoubleNode<T> previousNode;

	public DoubleNode(Node previousNode, Node nextNode, T value) {
		super(nextNode, value);
		setNextNode(nextNode);
	}

	public DoubleNode<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(DoubleNode<T> previousNode) {
		this.previousNode = previousNode;
	}
	
}
