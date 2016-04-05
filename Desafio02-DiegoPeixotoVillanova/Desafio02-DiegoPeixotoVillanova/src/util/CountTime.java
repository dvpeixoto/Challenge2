package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CountTime {
	private long timeStart;
	private long timeEnd;

	public CountTime() {
	}

	public final void begin() {
		timeStart = timeNow("BEGIN");
	}

	public final void close() {
		timeEnd = timeNow("END");
		printDuration();
	}

	private long timeNow(String inf) {
		return Calendar.getInstance().getTimeInMillis();
	}

	private void printDuration() {
		printTime("\nBEGIN:", timeStart);
		printTime("END:", timeEnd);
	}

	private void printTime(String inf, long timeInMillis) {
		System.out.println(inf + ": " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(timeInMillis));
	}

}
