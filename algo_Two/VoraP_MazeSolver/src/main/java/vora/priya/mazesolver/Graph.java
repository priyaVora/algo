package vora.priya.mazesolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private ArrayList<String> nodes = new ArrayList<String>();
	private Map<String, ArrayList<String>> nodeMap = new HashMap<String, ArrayList<String>>();

	public Graph() {
	}

	public void addEdge(String source, String destination) {
		if (!nodeMap.containsKey(source)) {

			ArrayList<String> adjacentNodes = new ArrayList<String>();
			adjacentNodes.add(destination);
			nodeMap.put(source, adjacentNodes);
		} else {
			ArrayList<String> tempList = nodeMap.get(source);

			int index = 0;
			while ((index != tempList.size()) && (!tempList.get(index).equals(destination))) {
				index++;
			}
			if (index == tempList.size()) {
				tempList.add(destination);
				nodeMap.put(source, tempList);
			}
		}
		addToNodes(source, destination);
	}

	private void addToNodes(String source, String destination) {
		if (!source.equals(destination)) {
			if (!nodes.contains(destination)) {
				nodes.add(destination);
			}
		}
		if (!nodes.contains(source)) {
			nodes.add(source);
		}
	}

	public ArrayList<String> getAdjacentNodes(String node) {
		ArrayList<String> neighboursList;
		Set<String> keys = nodeMap.keySet();
		for (String key : keys) {
			if (key.equals(node)) {
				neighboursList = nodeMap.get(key);
				return new ArrayList<String>(neighboursList);
			}
		}
		return new ArrayList<String>();
	}

	public boolean containsNode(String node) {
		return nodes.contains(node);
	}
}