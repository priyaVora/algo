import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T value;
	List<EdgePrims<T>> relations = new ArrayList<EdgePrims<T>>();

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<EdgePrims<T>> getEdges() {
		return relations;
	}

	public void setEdges(List<EdgePrims<T>> relations) {
		this.relations = relations;
	}
}
