import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortPathFinder<T> {
	@SuppressWarnings("unchecked")
	public Map<Vertex<T>, Integer> findShortestPath(GraphPrims<T> graph, Vertex<T> sourceVertex) {
		BinaryMinHeap<Vertex<T>> minHeap = new BinaryMinHeap<Vertex<T>>();
		Map<Vertex<T>, Integer> distanceMap = new HashMap<Vertex<T>, Integer>();
		Map<Vertex<T>, Vertex<T>> parentMap = new HashMap<Vertex<T>, Vertex<T>>();

		for (Vertex<T> vertex : graph.getAllVertex()) {
			minHeap.add(Integer.MAX_VALUE, vertex);
		}
		minHeap.decrease(sourceVertex, "0", sourceVertex);

		distanceMap.put(sourceVertex, 0);
		parentMap.put(sourceVertex, null);

		while (!minHeap.empty()) {
			Node<Vertex<T>> heapNode = minHeap.extractMinNode();
			Vertex<T> currentNode = heapNode.getKey();

			// distanceMap.put(currentNode, heapNode.getWeight());

			for (EdgePrims<T> eachEdge : currentNode.getEdges()) {
				Vertex<T> adjacent = getVertexForEdge(currentNode, eachEdge);

				if (!minHeap.containsData(adjacent)) {
					continue;
				}
				int distanceOfCurrentNode = distanceMap.get(currentNode);
				int weightOfEdge = eachEdge.getDistance();
				int newDistance = distanceOfCurrentNode + weightOfEdge;
				if (minHeap.getWeight(adjacent) > newDistance) {
					minHeap.decrease(adjacent, "" + newDistance, adjacent);
					parentMap.put(adjacent, currentNode);
				}
			}
		}
		return distanceMap;
	}

	private Vertex<T> getVertexForEdge(Vertex<T> currentNode, EdgePrims<T> eachEdge) {
		T targetValue = eachEdge.getTarget();
		return null;
	}

//	public static void main(String[] args) {
//		GraphPrims<Character> graphPrims = new GraphPrims<Character>();
//		Prims<Character> prims = new Prims<Character>();
//		// prims.start();
//		System.out.println(" ");
//		graphPrims.addEgde('A', 'D', 1);
//		graphPrims.addEgde('D', 'E', 6);
//		graphPrims.addEgde('E', 'F', 2);
//		graphPrims.addEgde('F', 'C', 4);
//		graphPrims.addEgde('C', 'B', 1);
//		graphPrims.addEgde('A', 'B', 3);
//		graphPrims.addEgde('C', 'E', 5);
//		graphPrims.addEgde('B', 'D', 3);
//		graphPrims.addEgde('C', 'D', 1);
//
//		for (EdgePrims<Character> edge : prims.getMinSpanTree(graphPrims)) {
//			System.out.println(edge.toString());
//		}
//		System.out.println(" SHORTEST DISTANCE : ");
//
//		ShortPathFinder<Character> shortPathFinder = new ShortPathFinder<Character>();
//		Vertex<Character> vertex = new Vertex<Character>();
//		List<EdgePrims<Character>> list = prims.getMinSpanTree(graphPrims);
//		
//		shortPathFinder.findShortestPath(prims.getGraphPrims(), list.get(0).getTarget());
//	}
}
