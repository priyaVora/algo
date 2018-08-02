package bailey.austin.grid;

import java.math.BigInteger;

public class GridTraversal {

	public static void main(String[] args) {
		System.out.println(numberOfRoutes(2, 3));
	}

	public static BigInteger numberOfRoutes(int m, int n) {
		BigInteger mAndN = factorial(new BigInteger("" + (m + n)));
		BigInteger mFac = factorial(new BigInteger("" + m));
		BigInteger nFac = factorial(new BigInteger("" + n));
		System.out.println(mAndN);
		System.out.println(mFac);
		System.out.println(nFac);
		return mAndN.divide((mFac.multiply(nFac)));
	}

	private static BigInteger factorial(BigInteger x) {
		BigInteger y = new BigInteger("" + x);
		y = (y.intValue()==1||y.intValue()==0) ? BigInteger.ONE: y.multiply(factorial(y.subtract(BigInteger.ONE)));
		return y;
	}
}