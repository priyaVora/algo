package vora.priya.mazesolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS_Solver<T> {
	private ArrayList<T> shortest_Path = new ArrayList<T>();

	T start = null;
	T end = null;
	private HashMap<T, Node<T>> nodeMap = new HashMap<T, Node<T>>();
	Graph graph = new Graph();
	protected int modCount;
	int avaliableId = 0;

	protected int numberOfNodes = 0;

	public static void main(String[] args) throws IOException {

		BFS_Solver<String> solver = new BFS_Solver<String>();
		solver.start(solver);
	}

	public void start(BFS_Solver<T> maze) throws IOException {
		this.getData();
		T a = (T) "A";
		T b = (T) "B";
		T other = (T) "C";
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

	public void printPath(T startVertex, T targetVertex) {
		if (isConnected(startVertex, targetVertex)) {
			if (start != null && end != null) {
				ArrayList<T> list = findPath(graph, start, end);
				for (T string : list) {
					System.out.print(string + " ");
				}
			}
		} else {
			System.out.println("No Path exist...");
		}
	}

	private ArrayList<Node<T>> getData() throws IOException {
		int lineCount = 0;
		String pathToFile = promptUserFilePath();
		File file = new File(pathToFile);

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Node<T>> itemsList = new ArrayList<Node<T>>();
		String st;
		boolean valid = false;
		boolean mazeEnded = false;
		int mazeCount = 2;
		int printCount = 0;
		while ((st = br.readLine()) != null) {

			if (!(st.contains("//"))) {
				if (printCount != 0) {
					// st = st.trim();
				}
				// System.out.println(st);
				if (st.isEmpty()) {

					mazeEnded = true;
					numberOfNodes = 0;

					printShortPrint(valid, mazeEnded);
					printPath(start, end);
					System.out.println(" ");
					// printNewMazeLabel(mazeCount);
					mazeCount++;
					nodeMap = new HashMap<T, Node<T>>();
					lineCount = -1;
				} else {
					if (printCount == 0) {
						// printNewMazeLabel(mazeCount - 1);
						// System.out.println(st);
						printCount++;
					}
					///////////////////////////////////
					if (lineCount == 0) {
						String[] nodesList = st.split(",");
						int count = 0;
						for (String nodeValue : nodesList) {
							T val = (T) nodeValue;
							Node<T> node = new Node<T>(val);

							numberOfNodes++;
							count++;
							// addToMap(node.getVal());
							makeAddNodeToMap(node.getVal());
						}
					} else if (lineCount == 1) {

						T[] nodesList = (T[]) st.split(",");

						// System.out.println("---------------");
						// System.out.println(" Start: " + nodesList[0]);
						// System.out.println(" End: " + nodesList[nodesList.length - 1]);
						// System.out.println("---------------");
						start = nodesList[0];
						end = nodesList[nodesList.length - 1];
						valid = true;
					} else {
						T[] nodesList = (T[]) st.split(",");

						T source = nodesList[0];
						for (int i = 0; i < nodesList.length; i++) {
							if (i != 0) {

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

		printShortPrint(valid, mazeEnded);
		printPath(start, end);
		System.out.println(" ");
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
