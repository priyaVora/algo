package algo.data.structures;

public class PQNode {
	private int priority;
	private int value;

	public PQNode(int priority, int value) {
		this.priority = priority;
		this.value = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[PQNode---> priority=" + priority + ", value=" + value + "]";
	}

	public int compare(PQNode firstNode, PQNode secondNode) {

		if (firstNode != null && secondNode != null) {
			int priorityFirst = firstNode.getPriority();
			int prioritySecond = secondNode.getPriority();

			// System.out.println("Priority First: " + firstNode.getPriority());
			// System.out.println("Priority Second: " + secondNode.getPriority());

			if (priorityFirst > prioritySecond) {
				// System.out.println(" Greater: " + firstNode.getPriority());
				// System.out.println(" ");
				return 1;
			} else if (priorityFirst < prioritySecond) {
				// System.out.println(" Greater: " + secondNode.getPriority());
				// System.out.println(" ");
				return -1;
			} else {
				// System.out.println("Same priority");
				// System.out.println(" ");
				return 0;
			}
		}
		return 0;

	}

	public static void main(String[] args) {

	}
}
