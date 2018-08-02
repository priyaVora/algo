package vora.priya.networkArchitect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimMST<T> {

	private BinaryMinHeap<Vertex<T>> minHeap;
	Map<Vertex<T>, Edge<T>> vertex_Edges_Map;

	public PrimMST() {
	}

	public List<Edge<T>> primsAlgorithm(Graph<T> graph) {
		minHeap = new BinaryMinHeap<Vertex<T>>();
		vertex_Edges_Map = new HashMap<Vertex<T>, Edge<T>>();
		List<Edge<T>> result = new ArrayList<Edge<T>>();

		for (Vertex<T> edge : graph.getAllVertex()) {
			// minHeap.add(Integer.MAX_VALUE, edge);
		}
		Vertex<T> startVertex = graph.getAllVertex().iterator().next();
		minHeap.decrease((Vertex<Vertex<T>>) startVertex, 0);

		while (!minHeap.empty()) {
			Vertex<T> current = minHeap.extractMin();
			Edge<T> spanningTreeEdges = vertex_Edges_Map.get(current);
			if(spanningTreeEdges != null) { 
				result.add(spanningTreeEdges);
			}
			for (Edge<T> edge : current.getEdges()) {
				Vertex<T> adjacent = getVertexForEdge(current, edge);
				if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()) { 
					minHeap.decrease((Vertex<Vertex<T>>) adjacent, edge.getWeight());
					vertex_Edges_Map.put(adjacent, edge);
				}
			}
		}

		return null;
	}

	private Vertex<T> getVertexForEdge(Vertex<T> current, Edge<T> edge) {
		// TODO Auto-generated method stub
		return null;
	}

	public BinaryMinHeap<Vertex<T>> getMinHeap() {
		return minHeap;
	}

	public void setMinHeap(BinaryMinHeap<Vertex<T>> minHeap) {
		this.minHeap = minHeap;
	}

	public Map<Vertex<T>, Edge<T>> getVertex_Edges_Map() {
		return vertex_Edges_Map;
	}

	public void setVertex_Edges_Map(Map<Vertex<T>, Edge<T>> vertex_Edges_Map) {
		this.vertex_Edges_Map = vertex_Edges_Map;
	}

}
