package vora.priya.kastas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
	public static void main(String[] args) {
		System.out.println("List: John \n" + john(11));
		System.out.println("List: Ann\n" + ann(150));
		
		System.out.println("\n\nSum : " + sumAnn(150));
	}

	public static List<Long> john(long n) {
		List<Long> kataList = new ArrayList<Long>();
		int count = 0;
		for (long i = 0; count < n; count++) {
			kataList.add(i);
			kataList.add(i);
			kataList.add(i + 1);
			i++;
			i++;
			count++;
			count++;
		}
		return kataList;
	}

	public static List<Long> ann(long n) {
		List<Long> kataList = new ArrayList<Long>();
		int count = 0;
		for (long i = 1; count < n; count++) {
			kataList.add(i);
			kataList.add(i);
			i++;
			count++;
		}
		return kataList;
	}

	public static long sumJohn(long n) {

		return n;
		// your code
	}

	public static long sumAnn(long n) {
		List<Long> annList = ann(n);
		long sum = 0;
//
//		List<Object> listUnique = annList.stream().distinct().collect(Collectors.toList());
//		System.out.println("Unique List: " + listUnique);
//		
//		for (Object eachUniqueValue : listUnique) {
//			System.out.println("Before: " + sum);
//			System.out.println("Value being added: " + eachUniqueValue);
//			sum += (Long)eachUniqueValue;
//			System.out.println("After: " + sum);
//		}
		
		for (Long long1 : annList) {
			sum += long1;
		}
		return sum;

	}
}
