public class CountMultiples {
	static int count = 0;

	static Long numsFound = 0l;

	public static long countSpecMult(long n, long mxval) {
		// long[] primes = findPrime(n, mxval);
		long[] primes = new long[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
				79 };
		int maxValue = 1;
		long numsFound = 0l;
		for (int i = 0; i < n; i++) {
			maxValue *= primes[i];
		}

		System.out.println("return value : " + mxval / maxValue);
		return mxval / maxValue;
	}

	public static long[] findPrime(long n, long mxval) {
		long[] listOfPrime = new long[(int) n];
		int index = 0;
		int i = 2;
		while (count < n) {
			boolean isPrime = isPrime(i);
			if (isPrime) {
				if (index < listOfPrime.length) {
					listOfPrime[index] = i;
					count++;
					index++;
				} else {
					break;
				}
			}

			i++;
		}
		return listOfPrime;
	}

	public static boolean isPrime(int n) {
		int start = 2;

		for (int i = start; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}