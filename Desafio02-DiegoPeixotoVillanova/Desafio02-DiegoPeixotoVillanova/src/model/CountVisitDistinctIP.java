package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import util.Analysis;
import util.Constant;

public class CountVisitDistinctIP implements Constant, Analysis {
	private Map<String, LocalDateTime> dataAnalisysDistinctIP = new HashMap<>();
	private final int timeOut = 1800000;
	private int countDistinctIp = 0;

	public boolean otherIPVisitLimit(LocalDateTime dateOld, LocalDateTime dateNew) {
		Duration dur = Duration.between(dateOld, dateNew);
		return (dur.toMillis() > timeOut);
	}

	public int getCountDistinctIp() {
		return countDistinctIp;
	}

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(IP_PATTERN) != -1) {

			String[] ipsValid = line.split("- -")[0].split(" ");
			String ipValidLine = ipsValid[ipsValid.length - 1];
			String date = line.split(" - - ")[1].substring(1, 21);

			LocalDateTime stringToDate = LocalDateTime.parse(date,
					DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH));

			LocalDateTime dateTemp = dataAnalisysDistinctIP.get(ipValidLine);

			if (dateTemp != null) {
				if (otherIPVisitLimit(dateTemp, stringToDate)) {
					dataAnalisysDistinctIP.put(ipValidLine, stringToDate);
					countDistinctIp++;
				}
			} else {
				dataAnalisysDistinctIP.put(ipValidLine, stringToDate);
				countDistinctIp++;
			}
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());

	}

	@Override
	public String toString() {
		return "* Total visits distincts by IP: " + countDistinctIp + "\n";
	}

}
