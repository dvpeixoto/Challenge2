package model;

import util.Analysis;
import util.Constant;

public class CountBandwidthFormatFile extends AbstractCount implements Constant, Analysis {

	private void addBandWithInMap(String line, String pattern) {
		int positionPattern = line.indexOf(pattern) + pattern.length();
		int positionBeginBandWidht = positionPattern + 15;

		try {
			if (line.substring(positionPattern, positionBeginBandWidht).contains("200")) {
				String bandWidth = line.substring(positionBeginBandWidht, line.length()).split(" ")[0];
				addToKey(pattern, Integer.valueOf(bandWidth));
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(DOCX_PATTERN) != -1) {
			increment(DOCX_PATTERN);
		}
		if (line.indexOf(Constant.TXT_PATTERN) != -1) {
			addBandWithInMap(line, Constant.TXT_PATTERN);
		}
		if (line.indexOf(Constant.CSV_PATTERN) != -1) {
			addBandWithInMap(line, Constant.CSV_PATTERN);
		}
		if (line.indexOf(Constant.JPG_PATTERN) != -1) {
			addBandWithInMap(line, Constant.JPG_PATTERN);
		}
		if (line.indexOf(Constant.GIF_PATTERN) != -1) {
			addBandWithInMap(line, Constant.GIF_PATTERN);
		}
		if (line.indexOf(Constant.CSS_PATTERN) != -1) {
			addBandWithInMap(line, Constant.CSS_PATTERN);
		}
		if (line.indexOf(Constant.JS_PATTERN) != -1) {
			addBandWithInMap(line, Constant.JS_PATTERN);
		}
		if (line.indexOf(Constant.PNG_PATTERN) != -1) {
			addBandWithInMap(line, Constant.PNG_PATTERN);
		}
		if (line.indexOf(I_PATTERN) != -1) {
			increment(I_PATTERN);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	@Override
	String toStringTitle() {
		return "\n* Bandwidth most expansive value: \n";
	}

	@Override
	String toStringMessagePattern() {
		return "* The bandwidth format file %s with this value %s .\n";
	}

}
