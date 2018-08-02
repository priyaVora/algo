public class Conversion {
	public final String[] roman = { "M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	public final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static void main(String[] args) {
		Conversion converter = new Conversion();
		converter.solution(1);
	}

	public String solution(int n) {
		convertToRoman(n);
		return "";
	}

	public void convertToRoman(int n) {
		for (int i = 0; i < roman.length; i++) {
			
		}
	}
}
