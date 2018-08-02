package vora.priya.networkArchitect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NetworkArchitectTester<T> {

	public static void main(String[] args) throws IOException {
		NetworkArchitectTester<Integer> tester = new NetworkArchitectTester<Integer>();
		tester.start();
	}

	private void start() throws IOException {
		this.getData();
	}

	public void setVerticesToInfinity_minHeap(Graph graph) {

	}

	private void getData() throws IOException {
		int lineCount = 0;
		String pathToFile = promptUserFilePath();
		File file = new File(pathToFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;

		while ((st = br.readLine()) != null) {
			if (!(st.contains("//"))) {
				st = st.trim();
				System.out.println(st + "");
				lineCount++;
			}

		}
		br.close();
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
				System.out.println("\nUser Path: " + path);
			} catch (IOException e) {

				endLoop = false;
				e.printStackTrace();
			}
		}
		return path;
	}

}
