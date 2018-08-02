package algo.data.structures;

public class NodeBST<T> {
	NodeBST<T> left;
	NodeBST<T> right;
	T value;

	public NodeBST(NodeBST left, NodeBST right, T value) {
		setLeft(left);
		setRight(right);
		setValue(value);
	}

	public NodeBST<T> getLeft() {
		return left;
	}

	public void setLeft(NodeBST<T> left) {
		this.left = left;
	}

	public NodeBST<T> getRight() {
		return right;
	}

	public void setRight(NodeBST<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NodeBST [left=" + left + ", right=" + right + ", value=" + value + "]";
	}
}
