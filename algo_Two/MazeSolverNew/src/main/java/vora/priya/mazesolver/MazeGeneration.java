package vora.priya.mazesolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.omg.CORBA.NO_IMPLEMENT;

public class MazeGeneration<T> implements GraphADT<T> {
	T start = null;
	T end = null;
	protected final int DEFAULT_CAPACITY = 0;
	protected int numVertices;
	protected Integer[][] adjMatrix;
	Map<T, Integer> nodePosition = new HashMap<T, Integer>();
	private HashMap<T, Node<T>> nodeMap = new HashMap<T, Node<T>>();
	BreadthFirstSearch bfs = new BreadthFirstSearch();
	Graph graph = new Graph();
	protected T[] vertices;
	protected int modCount;
	int avaliableId = 0;

	protected int numberOfNodes = 0;

	public MazeGeneration() {
		numVertices = 0;
		this.adjMatrix = new Integer[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
		this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public static void main(String[] args) throws IOException {

		MazeGeneration<String> solver = new MazeGeneration<String>();
		solver.start(solver);
	}

	public void start(MazeGeneration<T> maze) throws IOException {
		this.getData();
		T a = (T) "A";
		T b = (T) "B";
		T other = (T) "C";
		//
		// ArrayList<String> list = bfs.breadthFirstSearch(graph, "A", "B");
		// for (String string : list) {
		// System.out.println("List: " + string);
		// }
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
				// System.out.println("\nUser Path: " + path);
			} catch (IOException e) {

				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

	private ArrayList<Node> getData() throws IOException {
		int lineCount = 0;
		String pathToFile = promptUserFilePath();
		File file = new File(pathToFile);

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Node> itemsList = new ArrayList<Node>();
		String st;
		boolean valid = false;
		boolean mazeEnded = false;
		int mazeCount = 2;
		int printCount = 0;
		while ((st = br.readLine()) != null) {

			if (!(st.contains("//"))) {
				if (printCount != 0) {
					st = st.trim();
				}
				System.out.println(st);
				if (st.isEmpty()) {
					printMaze();
					mazeEnded = true;
					numberOfNodes = 0;
					makeGraph(numberOfNodes);

					if (start != null && end != null) {
						ArrayList<String> list = bfs.findPath(graph, "" + start, "" + end);
						for (String string : list) {
							System.out.print(":" + string + " ");
						}
					}

					printShortPrint(valid, mazeEnded);
					printNewMazeLabel(mazeCount);
					mazeCount++;
					nodeMap = new HashMap<T, Node<T>>();
					lineCount = -1;
				} else {
					if (printCount == 0) {
						printNewMazeLabel(mazeCount - 1);
						System.out.println(st);
						printCount++;
					}
					///////////////////////////////////
					if (lineCount == 0) {
						String[] nodesList = st.split(",");
						int count = 0;
						for (String nodeValue : nodesList) {
							T val = (T) nodeValue;
							Node<T> node = new Node<T>(val);
							addToNodePosition(count, node.getVal());

							numberOfNodes++;
							count++;
							// addToMap(node.getVal());
							makeAddNodeToMap(node.getVal());
						}
					} else if (lineCount == 1) {
						makeGraph(numberOfNodes);
						T[] nodesList = (T[]) st.split(",");

						System.out.println("---------------");
						System.out.println(" Start: " + nodesList[0]);
						System.out.println(" End: " + nodesList[nodesList.length - 1]);
						System.out.println("---------------");
						start = nodesList[0];
						end = nodesList[nodesList.length - 1];
						valid = true;
					} else {
						T[] nodesList = (T[]) st.split(",");

						T source = nodesList[0];
						for (int i = 0; i < nodesList.length; i++) {
							if (i != 0) {
								this.addEdge(source, nodesList[i]);
								setAdjacentNodes(source, nodesList[i]);
								graph.addEdge("" + source, "" + nodesList[i]);
								// this.makeGraph(source, nodesList[i];
							}
						}
					}

				}
				lineCount++;
			}

		}
		mazeEnded = true;
		printMaze();
		printShortPrint(valid, mazeEnded);

		br.close();
		return itemsList;
	}

	public boolean hasPath(T source, T destination) {
		Node<T> sourceGrabbed = getNode(source);
		Node<T> destinationGrabbed = getNode(destination);
		if (sourceGrabbed == null || destinationGrabbed == null) {
			return false;
		}
		return hasPathHelper(sourceGrabbed, destinationGrabbed);

	}

	public boolean hasPathHelper(Node<T> source, Node<T> destination) {
		Queue<Node<T>> nextNodeToGo = (Queue<Node<T>>) new LinkedList<T>();
		HashSet<T> vistedNode = new HashSet<T>();
		nextNodeToGo.add(source);

		while (!nextNodeToGo.isEmpty()) {
			Node<T> theNode = nextNodeToGo.remove();

			int nodeID = theNode.getId();
			int destinationID = destination.getId();

			Comparable comparison = (Comparable) nodeID;

			if (comparison.compareTo(destinationID) == 0) {
				return true;
			}

			if (vistedNode.contains(theNode.getVal())) {
				continue;
			}
			vistedNode.add(theNode.getVal());
			nextNodeToGo.addAll(theNode.adjacentNodes);

		}
		return false;
	}

	public void printMaze() {
		System.out.println("________________________________________________");
		// loop for matrix
		for (int row = 0; row < adjMatrix.length; row++) {
			for (int col = 0; col < adjMatrix[0].length; col++) {
				System.out.print(adjMatrix[row][col] + " ");
			}
			System.out.println(" ");
		}
	}

	public void printShortPrint(boolean valid, boolean mazeEnded) {
		if (valid == true && mazeEnded) {
			System.out.println("\nShort Path: ");
			valid = false;
		}
	}

	public void printNewMazeLabel(int mazeCount) {
		System.out.println("________________________________________________");
		System.out.println("\nNew Maze: ");
		System.out.println("Maze # : " + mazeCount);
		System.out.println("-----");
	}

	public void addVertex(T vertex) {
		if ((numVertices + 1) == adjMatrix.length) {
			// expandCapacity();
			vertices[numVertices] = vertex;
			for (int i = 0; i < numVertices; i++) {
				adjMatrix[numVertices][i] = 0;
				adjMatrix[i][numVertices] = 0;
			}
			numVertices++;
			modCount++;
		}

	}

	public void removeVertex(T vertex) {

	}

	public void addEdge(T vertex, T vertex2) {
		addEdgeHelper(getIndex(vertex), getIndex(vertex2));

	}

	public void addEdgeHelper(int index1, int index2) {
		if (indexIsValid(index1) && indexIsValid(index2)) {
			adjMatrix[index1][index2] = 1;
			adjMatrix[index2][index1] = 1;
			modCount++;
		}
	}

	public void setAdjacentNodes(T source, T destination) {
		Node<T> sourceGrabbed = getNode(source);
		Node<T> destinationGrabbed = getNode(destination);

		if (!(sourceGrabbed.getAdjacentNodes().contains(destinationGrabbed))) {
			sourceGrabbed.adjacentNodes.add(destinationGrabbed);
		}
		if (!(destinationGrabbed.getAdjacentNodes().contains(sourceGrabbed))) {
			destinationGrabbed.adjacentNodes.add(sourceGrabbed);
		}
	}

	public void makeAddNodeToMap(T sourceValue) {
		if ((!getNodeMap().containsKey(sourceValue))) {
			Node<T> addNode = new Node<T>(sourceValue, this.avaliableId);
			avaliableId++;
			this.getNodeMap().put(sourceValue, addNode);
		}
	}

	public HashMap<T, Node<T>> getNodeMap() {
		return nodeMap;
	}

	public Node<T> getNode(T source) {
		Node<T> node = this.getNodeMap().get(source);

		return node;
	}

	public void makeGraph(int size) {
		this.adjMatrix = new Integer[size][size];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}

	private boolean indexIsValid(int index) {
		if (nodePosition.containsValue(index)) {
			return true;
		} else {
			return false;
		}
	}

	private int getIndex(T vertex) {
		if (nodePosition.containsKey(vertex)) {
			int value = nodePosition.get(vertex);
			return value;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public void addToNodePosition(Integer indexValue, T nodeValue) {
		nodePosition.put(nodeValue, indexValue);
	}

	public Iterator iteratorBFS(T startVertex) {
		return null;
	}

	public Iterator iteratorShortestPath(T startVertex, T targetVertex) {

		return null;
	}

	public boolean isEmpty() {
		if (numberOfNodes == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isConnected(T startVertex, T targetVertex) {
		if (hasPath(startVertex, targetVertex) != false) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {

		return numberOfNodes;
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}
}
