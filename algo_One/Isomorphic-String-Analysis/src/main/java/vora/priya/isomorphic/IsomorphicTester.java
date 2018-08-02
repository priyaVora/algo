package vora.priya.isomorphic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public class IsomorphicTester {

	public static void main(String[] args) throws IOException {
		start();
	}

	public static void start() throws IOException {
		Isomorphic test = new Isomorphic();
		ArrayList<String> original_List = test.grabListOfTerms();

		test.grabExactlyIsomorphics_nonIsomorphic(original_List);

		System.out.println("\n");
		test.grabLooselyIsomorphic(original_List);

		test.OutPutsResults(original_List);

	}
}
