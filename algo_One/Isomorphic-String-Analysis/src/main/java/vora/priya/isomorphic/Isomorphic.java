package vora.priya.isomorphic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Isomorphic {
	private ArrayList<String> listOfTerms = new ArrayList<String>();

	private Map<String, ArrayList<String>> exactlyIsomorph = new HashMap<String, ArrayList<String>>();
	private Map<String, ArrayList<String>> looselyIsomorph = new HashMap<String, ArrayList<String>>();
	private Map<String, ArrayList<String>> non_Isomorph = new HashMap<String, ArrayList<String>>();

	public ArrayList<String> grabListOfTerms() throws IOException {
		boolean endLoop = false;
		while (endLoop == false) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			boolean validFileName = false;
			System.out.println("Specify a path to a text file to test...");

			userInput = br.readLine().trim();

			if (userInput.contains("\n")) {
				endLoop = false;
				validFileName = false;
			}
			if (userInput == "") {
				userInput = br.readLine();
			}

			userInput = userInput.trim();
			userInput = userInput.replace("\n", "");
			userInput = userInput.replace(" ", "");

			String regex = "(.*).(txt)";
			validFileName = Pattern.matches(regex, userInput);

			File testFile = new File(userInput.trim());
			if (testFile.exists()) {
				validFileName = true;
			} else {

				validFileName = false;
			}

			if (validFileName == true) {
				try {
					File file = new File(userInput.trim());
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer bufferString = new StringBuffer();
					String line;
					System.out.println("\n");
					while ((line = bufferedReader.readLine()) != null) {
						endLoop = true;
						bufferString.append(line);
						// System.out.println("Line: " + line.trim());
						listOfTerms.add(line.trim());
					}
					fileReader.close();
				} catch (IOException e) {
					System.out.println("File was not found...");
					endLoop = false;
					e.printStackTrace();
				}
			} else {
				System.out.println("\n\tInvalid File Name...");
			}

		}
		return listOfTerms;
	}

	public Map<String, ArrayList<String>> grabExactlyIsomorphics_nonIsomorphic(ArrayList<String> original_List) {
		ArrayList<String> uniqueCodes = new ArrayList<String>();
		ArrayList<String> testListForSpecificCode;

		for (String string : original_List) {
			char[] tempArray = string.toCharArray();
			String code = calculateCodeForExactlyIsomorphic(tempArray, string);

			if (!uniqueCodes.contains(code)) {
				uniqueCodes.add(code);
			}
		}

		boolean validForList = false;
		for (String string : uniqueCodes) {
			testListForSpecificCode = new ArrayList<String>();
			// System.out.println("Unique Code: " + string);
			for (String word : original_List) {
				char[] tempArray = word.toCharArray();
				String code = calculateCodeForExactlyIsomorphic(tempArray, word);

				if (string.equals(code)) {
					testListForSpecificCode.add(word);
					validForList = true;
				} else {
					// System.out.println("Words were not same: ");
					// System.out.println("Unique Code: " + string);
					// System.out.println("Code: " + code);
				}
			}

			String[] sortedArray = new String[testListForSpecificCode.size()];
			sortedArray = testListForSpecificCode.toArray(sortedArray);
			Arrays.sort(sortedArray);

			testListForSpecificCode.clear();

			for (int i = 0; i < sortedArray.length; i++) {
				testListForSpecificCode.add(i, sortedArray[i]);
			}

			if (testListForSpecificCode.size() == 1) {
				validForList = false;

				non_Isomorph.put(string, testListForSpecificCode);
			}

			if (validForList == true) {
				exactlyIsomorph.put(string, testListForSpecificCode);
			}
		}
		return exactlyIsomorph;
	}

	public void grabLooselyIsomorphic(ArrayList<String> original_List) {
		Map<String, String> countOfChars = new HashMap<String, String>();
		Map<String, Map<String, String>> countOfCharsForWords = new HashMap<String, Map<String, String>>();
		for (String word : original_List) {
			ArrayList<String> uniqueChars = new ArrayList<String>();
			char[] wordToArray = new char[word.length()];
			wordToArray = word.toCharArray();
			for (int i = 0; i < wordToArray.length; i++) {
				if (!uniqueChars.contains("" + wordToArray[i])) {
					uniqueChars.add("" + wordToArray[i]);
				}
			}
			// System.out.println("\n\tWord: " + word);

			for (String uniqueChar : uniqueChars) {
				int count = 0;
				// System.out.println("Unique Char: " + uniqueChar);

				for (int i = 0; i < wordToArray.length; i++) {
					if (uniqueChar.equals("" + wordToArray[i])) {
						count++;
					} else {

					}
				}

				countOfChars.put("" + uniqueChar, "" + count);
			}

			countOfCharsForWords.put(word, countOfChars);
			countOfChars = new HashMap<String, String>();
		}
		// System.out.println("Count of Chars for Words: " + countOfCharsForWords);

		calculateCodeForLooselyIsomorphic(countOfCharsForWords);
	}

	public String calculateCodeForExactlyIsomorphic(char[] tempArray, String original) {

		String code = "";

		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < tempArray.length; i++) {
			if (tempMap.containsKey("" + tempArray[i])) {
				code += tempMap.get("" + tempArray[i]);
			} else {
				code += count;
				tempMap.put("" + tempArray[i], Integer.parseInt(code));
				count++;
			}
		}
		// System.out.println("The code made for : " + original + ": " + code);

		char[] seperate = new char[code.length()];
		seperate = code.toCharArray();

		String updatedCode = "";
		for (char c : seperate) {
			updatedCode += c;
			updatedCode += " ";
		}

		updatedCode = updatedCode.substring(0, updatedCode.length() - 1);
		return updatedCode;
	}

	public void calculateCodeForLooselyIsomorphic(Map<String, Map<String, String>> countsOfCharsForWords) {
		HashMap<String, String> codeForSpecificWord = new HashMap<String, String>();

		for (Entry<String, Map<String, String>> me : countsOfCharsForWords.entrySet()) {
			// System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
			Map<String, String> listOfNumbers = me.getValue();

			String code = "";
			Collection<String> codeList = listOfNumbers.values();

			for (String codeValue : codeList) {
				code += codeValue;
			}

			char[] codeArray = new char[code.length()];
			codeArray = code.toCharArray();
			Arrays.sort(codeArray);

			String sortedCode = "";
			for (char codeChar : codeArray) {
				sortedCode += codeChar;
				sortedCode += " ";
			}

			sortedCode = sortedCode.substring(0, sortedCode.length() - 1);
			// System.out.println("Loosely Sorted Code: " + sortedCode + "Word: " +
			// me.getKey());
			codeForSpecificWord.put(me.getKey(), sortedCode);

		}
		ArrayList<String> uniqueCodes = new ArrayList<String>();

		for (Entry<String, String> eachCode : codeForSpecificWord.entrySet()) {
			if (!uniqueCodes.contains(eachCode.getValue())) {
				uniqueCodes.add(eachCode.getValue());
			}
			// System.out.println("Key: " + eachCode.getKey() + " & Value: " +
			// eachCode.getValue());
		}
		ArrayList<String> listOfWordsForCode;
		boolean validList = false;
		// System.out.println("Unique Code: " + uniqueCodes);
		for (String uniqueCode : uniqueCodes) {
			listOfWordsForCode = new ArrayList<String>();
			int count = 0;
			for (Entry<String, String> eachCodeEntry : codeForSpecificWord.entrySet()) {
				if (uniqueCode.equals(eachCodeEntry.getValue())) {
					count++;
					listOfWordsForCode.add(eachCodeEntry.getKey());
					validList = true;
				}
			}
			if (listOfWordsForCode.size() == 1) {
				validList = false;

				if (!non_Isomorph.containsValue(listOfWordsForCode)) {
					non_Isomorph.put(uniqueCode, listOfWordsForCode);

					// Here is where you would want to fix that sorting error

				}
				// System.out.println("Removed: " + listOfWordsForCode);
				// System.out.println("Current non Isomorphic List: " + non_Isomorph);
			}

			String[] sortArray = new String[listOfWordsForCode.size()];
			sortArray = listOfWordsForCode.toArray(sortArray);
			Arrays.sort(sortArray);
			listOfWordsForCode = new ArrayList<String>();
			for (int i = 0; i < sortArray.length; i++) {
				listOfWordsForCode.add(sortArray[i]);
			}
			if (validList == true) {
				looselyIsomorph.put(uniqueCode, listOfWordsForCode);
			}

		}
		// System.out.println(looselyIsomorph);

	}

	public void OutPutsResults(ArrayList<String> original_List) throws IOException {
		String exact_String = "Exact Isomorphs";
		String loosely_String = "Loose Isomorphs";
		String non_String = "Non-isomorphs";

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			// String content = "Here is the content...";
			fw = new FileWriter("Output.txt");
			bw = new BufferedWriter(fw);
			bw.write(exact_String);
			bw.newLine();
			System.out.println(exact_String);
			Map<String, ArrayList<String>> exactlyIsomorphic = getExactlyIsomorph();
			for (Entry<String, ArrayList<String>> me : exactlyIsomorphic.entrySet()) {
				String line = "";
				String value = "";
				for (int i = 0; i < me.getValue().size(); i++) {
					value += me.getValue().get(i);
					value += " ";
				}
				value = value.substring(0, value.length() - 1);
				line += me.getKey() + ":" + " " + value;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}

			bw.newLine();
			bw.write(loosely_String);
			bw.newLine();
			System.out.println("\n");
			System.out.println(loosely_String);
			Map<String, ArrayList<String>> looselyIsomorph = getLooselyIsomorph();
			for (Entry<String, ArrayList<String>> me : looselyIsomorph.entrySet()) {
				String line = "";
				String value = "";
				for (int i = 0; i < me.getValue().size(); i++) {
					value += me.getValue().get(i);
					value += " ";
				}
				value = value.substring(0, value.length() - 1);
				line += me.getKey() + ":" + " " + value;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}

			bw.newLine();
			bw.write(non_String);
			System.out.println("\n");
			bw.newLine();
			System.out.println(non_String);

			Map<String, ArrayList<String>> nonIsomorph = getNon_Isomorph();
			String non_Isomorphic_Line = "";
			String[] wordHolder = null;
			ArrayList<String> tempList = new ArrayList<String>();
			for (Entry<String, ArrayList<String>> non : nonIsomorph.entrySet()) {
				wordHolder = new String[non.getValue().size()];

				for (int i = 0; i < non.getValue().size(); i++) {
					wordHolder[i] = non.getValue().get(i).trim();
					tempList.add(wordHolder[i]);
				}
			}

			wordHolder = tempList.toArray(wordHolder);
			java.util.Arrays.sort(wordHolder);

			for (int i = 0; i < wordHolder.length; i++) {
				non_Isomorphic_Line += wordHolder[i];
				non_Isomorphic_Line += " ";
			}
			non_Isomorphic_Line = non_Isomorphic_Line.substring(0, non_Isomorphic_Line.length() - 1);
			System.out.println(non_Isomorphic_Line);
			bw.write(non_Isomorphic_Line);

			System.out.println("Close...");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	public ArrayList<String> getListOfTerms() {
		return listOfTerms;
	}

	public Map<String, ArrayList<String>> getExactlyIsomorph() {
		return exactlyIsomorph;
	}

	public Map<String, ArrayList<String>> getLooselyIsomorph() {
		return looselyIsomorph;
	}

	public Map<String, ArrayList<String>> getNon_Isomorph() {
		return non_Isomorph;
	}
}
