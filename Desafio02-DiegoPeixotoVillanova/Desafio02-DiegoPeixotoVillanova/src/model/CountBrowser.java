package model;

import util.Analysis;
import util.Constant;

public class CountBrowser extends AbstractCount implements Constant, Analysis {

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(CHROME_PATTERN) != -1) {
			increment(CHROME_PATTERN);
		}
		if (line.indexOf(MOZILLA_PATTERN) != -1) {
			increment(MOZILLA_PATTERN);
		}
		if (line.indexOf(SAFARI_PATTERN) != -1) {
			increment(SAFARI_PATTERN);
		}
		if (line.indexOf(MSIE_PATTERN) != -1) {
			increment(MSIE_PATTERN);
		}
		if (line.indexOf(OPERA_PATTERN) != -1) {
			increment(OPERA_PATTERN);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	@Override
	String toStringTitle() {
		return "\n*Most used browsers: \n";
	}

	@Override
	String toStringMessagePattern() {
		return "* The browser %s was used %s times.\n";
	}
}
