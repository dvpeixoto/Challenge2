
package model;

import util.Analysis;
import util.Constant;

public class CountSO extends AbstractCount implements Constant, Analysis {

	@Override
	public void collectInformation(String line) {
		if (line.indexOf(WINDOWS_PATTERN) != -1) {
			increment(WINDOWS_PATTERN);
		}
		if (line.indexOf(LINUX_PATTERN) != -1) {
			increment(LINUX_PATTERN);
		}
		if (line.indexOf(MAC_PATTERN) != -1) {
			increment(MAC_PATTERN);
		}
		if (line.indexOf(ANDROID_PATTERN) != -1) {
			increment(ANDROID_PATTERN);
		}
		if (line.indexOf(IPHONE_PATTERN) != -1) {
			increment(IPHONE_PATTERN);
		}
	}

	@Override
	public void showInformations() {
		System.out.println(toString());
	}

	@Override
	String toStringTitle() {
		return "* Most used operational system: \n";
	}

	@Override
	String toStringMessagePattern() {
		return "* The System %s was used %s times.\n";
	}
	
}
