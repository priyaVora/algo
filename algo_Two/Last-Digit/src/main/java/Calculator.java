import java.lang.reflect.Array;

public class Calculator {
	public static void main(String[] args) {
		int[] array = { 3, 4, 2 };
		Calculator c = new Calculator();
		c.LastDigit(array);
	}

	public Integer LastDigit(int[] array) {
		int x = 0;
		int y = 0;
		int count = 0;
		boolean power = false;
		for (int i = array.length - 1; i >= 0; i--) {
			count++;
			if (count <= 2) {
				if (count == 2) {
					power = true;
				}
				if (count == 1) {
					System.out.println("I: " + array[i]);
					x = array[i];
				} else if (count == 2) {
					System.out.println("I: " + array[i]);
					y = array[i];
				}
				if (power == true) {
					Double p = Math.pow(x, y);
					System.out.println("Power: " + p);
				}
			} else {
				System.out.println("Other: " + array[i]);
			}
		}
		return 0;
	}

	public Integer findPower(int[] array) {

		return 0;
	}

}
