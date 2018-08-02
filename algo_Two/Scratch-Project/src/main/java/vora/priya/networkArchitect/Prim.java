//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Set;
//
//public class Prim {
//
//    private Prim() { }
//
//    public static Graph.CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph, Graph.Vertex<Integer> start) {
//        if (graph == null)
//            throw (new NullPointerException("Graph must be non-NULL."));
//
//        // Prim's algorithm only works on undirected graphs
//        if (graph.getType() == Graph.TYPE.DIRECTED) 
//            throw (new IllegalArgumentException("Undirected graphs only."));
//
//        int cost = 0;
//
//        final Set<Vertex<Integer>> unvisited = new HashSet<Vertex<Integer>>();
//        unvisited.addAll(graph.getVertices());
//        unvisited.remove(start); // O(1)
//
//        final List<Edge<Integer>> path = new ArrayList<Edge<Integer>>();
//        final Queue<Edge<Integer>> edgesAvailable = new PriorityQueue<Edge<Integer>>();
//
//        Vertex<Integer> vertex = start;
//        while (!unvisited.isEmpty()) {
//            // Add all edges to unvisited vertices
//            for (Edge<Integer> e : vertex.getEdges()) {
//                if (unvisited.contains(e.getToVertex()))
//                    edgesAvailable.add(e);
//            }
//
//            // Remove the lowest cost edge
//            final Edge<Integer> e = edgesAvailable.remove();
//            cost += e.getCost();
//            path.add(e); // O(1)
//
//            vertex = e.getToVertex();
//            unvisited.remove(vertex); // O(1)
//        }
//
//        return (new Graph.CostPathPair<Integer>(cost, path));
//    }
//}