package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import util.Analysis;

public class CountTimeNoAccess implements Analysis {
	private LocalDateTime dateOld = null;
	private IntervalTimeDate interval1 = new IntervalTimeDate(0, null, null);
	private IntervalTimeDate interval2 = new IntervalTimeDate(0, null, null);
	private IntervalTimeDate interval3 = new IntervalTimeDate(0, null, null);

	public Long durationBetweenDates(LocalDateTime dateOld, LocalDateTime dateNew) {
		Duration dur = Duration.between(dateOld, dateNew);
		return dur.toMillis();
	}

	@Override
	public void collectInformation(String line) {
		String date = line.split(" - - ")[1].substring(1, 21);
		LocalDateTime dateNow = LocalDateTime.parse(date,
				DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH));

		if (dateOld != null) {
			long dur = (durationBetweenDates(dateOld, dateNow));
			saveDate(dur, dateOld, dateNow);
		}
		dateOld = dateNow;
	}

	public void saveDate(long durTemp, LocalDateTime dateOld, LocalDateTime dateNow) {
		if (interval1.getInterval() < durTemp) {
			interval3 = interval2;
			interval2 = interval1;
			interval1 = new IntervalTimeDate(durTemp, dateOld, dateNow);
		} else if (interval2.getInterval() < durTemp) {
			interval3 = interval2;
			interval2 = new IntervalTimeDate(durTemp, dateOld, dateNow);
		} else if (interval3.getInterval() < durTemp) {
			interval3 = new IntervalTimeDate(durTemp, dateOld, dateNow);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	public final String toString() {
		StringBuilder builder = new StringBuilder();

		return builder.append(interval1.toString() + interval2.toString() + interval3.toString()).toString();
	}

}
