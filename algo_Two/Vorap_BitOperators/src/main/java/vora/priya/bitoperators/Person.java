package vora.priya.bitoperators;

import java.util.ArrayList;

public class Person {
	private Mood myMood = new Mood();
	private ArrayList<String> myMoodList = new ArrayList<String>();

	public Person() {

	}
	// 00001000
	// 00001000

	public void addMood(int moodValue) {

		if (((moodValue | myMood.getCALM()) == myMood.getCALM())) {
			if (!(myMoodList.contains("CALM "))) {
				myMoodList.add("CALM ");
			}
		}
		if (((moodValue | myMood.getDREAMY()) == myMood.getDREAMY())) {
			if (!(myMoodList.contains("DREAMY "))) {
				myMoodList.add("DREAMY ");
			}
		}
		if (((moodValue | myMood.getENERGETIC()) == myMood.getENERGETIC())) {
			if (!(myMoodList.contains("ENERGETIC "))) {
				myMoodList.add("ENERGETIC ");
			}
		}
		if (((moodValue | myMood.getHAPPY()) == myMood.getENERGETIC())) {
			if (!(myMoodList.contains("HAPPY "))) {
				myMoodList.add("HAPPY ");
			}
		}
		if (((moodValue | myMood.getLOVING()) == myMood.getLOVING())) {
			if (!(myMoodList.contains("LOVING "))) {
				myMoodList.add("LOVING ");
			}
		}
		if (((moodValue | myMood.getMAD()) == myMood.getMAD())) {

			if (!(myMoodList.contains("MAD "))) {
				myMoodList.add("MAD ");
			}
		}
		if (((moodValue | myMood.getOPTIMISTIC()) == myMood.getOPTIMISTIC())) {
			if (!(myMoodList.contains("OPTIMISTIC "))) {
				myMoodList.add("OPTISMISTIC ");
			}
		}
		if (((moodValue | myMood.getSAD()) == myMood.getSAD())) {
			if (!(myMoodList.contains("SAD "))) {
				myMoodList.add("SAD ");
			}
		}
	}

	public static void printMoods(ArrayList<String> myMoodList) {
		System.out.println("List of Moods: ");
		for (String eachValue : myMoodList) {
			System.out.println(eachValue);
		}
	}

	public void removeMood(int moodValue) {
		String removeValue = "";

		if (((moodValue & myMood.getCALM()) == myMood.getCALM())) {
			removeValue += "CALM ";
		}
		if (((moodValue & myMood.getDREAMY()) == myMood.getDREAMY())) {
			removeValue += "DREAMY ";
		}
		if (((moodValue & myMood.getENERGETIC()) == myMood.getENERGETIC())) {
			removeValue += "ENERGETIC ";
		}
		if (((moodValue & myMood.getHAPPY()) == myMood.getHAPPY())) {
			removeValue += "HAPPY ";
		}
		if (((moodValue & myMood.getLOVING()) == myMood.getLOVING())) {
			removeValue += "LOVING ";
		}
		if (((moodValue & myMood.getMAD()) == myMood.getMAD())) {
			removeValue += "MAD ";
		}
		if (((moodValue & myMood.getOPTIMISTIC()) == myMood.getOPTIMISTIC())) {
			removeValue += "OPTIMISTIC ";
		}
		if (((moodValue & myMood.getSAD()) == myMood.getSAD())) {
			removeValue += "SAD ";
		}

		String[] removeArray = removeValue.split(" ");

		for (String value : removeArray) {
			for (int i = 0; i < myMoodList.size(); i++) {
				if (myMoodList.get(i).contains(value)) {
					myMoodList.remove(i);
				}
			}
		}

		if (myMoodList.isEmpty()) {
			System.out.println("NO MOOD....");
		}
	}

	public boolean hasMood(int moodValue) {
		return false;

	}

	public static void main(String[] args) {
		Person current = new Person();
		current.addMood(1);
		current.addMood(16);
		current.addMood(32);
		printMoods(current.myMoodList);
		current.removeMood(1);
		printMoods(current.myMoodList);
		// boolean hasMood = current.hasMood(1);
		// System.out.println("-- " + hasMood);
	}
}
