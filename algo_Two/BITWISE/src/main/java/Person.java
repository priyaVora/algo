import javax.naming.ldap.StartTlsRequest;

public class Person {
	String person = "Person is: ";

	public void Person(int flag) {

	}

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		Person p = new Person();
		p.addMood(4);
		p.addMood(16);
	}

	public void addMood(int flag) {
		Mood m = new Mood();

		if ((flag & m.getMAD()) == m.getMAD()) {
			person += "MAD ";
		}
		if ((flag & m.getSAD()) == m.getSAD()) {
			person += "SAD ";
		}
		if ((flag & m.getCALM()) == m.getCALM()) {
			person += "CALM ";
		}
		if ((flag & m.getDREAMY()) == m.getDREAMY()) {
			person += "DREAMY ";
		}
		if ((flag & m.getENERGETIC()) == m.getENERGETIC()) {
			person += "ENERGETIC ";
		}
		if ((flag & m.getHAPPY()) == m.getHAPPY()) {
			person += "HAPPY ";
		}
		if ((flag & m.getLOVING()) == m.getLOVING()) {
			person += "LOVING ";
		}
		if ((flag & m.getOPTIMISTIC()) == m.getOPTIMISTIC()) {
			person += "OPTIMISTIC ";
		}

		System.out.println("Mood: " + person);
	}

}
