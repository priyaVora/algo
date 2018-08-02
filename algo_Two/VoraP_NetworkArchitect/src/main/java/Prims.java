import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Prims<T> {
	GraphPrims<T> graphPrims = new GraphPrims<T>();
	private ArrayList<T> shortest_Path = new ArrayList<T>();
	Set<T> individualVertices = new HashSet<T>();
	ArrayList<List<EdgePrims<T>>> mstCollection = new ArrayList<List<EdgePrims<T>>>();
	Map<Integer, Integer> cableMap = new HashMap<Integer, Integer>();
	public Integer totalCableLength = 0;
	ArrayList<String> listOfLeafs = new ArrayList<String>();

	ArrayList<Node<String>> nodesInGraph = new ArrayList<Node<String>>();
	ArrayList<Node<String>> nodesSetter = new ArrayList<Node<String>>();

	public void makeGraph(List<T> nodeValues) {
		for (T t : nodeValues) {
			Node<String> node = new Node<String>("" + t);
			nodesInGraph.add(node);
		}
	}

	public static Comparator<EdgePrims> edgePrioritySetter = new Comparator<EdgePrims>() { // online solution to set
																							// priority
		public int compare(EdgePrims edge1, EdgePrims edge2) {
			return edge1.getDistance() - edge2.getDistance();
		}
	};

	public GraphPrims<T> getGraphPrims() {
		return graphPrims;

	}

	public void setGraphPrims(GraphPrims<T> graphPrims) {
		this.graphPrims = graphPrims;
	}

	public List<EdgePrims<T>> getMinSpanTree(GraphPrims<T> graph) {
		ArrayList<T> sourceArray = new ArrayList<T>();
		EdgePrims<T> previousValidMinEdge = null;
		Queue<EdgePrims<T>> edgesAvailable = new PriorityQueue<EdgePrims<T>>(10, edgePrioritySetter);
		List<EdgePrims<T>> listMinEdges = new ArrayList<EdgePrims<T>>();
		Set<T> unvisitedVertices = new HashSet<T>();
		unvisitedVertices.addAll(graph.getVertices());

		T sourceVertex = unvisitedVertices.iterator().next();
		unvisitedVertices.remove(sourceVertex);
		int theCount = 0;

		while (!unvisitedVertices.isEmpty()) {
			int edgeCount = 0;
			for (Entry<T, Integer> e : graph.getEdges(sourceVertex).entrySet()) {
				edgeCount++;

				if (unvisitedVertices.contains(e.getKey())) {
					Integer value = e.getValue();
					T key = e.getKey();
					edgesAvailable.add(new EdgePrims<T>(sourceVertex, key, value));
				}
			}

			sourceArray.add(sourceVertex);
			EdgePrims<T> minEdge = edgesAvailable.poll();
			if (minEdge != null) {
				previousValidMinEdge = minEdge;
				while (!unvisitedVertices.contains(minEdge.getTarget())) {
					minEdge = edgesAvailable.poll();
				}

				listMinEdges.add(minEdge);

				sourceVertex = minEdge.getTarget();
			} else if (minEdge == null) {
				sourceVertex = previousValidMinEdge.getTarget();
			}

			if (unvisitedVertices.contains(sourceVertex)) {
				unvisitedVertices.remove(sourceVertex);
				// System.out.println(" Source removed: " + sourceVertex);
			} else {
				if (theCount == 0) {
					edgeCount = 0;
					// System.out.println("New MST: \n");
					Integer c = 0;
					// this.print(listMinEdges);
					mstCollection.add(listMinEdges);
					listMinEdges = new ArrayList<EdgePrims<T>>();
					theCount++;
				}
				sourceVertex = unvisitedVertices.iterator().next();
				unvisitedVertices.remove(sourceVertex);
				// System.out.println(" Source removed: " + sourceVertex);
			}

			sourceArray = (ArrayList<T>) new ArrayList<String>();
		}

		mstCollection.add(listMinEdges);
		return listMinEdges;
	}

	public void getShortestPath(T sourceVertex, T targetVertex) {

	}

	public void getHub() {

	}

	private void getData() throws IOException {
		int lineCount = 0;
		String pathToFile = promptUserFilePath();
		File file = new File(pathToFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;

		Map<T, Node<T>> differentNodes = new HashMap<T, Node<T>>();
		while ((st = br.readLine()) != null) {
			if (!(st.contains("//"))) {
				st = st.trim();
				if (lineCount != 0) {
					String[] splitSt = st.split(",");
					String startVertex = splitSt[0];
					Node<T> startNode = new Node<T>(startVertex);
					Map<Node<T>, Integer> adjMap = new HashMap<Node<T>, Integer>();
					List<Node<T>> adjList = new ArrayList<Node<T>>();
					System.out.println(" ");
					for (int i = 1; i < splitSt.length; i++) {
						String[] splitWeight = splitSt[i].split(":");
						T startV = (T) startVertex;
						T v2 = (T) splitWeight[0];

						System.out.println("Source: ---> " + startV);
						System.out.println("Dest: " + v2);
						graphPrims.addEdge(startV, v2, Integer.parseInt(splitWeight[1]));
						Node<T> adjNode;
						if (differentNodes.containsKey(v2)) {
							adjNode = new Node<T>("" + differentNodes.get(v2));
						} else {
							adjNode = new Node<T>("" + v2);
						}

						adjList.add(adjNode);
						adjMap.put(adjNode, adjNode.getDistance());
					}

					if (!differentNodes.containsKey(startNode.getName())) {
						startNode.setAdjacentNodes(adjMap);
						differentNodes.put((T) startNode.getName(), startNode);
					}
					differentNodes.put((T) startNode.getName(), startNode);
					Set<Entry<Node<T>, Integer>> l = adjMap.entrySet();
					for (Entry<Node<T>, Integer> node : l) {
						System.out.println("THE NODE: " + node);
					}

					// startNode.setAdjacentNodes(adjacentNodes);
				}
				lineCount++;
			}
		}
		this.runMinSpanTree(graphPrims);

		// for (List<EdgePrims<T>> eachMST : mstCollection) {
		// // checkLeadNode(eachMST);
		// System.out.println("MST FINISHED>.");
		// }
		br.close();
	}

	public void checkLeadNode(List<EdgePrims<T>> mstList) {
		ArrayList<String> list = new ArrayList<String>();
		for (EdgePrims<T> edgePrims : mstList) {
			if (!individualVertices.contains(edgePrims.getSource())) {
				if (!list.contains(edgePrims.getSource())) {
					System.out.println("Source: " + edgePrims.getSource());
					list.add("" + edgePrims.getSource());
					System.out.println("Adjacent:" + graphPrims.getAdjacentNodes("" + edgePrims.getSource()));
					System.out.println(" Count: " + graphPrims.getAdjacentNodes("" + edgePrims.getSource()).size());
					isLeafNode(edgePrims.getSource(), graphPrims.getAdjacentNodes("" + edgePrims.getSource()).size());
				}
			}
			if (!individualVertices.contains(edgePrims.getTarget())) {
				if (!list.contains(edgePrims.getTarget())) {
					System.out.println("Source: " + edgePrims.getTarget());
					list.add("" + edgePrims.getTarget());
					System.out.println("Adjacent:" + graphPrims.getAdjacentNodes("" + edgePrims.getTarget()));
					System.out.println(" Count: " + graphPrims.getAdjacentNodes("" + edgePrims.getTarget()).size());
					isLeafNode(edgePrims.getTarget(), graphPrims.getAdjacentNodes("" + edgePrims.getTarget()).size());
				}
			}
		}
	}

	public void runMinSpanTree(GraphPrims<T> graphPrims) {
		getMinSpanTree(graphPrims);
		cableLengthCalculator();
		int mstCount = 1;
		for (List<EdgePrims<T>> eachMST : mstCollection) {
			checkLeadNode(eachMST);
			print(eachMST, mstCount, 12);
			mstCount++;
			System.out.println(" ");
		}
	}

	public void cableLengthCalculator() {
		int mstCount = 1;
		for (List<EdgePrims<T>> eachMST : mstCollection) {
			int cableLength = 0;
			for (EdgePrims<T> edgePrims : eachMST) {
				cableLength += edgePrims.getDistance();
			}
			cableMap.put(mstCount, cableLength);
			totalCableLength += cableLength;
			mstCount++;
			System.out.println(" ");
		}
	}

	public void print(List<EdgePrims<T>> mstList, int count, int cableLength) {
		System.out.println("\nMST " + count);
		System.out.print("\nSocket Set: ");
		individualVertices = new HashSet<T>();

		for (EdgePrims<T> eachEdge : mstList) {
			if (!individualVertices.contains(eachEdge.getSource())) {
				individualVertices.add(eachEdge.getSource());
			}
			if (!individualVertices.contains(eachEdge.getTarget())) {
				individualVertices.add(eachEdge.getTarget());
			}
		}

		for (T eachVertice : individualVertices) {
			System.out.print(eachVertice + " ");
		}
		System.out.println("\nCable Needed :" + cableMap.get(count) + " feet");
		System.out.println("Optimal Hub Placement: ");
		System.out.println(" ");
		// for (EdgePrims<T> edgePrims : mstList) {
		// System.out.println(edgePrims.toString());
		// }

		System.out.println("\n Total Cable Required: " + totalCableLength + " ft");
	}

	public boolean isLeafNode(T currentNode, int count) {
		if (count == 1) {
			System.out.println("---------------------------");
			System.out.println("\nEdge is One! ");
			System.out.println(currentNode);
			System.out.println("---------------------------");
			return true;
		} else {
			return false;
		}
	}

	private static String promptUserFilePath() {
		boolean endLoop = false;
		String path = null;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a valid path to a file: \n");
			String line;
			try {
				line = br.readLine().trim();
				path = line;
				File file = new File(path);
				if (!file.isDirectory()) {
					if (file.exists()) {
						endLoop = true;
					}
				} else {
					endLoop = false;
				}
			} catch (IOException e) {

				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

	public void startTest(GraphPrims<Character> graphPrims, Prims<Character> prims) {
		System.out.println("Here is the code...");

		String[] listOfChar = { "Z", "A", "B", "C", "Y" };
		for (String charValue : listOfChar) {
			System.out.print(charValue + " ");
			Node<String> newNode = new Node<String>(charValue);
			nodesInGraph.add(newNode);
		}

		// set relations
		Node<String> nodeZ = new Node<String>("Z");
		Node<String> nodeA = new Node<String>("A");
		Node<String> nodeB = new Node<String>("B");
		Node<String> nodeC = new Node<String>("C");
		Node<String> nodeY = new Node<String>("Y");

		for (Node<String> eachNode : nodesInGraph) {
			if (eachNode.getName() == "A") {
				graphPrims.addEdge('A', 'B', 0);
				graphPrims.addEdge('A', 'B', 0);
				eachNode.addDestination(nodeZ, 0);
				eachNode.addDestination(nodeB, 0);
				eachNode.addDestination(nodeC, 0);
				// relations Z , B, C
			} else if (eachNode.getName() == "B") {
				// relations A , Y, C
				eachNode.addDestination(nodeA, 0);
				eachNode.addDestination(nodeY, 0);
				eachNode.addDestination(nodeC, 0);
			} else if (eachNode.getName() == "C") {
				// relations A and B
				eachNode.addDestination(nodeA, 0);
				eachNode.addDestination(nodeB, 0);
			} else if (eachNode.getName() == "Y") {
				// relations B
				eachNode.addDestination(nodeB, 0);
			} else if (eachNode.getName() == "Z") {
				// relations A-
				eachNode.addDestination(nodeA, 0);
			}
			System.out.println("Each Node:\n " + eachNode.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		GraphPrims<Character> graphPrims = new GraphPrims<Character>();
		Prims<Character> prims = new Prims<Character>();
		prims.start();

		// prims.startTest(graphPrims, prims);

		// prims.isItALeafNode(graphPrims);
		// System.out.println(" ");
		// graphPrims.addEgde('A', 'D', 1);
		// graphPrims.addEgde('D', 'E', 6);
		// graphPrims.addEgde('E', 'F', 2);
		// graphPrims.addEgde('F', 'C', 4);
		// graphPrims.addEgde('C', 'B', 1);
		// graphPrims.addEgde('A', 'B', 3);
		// graphPrims.addEgde('C', 'E', 5);
		// graphPrims.addEgde('B', 'D', 3);
		// graphPrims.addEgde('C', 'D', 1);
		//
		// for (EdgePrims<Character> edge : getMinSpanTree(graphPrims)) {
		// System.out.println(edge.toString());
		// }
	}

	void start() throws IOException {
		this.getData();
	}
}
