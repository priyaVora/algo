import algo.data.structures.DoubleLinkedList;
import algo.data.structures.DoubleNode;

public class Tester<T>{;
	
	public static void main(String[] args) {
		start();
	}

	public static void start() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.add("Shreya");
		list.add("Priya");
		list.add("Ankita");
		list.add("Nainesh");
		list.insert("Gudiya", 1);
		list.printLinkedList(list);
		System.out.println("Remove");
		
		System.out.println(list.remove());


	}
}
