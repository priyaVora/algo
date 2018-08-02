package vora.priya.mazesolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {
	int id;
	private int distanceFromDestination = Integer.MAX_VALUE;
	private T val;
	private boolean visited;
	List<Node<T>> adjacentNodes = new LinkedList<Node<T>>();
	ArrayList<Edge> edges = new ArrayList<Edge>();

	public Node(T value, int id) {
		setVal(value);
		setId(id);
	}

	public Node(T value) {
		setVal(value);
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public int getDistanceFromDestination() {
		return distanceFromDestination;
	}

	public void setDistanceFromDestination(int distanceFromDestination) {
		this.distanceFromDestination = distanceFromDestination;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Node<T>> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(List<Node<T>> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val + " AdjacentNodes => ");
		Iterator<Node<T>> iterator = adjacentNodes.iterator();
		while (iterator.hasNext()) {
			sb.append(iterator.next().val);
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		sb.append(" || ");
		return sb.toString();
	}

	public ArrayList<Edge> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

}
