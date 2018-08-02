import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algo.data.structures.DoubleLinkedList;
import algo.data.structures.SingleLinkedList;

public class LInkedListTester {
	@Test
	public void listOfTen_RemoveSingleElement() {
		SingleLinkedList<String> list;
		String[] val = { "Priya" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeSingleList(1, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(0);
		vals.remove(0);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.remove();
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveSingleElement_Double() {
		DoubleLinkedList<String> list;
		String[] val = { "Priya" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeDoubleList(1, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(0);
		vals.remove(0);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.remove();
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAt10Exception_Single() {
		SingleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeSingleList(10, val);
		list.get(10);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAt10Exception_Double() {
		DoubleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeDoubleList(10, val);
		list.get(10);

	}

	@Test
	public void listOfTen_RemoveAt0_Single() {
		SingleLinkedList<Integer> list;
		Integer[] val = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeSingleListInteger(10, val);

		Integer expectedReturn = 0;
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(0);
		vals.remove(0);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());

		Integer actualReturn = list.removeAt(0);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveAt0_Double() {
		DoubleLinkedList<Integer> list;
		Integer[] val = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeDoubleListInteger(10, val);

		Integer expectedReturn = 0;
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(0);
		vals.remove(0);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());

		Integer actualReturn = list.removeAt(0);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveAt5_Single() {
		SingleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeSingleList(10, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(5);
		vals.remove(5);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.removeAt(5);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveAt5_Double() {
		DoubleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeDoubleList(10, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(5);
		vals.remove(5);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.removeAt(5);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveAt9_Single() {
		SingleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeSingleList(10, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(9);
		vals.remove(9);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.removeAt(9);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void listOfTen_RemoveAt9_Double() {
		DoubleLinkedList<String> list;
		String[] val = { "Priya", "Ankita", "Shreya", "Nainesh", "Anya", "Sheila", "Raj", "Prem", "Jignesh", "Deva" };
		ArrayList<String> vals = new ArrayList<String>();
		for (int i = 0; i < val.length; i++) {
			vals.add(val[i]);
		}
		list = makeDoubleList(10, val);

		String expectedReturn = "";
		Integer expectedCount = 9;
		String expectedString = null;

		expectedReturn = vals.get(9);
		vals.remove(9);
		expectedCount = vals.size();
		expectedString = ArrayToString(vals.toArray());
		String actualReturn = list.removeAt(9);
		Integer actualCount = list.count();
		String actualString = list.toString();
		assertEquals(expectedReturn, actualReturn);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);

	}

	public SingleLinkedList makeSingleList(int listSize, String[] val) {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		for (int i = 0; i < listSize; i++) {
			list.add(val[i]);
		}
		return list;
	}

	public SingleLinkedList makeSingleListInteger(int listSize, Integer[] val) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		for (int i = 0; i < listSize; i++) {
			list.add(val[i]);
		}
		return list;
	}

	public DoubleLinkedList<String> makeDoubleList(int listSize, String[] val) {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		for (int i = 0; i < listSize; i++) {
			list.add(val[i]);
		}
		return list;
	}

	public DoubleLinkedList<Integer> makeDoubleListInteger(int listSize, Integer[] val) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		for (int i = 0; i < listSize; i++) {
			list.add(val[i]);
		}
		return list;
	}

	@Test
	public void testDoubleLinkedListRemoveAll() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		Integer[] ints = { 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42 };
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (Integer num : ints) {
			vals.add(num);
			list.add(num);
		}
		Integer expectedReturn = 0;
		Integer expectedCount = 9;
		String expectedString;
		for (Integer i = 0; i < 10; i++) {
			expectedReturn = vals.get(0);
			vals.remove(0);
			expectedCount = vals.size();
			expectedString = ArrayToString(vals.toArray());
			Integer actualReturn = list.remove();
			Integer actualCount = list.count();
			String actualString = list.toString();

			assertEquals(expectedReturn, actualReturn);
			assertEquals(expectedCount, actualCount);
			assertEquals(expectedString, actualString);
		}
	}

	@Test
	public void DLL_ListOfTen_RemoveAll() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		Integer[] ints = { 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42 };
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (Integer num : ints) {
			vals.add(num);
			list.add(num);
		}
		Integer expectedReturn = 0;
		Integer expectedCount = 9;
		String expectedString;
		for (Integer i = 0; i < 10; i++) {
			expectedReturn = vals.get(0);
			vals.remove(0);
			expectedCount = vals.size();
			expectedString = ArrayToString(vals.toArray());
			Integer actualReturn = list.remove();
			Integer actualCount = list.count();
			String actualString = list.toString();
			assertEquals(expectedReturn, actualReturn);
			assertEquals(expectedCount, actualCount);
			assertEquals(expectedString, actualString);
		}
	}

	@Test
	public void testSingleLinkedListRemoveAll() {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		Integer[] ints = { 24, 3, 6, 0, 6, 17, 100, 2014, 122778, 42 };
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (Integer num : ints) {
			vals.add(num);
			list.add(num);
		}
		Integer expectedReturn = 0;
		Integer expectedCount = 9;
		String expectedString;
		for (Integer i = 0; i < 10; i++) {
			expectedReturn = vals.get(0);
			vals.remove(0);
			expectedCount = vals.size();
			expectedString = ArrayToString(vals.toArray());
			Integer actualReturn = list.remove();
			Integer actualCount = list.count();
			String actualString = list.toString();

			System.out.println("Expected String: " + expectedString);
			System.out.println("Actural String: " + actualString);
			assertEquals(expectedReturn, actualReturn);
			assertEquals(expectedCount, actualCount);
			assertEquals(expectedString, actualString);
		}
	}

	protected String ArrayToString(Object[] a) {
		StringBuilder sb = new StringBuilder();
		if (a.length > 0) {
			sb.append(a[0]);
			for (Integer i = 1; i < a.length; i++) {
				sb.append(", ");
				sb.append(a[i]);
			}
		}
		return sb.toString();
	}

}
