package vora.priya.checkCorrectItemsKnapSack;

public class Item {
	private String name;
	private Integer weight;
	private Integer value;

	public Item() {

	}

	public Item(String name, Integer weight, Integer value) {
		setName(name);
		setWeight(weight);
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item: name=" + name + ", weight=" + weight + ", value=" + value;
	}

}
