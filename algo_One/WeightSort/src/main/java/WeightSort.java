import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WeightSort {

	private static Map<String, Integer> weightMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		String testString = "56 65 74 100 99 68 86 180 90";
		orderWeight(testString);
	}

	public static String orderWeight(String data) {
		System.out.println("Before: " + data);

		String[] splited = data.split("\\s+");
		for (String string : splited) {
			System.out.println(string);

			int weight = findWeight(string);
			weightMap.put(string, weight);
		}

		System.out.println("Weight-Map: " + weightMap);

		grabbValues();
		return null;
	}

	private static void grabbValues() {
		ArrayList<Integer> listOfValues = new ArrayList<Integer>();
		for (Entry<String, Integer> entry : weightMap.entrySet()) {
			listOfValues.add(entry.getValue());
		}
		
		sortWeight(listOfValues);
		
	}

	private static ArrayList<String> sortWeight(ArrayList<Integer> listOfValues) {
		Integer[] valueArray = new Integer[listOfValues.size()];
		ArrayList<String> valuesList = new ArrayList<String>();
	
		for (int i = 0; i < listOfValues.size(); i++) {
			valueArray[i] = listOfValues.get(i);
		}
		Arrays.sort(valueArray);
		System.out.println("\n");
		for (Integer integer : valueArray) {
			System.out.print(integer + " ");
			//valuesList.add(weightMap.get)
		}
	return null;	
	}

	private static Integer findWeight(String string) {
		char[] charArray = string.toCharArray();
		int weight = 0;
		for (char c : charArray) {
			weight += Character.getNumericValue(c);
		}
		System.out.println("Weight of : " + string + " Char value: " + weight);
		return weight;
	}

	private static void replaceMultipleString() {

	}

	private static void trimString() {

	}
}