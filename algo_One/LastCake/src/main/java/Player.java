import java.math.BigInteger;
import java.util.Random;

public class Player {

	public Player(int cakes) {
	}

	public static void main(String[] args) {
		move(12, 1);
	}
	// Decide who move first - player or opponent (true if player)
	public boolean firstMove(int cakes) {
		return (cakes > 2 && cakes % 4 != 2) ? true : false;
	}

	// Decide your next move
	public static int move(int cakes, int last) {
		
		System.out.println(findLeftOverCake());
//		if (last == 1) {
//			return 3;
//		} else if (last == 2) {
//
//			return 3;
//		} else if (last == 3) { 
//			return 1;
//		}
		return 0;
	}
	
	public static BigInteger findLeftOverCake() { 
		BigInteger value = new BigInteger("12");
		BigInteger modValue = new BigInteger("4");
		
	return value.remainder(modValue);
	}
}