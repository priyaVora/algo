package vora.priya.kastas;

import java.util.ArrayList;
import java.util.List;

public class Kata2 {

	public static void main(String[] args) {
		long x = 0;

		System.out.println("Ann's List: \n");
		List<Long> annsOutput = ann(115);
		for (Long value : annsOutput) {
			System.out.print(value + " ");
		}

		System.out.println("\n\nJohn's List: \n");
		List<Long> johnsOutput = john(75);
		for (Long value : johnsOutput) {
			System.out.print(value + " ");
		}

		sumAnn(6930);
		sumJohn(75);
	}

	public static ArrayList<Long[]> lists = new ArrayList<Long[]>();
	static int count = 0;
	static Long[] johnList = { (long) 0 };
	static Long[] annList = { (long) 1 };

	public static ArrayList<Long[]> getLists(int n) {
		if (count == 0) {
			johnList = new Long[n];
			annList = new Long[n];

			johnList[0] = (long) 0;
			annList[0] = (long) 1;
			count++;
		}
		for (int i = 1; i < n; i++) {
			long v1 = johnList[i - 1];
			long v2 = annList[i - 1];
			johnList[i] = (long) (i - annList[(int) v1]);
			annList[i] = (i - johnList[(int) v2]);
		}

		Long[] annListConverted = annList;
		lists.add(0, annList);
		lists.add(1, johnList);

		return lists;
	}

	public static List<Long> john(long n) {
		getLists((int) n);
		int x = (int) n;
		Long[] j = lists.get(1);

		int count = 0;
		List<Long> tempList = new ArrayList<Long>();
		for (Long long1 : j) {
			if (count < n) {
				tempList.add(long1);
				count++;
			}
		}
		return tempList;
	}

	public static List<Long> ann(long n) {
		getLists((int) n);
		int x = (int) n;
		Long[] j = lists.get(0);

		List<Long> tempList = new ArrayList<Long>();
		int count = 0;
		for (Long long1 : j) {
			if (count < n) {
				tempList.add(long1);
				count++;
			}
		}
		return tempList;
	}

	public static long sumJohn(long n) {
		Long[] johnList1 = lists.get(1);
		
		if (johnList1.length == n) { 
			System.out.println("Size was perfect.! ");
		} else { 
			System.out.println("Fell short...so had to calculate it...");
			lists = new ArrayList<Long[]>();
			count = 0;
			johnList[0] = (long) 0;
			annList[0] = (long) 1;
			
			getLists((int)n);
		}
		
		long sum = 0;

		System.out.println("\nSum of John: ");

		int count = 0;

		for (Long long1 : johnList) {
			if (count < n) {
				sum += long1;
				count++;
			}

		}

		System.out.println("Sum: " + sum);
		return sum;
	}

	public static long sumAnn(long n) {

		Long[] annList1 = lists.get(0);
		if (annList1.length == n) { 
			System.out.println("Size was perfect.! ");
		} else { 
			System.out.println("Fell short...so had to calculate it...");
			lists = new ArrayList<Long[]>();
			count = 0;
			johnList[0] = (long) 0;
			annList[0] = (long) 1;
			
			getLists((int)n);
		}
		long sum = 0;

		System.out.println("\n\nSum of Ann");

		int count = 0;

		for (Long long1 : annList) {

			sum += long1;
			count++;

		}
		System.out.println("Sum: " + sum);
		return sum;
	}
}