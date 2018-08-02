public class DurationFormat {

	public static void main(String[] args) {
		System.out.println(formatDuration(0));
		System.out.println(formatDuration(15731080));
		System.out.println(formatDuration(132030240));
	}

	public static String formatDuration(int seconds) {
		final int secondsInAYear = 31536000;
		String result = "";
		int years = 0;
		while (seconds >= secondsInAYear) {
			years++;
			seconds -= secondsInAYear;
		}
		String year = "";
		if (years != 0) {
			year = (years > 1) ? "years" : "year";
		}
		final int secondsInDay = 86400;
		int days = 0;
		while (seconds >= secondsInDay) {
			days++;
			seconds -= secondsInDay;
		}
		String dayString = "";
		if (days != 0) {
			dayString = (days > 1) ? "days" : "day";
		}
		int hour = 0;
		final int secondsInHour = 3600;
		while (seconds >= secondsInHour) {
			hour++;
			seconds -= secondsInHour;
		}

		String hours = "";
		if (hour != 0) {
			hours = (hour > 1) ? "hours" : "hour";
		}

		int minutes = 0;
		final int secondsInMinute = 60;
		while (seconds >= secondsInMinute) {
			minutes++;
			seconds -= secondsInMinute;
		}
		String minute = "";
		if (minutes != 0) {
			minute = (minutes > 1) ? "minutes" : "minute";
		}
		String second = (seconds > 0) ? (seconds > 1) ? "seconds" : "second" : "";
		result += (!year.isEmpty()) ? years + " " + year : "";
		result += (!dayString.isEmpty()) ? (!result.isEmpty()) ? ", " + days + " " + dayString : days + " " + dayString
				: "";
		result += (!hours.isEmpty()) ? (!result.isEmpty()) ? ", " + hour + " " + hours : hour + " " + hours : "";
		result += (!minute.isEmpty()) ? (!result.isEmpty()) ? ", " + minutes + " " + minute : minutes + " " + minute
				: "";
		result += (!second.isEmpty()) ? (!result.isEmpty()) ? " and " + seconds + " " + second : seconds + " " + second
				: "";
		if (!result.contains("seconds") && !result.contains("second")) {
			String[] parsedResult = result.split(", ");
			if(parsedResult.length>1) {
				parsedResult[parsedResult.length-2]+=" and ";
				result="";
				for(int i=0;i<parsedResult.length;i++) {
					if(!parsedResult[i].contains("and")&&i!=parsedResult.length-1) {
						result += parsedResult[i] + ", ";
					} else {
						result+=parsedResult[i];
					}
				}
			}
		}
		result += (!result.isEmpty()) ? "" : "now";
		return result.trim();
	}

}
