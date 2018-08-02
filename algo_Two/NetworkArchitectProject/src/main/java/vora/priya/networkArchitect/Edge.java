package vora.priya.networkArchitect;

public class Edge<T> {
	private Vertex startingVertex;
	private Vertex endingVertex;
	private Integer weight;

	public Edge(Vertex startingVertex, Vertex endingVertex, Integer weight) {
		this.startingVertex = startingVertex;
		this.endingVertex = endingVertex;
		this.weight = weight;
	}

	public Edge() {

	}

	public Vertex getStartingVertex() {
		return startingVertex;
	}

	public void setStartingVertex(Vertex startingVertex) {
		this.startingVertex = startingVertex;
	}

	public Vertex getEndingVertex() {
		return endingVertex;
	}

	public void setEndingVertex(Vertex endingVertex) {
		this.endingVertex = endingVertex;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
