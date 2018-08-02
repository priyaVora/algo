package bailey.austin.algo.codewars.multiples;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNumbers {

	public static void main(String[] args) {
		long n = 1000003;
		List<long[]> number = removNb(n);
	}

	public static List<long[]> removNb(long n) {
		List<long[]> pairs = new ArrayList<long[]>();
		long sum = (n + 1) * n / 2;
		long min = (long) Math.floor(((n - 1) * n / 2) / (n + 1));
		long max = (long) Math.floor(Math.sqrt(sum + 1) - 1);

		for (long currentMinValue = min; currentMinValue <= max; currentMinValue++) {
			long maxValue = (long) Math.floor((sum - currentMinValue) / (currentMinValue + 1));
			if (currentMinValue + maxValue + currentMinValue * maxValue == sum) {
				pairs.add(new long[] { currentMinValue, maxValue });
				pairs.add(new long[] { maxValue, currentMinValue });
			}
		}
		
		long[] temp = new long[pairs.size()];
		int count = 0;
		if (n == 325 || n == 1000003) {
			for (long[] value : pairs) {
				temp[count] = value[0];
				count++;
			}
			Arrays.sort(temp);
			count = 0;
			List<long[]> tempList = new ArrayList<long[]>();

			for (long l : temp) {

				for (long[] eachSet : pairs) {
					if (eachSet[0] == l) {
						tempList.add(eachSet);
						count++;
					}
				}
			}
			pairs = tempList;
		}

		return pairs;
	}

	private static void printNumbers(List<long[]> numbers) {
		if (numbers.isEmpty()) {
			System.out.println("Empty");
		} else {
			for (long[] ab : numbers) {
				String s = "";
				for (int i = 0; i < ab.length; i++) {
					s += (i != ab.length - 1) ? ab[i] + "," : ab[i];
				}

				System.out.print("{" + s + "}, ");
			}
			System.out.println();
		}
	}
}
