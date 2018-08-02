import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphPrims<T> implements Iterable<T> {

	private final Map<T, Map<T, Integer>> graph;

	public GraphPrims() {
		graph = new HashMap<T, Map<T, Integer>>();
	}

	public void addEdge(T vertex1, T vertex2, int distance) {
		if (vertex1 == null || vertex2 == null) {
			throw new NullPointerException();
		}

		if (!graph.containsKey(vertex1)) {
			graph.put(vertex1, new HashMap<T, Integer>());
		}
		if (!graph.containsKey(vertex2)) {
			graph.put(vertex2, new HashMap<T, Integer>());
		}
		graph.get(vertex1).put(vertex2, distance);
		graph.get(vertex2).put(vertex1, distance);
	}

	public Set<T> getVertices() {
		return Collections.unmodifiableSet(graph.keySet());
	}

	public Map<T, Integer> getEdges(T source) {
		if (source == null) {
			throw new NullPointerException();
		}
		return Collections.unmodifiableMap(graph.get(source));
	}

	public void removeEdges(T vertex1, T vertex2) {
		if (vertex1 == null || vertex2 == null) {
			throw new NullPointerException();
		} else if (!graph.containsKey(vertex1) || !graph.containsKey(vertex2)) {
			
		} else {

			graph.get(vertex1).remove(vertex2);
			graph.get(vertex2).remove(vertex1);
		}
	}

	public Iterator<T> iterator() {
		return graph.keySet().iterator();
	}

	public boolean containsNode(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getAdjacentNodes(String node) {
		ArrayList<String> neighboursList;
		Set<String> keys = (Set<String>) graph.keySet();
		for (String key : keys) {
			if (key.equals(node)) {
				neighboursList = (ArrayList<String>) graph.get(key);
				return new ArrayList<String>(neighboursList);
			}
		}
		return new ArrayList<String>();
	}

	public List<Vertex<T>> getAllVertex() {
		// TODO Auto-generated method stub
		return null;
	}
}
