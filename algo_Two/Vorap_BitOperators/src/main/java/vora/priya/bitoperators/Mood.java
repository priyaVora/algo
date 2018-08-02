package vora.priya.bitoperators;

public class Mood {
	private final int MAD = 1;
	private final int SAD = 2;
	private final int CALM = 4;
	private final int HAPPY = 8;
	private final int LOVING = 16;
	private final int DREAMY = 32;
	private final int OPTIMISTIC = 64;
	private final int ENERGETIC = 128;

	public Mood() {

	}

	public int getMAD() {
		return MAD;
	}

	public int getSAD() {
		return SAD;
	}

	public int getCALM() {
		return CALM;
	}

	public int getHAPPY() {
		return HAPPY;
	}

	public int getLOVING() {
		return LOVING;
	}

	public int getDREAMY() {
		return DREAMY;
	}

	public int getOPTIMISTIC() {
		return OPTIMISTIC;
	}

	public int getENERGETIC() {
		return ENERGETIC;
	}

	public  String findValue(int val) {
		if (getCALM() == val) {
			return "CALM ";
		} else if (getDREAMY() == val) {
			return "DREAMY ";
		} else if (getENERGETIC() == val) {
			return "ENERGETIC ";
		} else if (getHAPPY() == val) {
			return "HAPPY ";
		} else if (getLOVING() == val) {
			return "LOVING ";
		} else if (getMAD() == val) {
			return "MAD ";
		} else if (getOPTIMISTIC() == val) {
			return "OPTIMISITC ";
		} else if (getSAD() == val) {
			return "SAD ";
		}
		return null;
	}

}
