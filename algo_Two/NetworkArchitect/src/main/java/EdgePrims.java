final class EdgePrims<T> {
	private final T source, destination;
	private final int distance;

	public EdgePrims(T src, T dest, int distance) {
		this.source = src;
		this.destination = dest;
		this.distance = distance;
	}

	public T getSource() {
		return source;
	}

	public T getTarget() {
		return destination;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return " Source " + source + " to vertex " + destination + "-------" + distance;
	}
}