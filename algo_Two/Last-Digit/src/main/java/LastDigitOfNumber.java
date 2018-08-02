import java.math.BigInteger;

public class LastDigitOfNumber {
	
	public static void main(String[] args) {
		int[] test = {9,9,9};
		System.out.println(LastDigit(test));
	}

	public static int LastDigit(int[] array) {
		BigInteger i;
		if(array.length==1) {
			return array[0];
		}
		else if(array.length==0) {
			return 1;
		} else {
			i = findNumber(array);
		}
		return Integer.parseInt(i.toString().substring(i.toString().length()-1));
	}

	private static BigInteger findNumber(int[] array) {
		BigInteger currPow = new BigInteger(""+array[array.length-1]);
		BigInteger currNum;
		for(int i=array.length-2;i>=0;i--) {
			currNum = new BigInteger(""+array[i]);
			currPow = currNum.pow(currPow.intValue());
		}
		
		System.out.println(currPow.toString());
		return currPow;
	}
	
	

}
