package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import util.Analysis;

public class CountTimeNoAccess implements Analysis {
	private List<IntervalTimeDate> intervalTimeDateList = new ArrayList<>();
	private LocalDateTime dateOld = null;

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
			intervalTimeDateList.add(new IntervalTimeDate(dur, dateOld));
		}

		dateOld = dateNow;
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	public final String toString() {
		return intervalTimeDateList.stream().sorted(Comparator.comparing(IntervalTimeDate::getInterval).reversed())
				.limit(3).collect(Collectors.toList()).toString();
	}
	
}
