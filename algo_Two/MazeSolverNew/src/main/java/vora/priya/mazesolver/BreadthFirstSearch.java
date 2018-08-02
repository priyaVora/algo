package vora.priya.mazesolver;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch<T> {
	private ArrayList<T> shortest_Path = new ArrayList<T>();

	@SuppressWarnings("unchecked")
	public ArrayList<T> findPath(Graph graph, T source, T destination) {
		shortest_Path.clear();
		ArrayList<T> path = new ArrayList<T>();
		if (source.equals(destination) && graph.containsNode("" + source)) {
			path.add(source);
			return path;
		}

		ArrayDeque<T> queue = new ArrayDeque<T>();
		ArrayDeque<T> visited = new ArrayDeque<T>();

		queue.offer(source);
		while (!queue.isEmpty()) {
			String valueToBeAddedToEnd = (String) queue.poll();
			visited.offer((T) valueToBeAddedToEnd);

			ArrayList<String> adjacentNodes = graph.getAdjacentNodes(valueToBeAddedToEnd);
			int index = 0;
			int numberOfAdjNodes = adjacentNodes.size();
			while (index != numberOfAdjNodes) {
				String adjacentNode = adjacentNodes.get(index);

				path.add((T) adjacentNode);
				path.add((T) valueToBeAddedToEnd);

				if (adjacentNode.equals(destination)) {
					return findPathHelper(source, destination, path);
				} else {
					if (!visited.contains(adjacentNode)) {
						queue.offer((T) adjacentNode);
					}
				}
				index++;
			}
		}
		return null;
	}

	public void addToShortestPath(int index, T destination) {
		shortest_Path.add(0, destination);
	}

	private ArrayList<T> findPathHelper(T src, T destination, ArrayList<T> path) {
		int index = path.indexOf(destination);
		T sourceValue = path.get(index + 1);
		addToShortestPath(0, destination);

		return check(sourceValue, src, path);
	}

	public ArrayList<T> check(T sourceValue, T src, ArrayList<T> path) {
		if (sourceValue.equals(src)) {
			addToShortestPath(0, src);
			return shortest_Path;
		} else {
			T dest = (T) sourceValue;
			return findPathHelper(src, dest, path);
		}
	}
}