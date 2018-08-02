
public class Fibonacci_Driver {
	public static void main(String[] args) {

		for (int i = 0; i <= 7; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	public static int fibonacci(int value) {
		if (value <= 1) {
			return value;
		} else {
			return fibonacci(value - 1) + fibonacci(value - 2);
		}
	}
}
