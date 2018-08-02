
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {
	private List<Node<T>> allNodes = new ArrayList<Node<T>>();
	private Map<T, Integer> nodePosition = new HashMap<T, Integer>();

	public void add(int weight, T key) {
		Node<T> node = new Node<T>();
		node.setWeight(weight);
		node.setKey(key);
		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		int parentIndex = (current - 1) / 2;
		nodePosition.put(node.getKey(), current);

		while (parentIndex >= 0) {
			Node<T> parentNode = allNodes.get(parentIndex);
			Node<T> currentNode = allNodes.get(current);
			if (parentNode.getWeight() > currentNode.getWeight()) {
				swap(parentNode, currentNode);
				updatePositionMap(parentNode.getKey(), currentNode.getKey(), parentIndex, current);
				current = parentIndex;
				parentIndex = (parentIndex - 1) / 2;
			} else {
				break;
			}
		}
	}

	public T min() {
		return allNodes.get(0).getKey();
	}

	public boolean empty() {
		return allNodes.size() == 0;
	}

	public Integer getWeight(T key) {
		Integer position = nodePosition.get(key);
		if (position == null) {
			return null;
		} else {
			return allNodes.get(position).getWeight();
		}
	}

	public Node<T> extractMinNode() {
		int size = allNodes.size() - 1;
		Node<T> minNode = new Node<T>();
		minNode.setKey(allNodes.get(0).getKey());
		minNode.setWeight(allNodes.get(0).getWeight());

		int lastNodeWeight = allNodes.get(size).getWeight();
		allNodes.get(0).setWeight(lastNodeWeight);
		allNodes.get(0).setKey(allNodes.get(size).getKey());
		nodePosition.remove(minNode.getKey());
		nodePosition.remove(allNodes.get(0));
		nodePosition.put(allNodes.get(0).getKey(), 0);
		allNodes.remove(size);

		int currentIndex = 0;
		size--;
		while (true) {
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			if (left > size) {
				break;
			}
			if (right > size) {
				right = left;
			}
			int smallerIndex = allNodes.get(left).getWeight() <= allNodes.get(right).getWeight() ? left : right;
			if (allNodes.get(currentIndex).getWeight() > allNodes.get(smallerIndex).getWeight()) {
				swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).getKey(), allNodes.get(smallerIndex).getKey(),
						currentIndex, smallerIndex);
				currentIndex = smallerIndex;
			} else {
				break;
			}
		}
		return minNode;
	}

	public T extractMin() {
		Node<T> node = extractMinNode();
		return node.getKey();
	}

	private void printPositionMap() {
		System.out.println(nodePosition);
	}

	private void swap(Node<T> node1, Node<T> node2) {
		int weight = node1.getWeight();
		T data = node1.getKey();

		node1.setKey(node2.getKey());
		node1.setWeight(node2.getWeight());

		node2.setKey(data);
		node2.setWeight(weight);
	}

	@SuppressWarnings("unused")
	private void updatePositionMap(T data1, T data2, int pos1, int pos2) {
		nodePosition.remove(data1);
		nodePosition.remove(data2);
		nodePosition.put(data1, pos1);
		nodePosition.put(data2, pos2);
	}

	public void printHeap() {
		for (Node<T> n : allNodes) {
			System.out.println(n.getWeight() + " " + n.getKey());
		}
	}

	public boolean containsData(T key) {
		return nodePosition.containsKey(key);
	}

	public void decrease(T t, String nw, T value) {
		Vertex<T> ns = (Vertex<T>) value;
		Integer newWeight = Integer.parseInt(nw);
		Integer position = nodePosition.get(ns.getValue());
		allNodes.get(position).setWeight(newWeight);
		int parent = (position - 1) / 2;
		while (parent >= 0) {
			if (allNodes.get(parent).getWeight() > allNodes.get(position).getWeight()) {
				swap(allNodes.get(parent), allNodes.get(position));
				updatePositionMap(allNodes.get(parent).getKey(), allNodes.get(position).getKey(), parent, position);
				position = parent;
				parent = (parent - 1) / 2;
			} else {
				break;
			}
		}

	}
}
