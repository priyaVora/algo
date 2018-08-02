import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algo.data.structures.BinarySearchTree;

public class BinarySearchTreeTester {

	 @Test
	 public void insertionTest() {
	 BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
	 Integer expectedLeft = 7;
	 Integer expectedRoot = 10;
	 Integer expectedRight = 12;
	
	 tree.add(10);
	 tree.add(7);
	 tree.add(12);
	
	 assertEquals(expectedRight, tree.root.getRight().getValue());
	 assertEquals(expectedRoot, tree.root.getValue());
	 assertEquals(expectedLeft, tree.root.getLeft().getValue());
	 }
	
	 @Test(expected = NullPointerException.class)
	 public void nullInsertionTest() {
	 BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
	 int expectedLeft = 7;
	 int expectedRoot = 10;
	 int expectedRight = 12;
	
	 tree.add(null);
	 tree.add(null);
	 tree.add(null);
	
	 }
	
	 @Test
	 public void searchPerson() {
	 BinarySearchTree<String> tree = new BinarySearchTree<String>();
	
	 tree.add("Nainesh");
	 tree.add("Priya");
	 tree.add("Ankita");
	
	 boolean expectedResult = true;
	 boolean findPerson = tree.contains("Priya");
	
	 assertEquals(expectedResult, findPerson);
	 }
	
	 @Test
	 public void searchPerson_EmptyTree() {
	 BinarySearchTree<String> tree = new BinarySearchTree<String>();
	 boolean expectedResult = false;
	 boolean findPerson = tree.contains("Priya");
	 assertEquals(expectedResult, findPerson);
	 }
	
	 @Test
	 public void searchNonExistingPerson_ListOfThree() {
	 BinarySearchTree<String> tree = new BinarySearchTree<String>();
	 tree.add("Nainesh");
	 tree.add("Priya");
	 tree.add("Ankita");
	
	 boolean expectedResult = false;
	 boolean findPerson = tree.contains("Shreya");
	 assertEquals(expectedResult, findPerson);
	 }

	@Test
	public void deleteAPerson_ListOfThree() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		tree.add("Nainesh");
		tree.add("Priya");
		tree.add("Ankita");
		Object[] expectedArray = { "Ankita", "Nainesh" };
		System.out.println("In-Order: " + tree.inOrder());
		tree.remove("Priya");
		Object[] acutalArray = tree.toArray();
		System.out.println("In-Order: " + tree.inOrder());
		boolean expectedResult = false;
		boolean findPerson = tree.contains("Priya");
		System.out.println("-----");
		assertEquals(expectedResult, findPerson);
		assertEquals(ArrayToString(expectedArray), ArrayToString(acutalArray));
	}

	@Test
	public void deleteAPerson_ListOfThree2() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		tree.add("Nainesh");
		tree.add("Priya");
		tree.add("Ankita");
		Object[] expectedArray = { "Nainesh", "Priya" };
		System.out.println("In-Order: " + tree.inOrder());
		tree.remove("Ankita");
		Object[] acutalArray = tree.toArray();
		System.out.println("In-Order: " + tree.inOrder());
		boolean expectedResult = false;
		boolean findPerson = tree.contains("Ankita");
		System.out.println("-----");
		assertEquals(expectedResult, findPerson);
		assertEquals(ArrayToString(expectedArray), ArrayToString(acutalArray));
	}

	@Test
	public void deleteNonExistingPerson_ListOfThree() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		Object[] expectedArray = { "Ankita", "Nainesh", "Priya" };
		tree.add("Nainesh");
		tree.add("Priya");
		tree.add("Ankita");
		tree.remove("Sherya");
		System.out.println("In order: " + tree.inOrder());
		Object[] actualArray = tree.toArray();
		assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
	}
//
//	@Test
//	public void deleteFirstPersonFound_ListOfThree() {
//		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
//		tree.add(10);
//		tree.add(7);
//		tree.add(12);
//		tree.add(3);
//		tree.add(11);
//		tree.add(11);
//		System.out.println("In-Order: " + tree.inOrder());
//		tree.remove(11);
//		System.out.println("In-Order: " + tree.inOrder());
//		boolean expectedResult = true;
//		boolean findPerson = tree.contains(11);
//		assertEquals(expectedResult, findPerson);
//	}

	@Test
	public void testCount_ListOf3() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		tree.add("Nainesh");
		tree.add("Priya");
		tree.add("Ankita");
		int expectedCount = 3;
		int count = tree.count();
		assertEquals(expectedCount, count);
	}
