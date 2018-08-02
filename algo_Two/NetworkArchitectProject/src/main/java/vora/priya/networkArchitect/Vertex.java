package vora.priya.networkArchitect;

import java.util.List;

public class Vertex<T> {
	private T value;
	private Integer id;

	public Vertex(T value, Integer id) {
		this.value = value;
		this.id = id;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vertex [value=" + value + ", id=" + id + "]";
	}

	public List<Edge<T>> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}
}
