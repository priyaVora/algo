package vora.priya.networkArchitect;

public class Node<T> {
	private T key;
	private Integer weight;

	public Node(T key, Integer weight) {
		this.key = key;
		this.weight = weight;
	}

	public Node() {

	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node : Key: " + key + ", Weight:" + weight;
	}
}
