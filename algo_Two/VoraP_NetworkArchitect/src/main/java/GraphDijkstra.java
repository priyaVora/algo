import java.util.HashSet;
import java.util.Set;

public class GraphDijkstra<T> {

	private Set<Node<T>> nodes = new HashSet<Node<T>>();

	public void addNode(Node<T> nodeA) {
		nodes.add(nodeA);
	}

	@Override
	public String toString() {
		String value = "";
		for (Node<T> node : nodes) {
			value += node.getName();
			value += " ";
		}
		return value;
	}
}
