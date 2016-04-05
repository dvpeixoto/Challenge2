package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IntervalTimeDate {
	private long interval=0;
	private LocalDateTime date;
	private LocalDateTime dateBefore;

	public IntervalTimeDate(long interval, LocalDateTime date, LocalDateTime dateBefore) {
		this.interval = interval;
		this.date = date;
		this.dateBefore = dateBefore;
	}

	public long getInterval() {
		return interval;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public LocalDateTime getDateBefore() {
		return dateBefore;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setDateBefore(LocalDateTime dateBefore) {
		this.dateBefore = dateBefore;
	}
	
	@Override
	public String toString() {
		return "\nInterval time in minutes: " + (interval / 60000) + " and date: "
				+ date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " to "
				+ dateBefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

}