//
////	@Test
//	public void testCountWithRemoving_ListOf3() {
//		BinarySearchTree<String> tree = new BinarySearchTree<String>();
//		tree.add("Nainesh");
//		tree.add("Priya");
//		tree.add("Ankita");
//		tree.add("Ankita");
//		tree.add("Ankita");
//		int expectedCount = 4;
//		System.out.println("Inorder: " + tree.inOrder());
//		tree.remove("Ankita");
//		Object[] arrayOfNames = tree.toArray();
//		System.out.println("Inorder: " + tree.inOrder());
//		int count = tree.count();
//		System.out.println("Count: " + count);
//		assertEquals(expectedCount, count);
//	}

	@Test
	public void testHeightWith_Empty() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		int expectedHeight = 0;
		int heightGot = tree.height();
		System.out.println("Height: " + heightGot);
		assertEquals(expectedHeight, heightGot);
	}

	@Test
	public void testHeightWith_OneNode() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		int expectedHeight = 1;
		tree.add("Priya");
		int heightGot = tree.height();
		System.out.println("Height: " + heightGot);
		assertEquals(expectedHeight, heightGot);
	}

	@Test
	public void testHeightWithRemove_NotEmpty() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(7);
		tree.add(12);
		tree.add(3);

		tree.remove(3);
		int expectedHeight = 2;
		int heightGot = tree.height();
		System.out.println("Height: " + heightGot);
		assertEquals(expectedHeight, heightGot);
	}

	@SuppressWarnings("unused")
	@Test
	public void testPreOrder() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(7);
		tree.add(12);
		tree.add(3);
		tree.add(8);
		tree.add(11);

		String expectedString = "10, 7, 3, 8, 12, 11";
		String value = tree.preOrder();
		assertEquals(expectedString, value);

	}

	@Test
	public void testPostOrder() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(7);
		tree.add(12);
		tree.add(3);
		tree.add(8);
		tree.add(11);

		String expectedString = "3, 8, 7, 11, 12, 10";
		String value = tree.postOrder();
		assertEquals(expectedString, value);

	}

	@Test
	public void testInOrder() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(10);
		tree.add(7);
		tree.add(12);
		tree.add(3);
		tree.add(8);
		tree.add(11);

		String expectedString = "3, 7, 8, 10, 11, 12";
		String value = tree.inOrder();
		System.out.println("In Order: " + value);
		assertEquals(expectedString, value);

	}

	@Test
	public void RemoveDuplicateValueFromSmallTree() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] expectedArray = new Integer[] { 7, 9 };
		int expectedCount = expectedArray.length;
		bst.add(7);
		bst.add(8);
		bst.add(9);
		bst.remove(8);
		int actualCount = bst.count().intValue();
		Object[] actualArray = bst.toArray();
		assertEquals(expectedCount, actualCount);
		Object[] bstArray = bst.toArray();
	}

	@Test
	public void removingRootFromMediumTreeWithDuplicates() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] expectedArray = new Integer[] { 1, 2, 8, 9, 16, 32, 45 };
		int expectedCount = expectedArray.length;
		bst.add(1);
		bst.add(2);
		bst.add(8);
		bst.add(16);
		bst.add(9);
		bst.add(32);
		bst.add(1);
		bst.add(45);
		String preOrderList = bst.preOrder();
		String postOrderList = bst.postOrder();
		String inOrder = bst.inOrder();
		System.out.println("PreOrder: " + preOrderList);
		Object[] actualArrayBeforeRemoved = bst.toArray();
		bst.remove(1);
		preOrderList = bst.preOrder();
		postOrderList = bst.postOrder();
		inOrder = bst.inOrder();

		int actualCount = bst.count().intValue();
		Object[] actualArray = bst.toArray();
		assertEquals(expectedCount, actualCount);

		assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
	}

	@Test
	public void removingRootFromLargeTreeWithoutDuplicates() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] expectedArray = new Integer[] { 2, 8, 9, 16, 32 };
		int expectedCount = expectedArray.length;
		bst.add(1);
		bst.add(2);
		bst.add(8);
		bst.add(16);
		bst.add(9);
		bst.add(32);
		Object[] actualArrayBeforeRemoved = bst.toArray();
		bst.remove(1);

		int actualCount = bst.count().intValue();
		Object[] actualArray = bst.toArray();
		assertEquals(expectedCount, actualCount);

		assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
	}

	@Test
	public void removingRootFrom_3Tree() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] expectedArray = new Integer[] { 8, 9 };
		int expectedCount = expectedArray.length;
		bst.add(7);
		bst.add(8);
		bst.add(9);
		bst.remove(7);

		int actualCount = bst.count().intValue();
		Object[] actualArray = bst.toArray();
		assertEquals(expectedCount, actualCount);

		assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
	}
	@Test
    public void RemoveLeftBranchRoot()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] expectedArray = new Integer[] { 7, 8, 9, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };
        int expectedCount = expectedArray.length;

        bst.add(24);
        bst.add(10);
        bst.add(1337);
        bst.add(8);
        bst.add(12);
        bst.add(100);
        bst.add(1400);
        bst.add(7);
        bst.add(9);
        bst.add(11);
        bst.add(13);
        bst.add(90);
        bst.add(110);
        bst.add(1350);
        bst.add(1500);

        bst.remove(10);
        
        int actualCount = bst.count().intValue();
        Object[] actualArray = bst.toArray();

        assertEquals(expectedCount, actualCount);
        assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
    }
	@Test
	public void RemoveDuplicateValueFromLargeTree() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] expectedArray = new Integer[] { 7, 8, 9, 10, 11, 12, 13, 24, 90, 100, 110, 1337, 1350, 1400, 1500 };
		int calculatedCount = expectedArray.length;
		int expectedCount = expectedArray.length;
		bst.add(24);
		bst.add(10);
		bst.add(1337);
		bst.add(8);
		bst.add(12);
		bst.add(100);
		bst.add(1400);
		bst.add(7);
		bst.add(9);
		bst.add(11);
		bst.add(13);
		bst.add(90);
		bst.add(110);
		bst.add(1350);
		bst.add(1500);
		bst.add(24);
		int calculatedCountOfTree = bst.count().intValue();
		Object[] actualArrayBeforeRemove = bst.toArray();
		bst.remove(24);
		int actualCount = bst.count().intValue();
		Object[] actualArray = bst.toArray();
		assertEquals(expectedCount, actualCount);

		System.out.println("Expected Array: ");
		for (Object object : expectedArray) {
			System.out.print(expectedArray);
		}
		System.out.println("Actual Array: ");
		for (Object object : actualArray) {
			System.out.println(actualArray);
		}

		assertEquals(ArrayToString(expectedArray), ArrayToString(actualArray));
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
