package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IntervalTimeDate {
	private long interval;
	private LocalDateTime date;

	public IntervalTimeDate(long interval, LocalDateTime date) {
		this.interval = interval;
		this.date = date;
	}

	public long getInterval() {
		return interval;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "\nInterval time in minutes: " + (interval/60000) + " and date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

}
