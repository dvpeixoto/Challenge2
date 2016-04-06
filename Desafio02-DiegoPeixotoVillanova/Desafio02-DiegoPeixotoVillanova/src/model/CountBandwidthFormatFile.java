package model;

import util.Analysis;
import util.Constant;

public class CountBandwidthFormatFile extends AbstractCount implements Constant, Analysis {

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(JPG_PATTERN) != -1) {
			addBandWithInMap(line, JPG_PATTERN);
		}
		if (line.indexOf(PNG_PATTERN) != -1) {
			addBandWithInMap(line, PNG_PATTERN);
		}
		if (line.indexOf(GIF_PATTERN) != -1) {
			addBandWithInMap(line, GIF_PATTERN);
		}
		if (line.indexOf(JS_PATTERN) != -1) {
			addBandWithInMap(line, JS_PATTERN);
		}
		if (line.indexOf(CSS_PATTERN) != -1) {
			addBandWithInMap(line, CSS_PATTERN);
		}
		if (line.indexOf(TXT_PATTERN) != -1) {
			addBandWithInMap(line, TXT_PATTERN);
		}
		if (line.indexOf(CSV_PATTERN) != -1) {
			addBandWithInMap(line, CSV_PATTERN);
		}
		if (line.indexOf(I_PATTERN) != -1) {
			addBandWithInMap(line, I_PATTERN);
		}
		if (line.indexOf(DOCX_PATTERN) != -1) {
			addBandWithInMap(line, DOCX_PATTERN);
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
