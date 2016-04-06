package main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.CountBandwidthFormatFile;
import model.CountBrowser;
import model.CountSO;
import model.CountTimeNoAccess;
import model.CountVisitDistinctIP;
import util.Analysis;
import util.CountTime;

public class MainApplication {
	private CountTime countTime = new CountTime();
	private List<Analysis> analysisList = new ArrayList<>();
	

	public static void main(String[] args) throws Exception {
		new MainApplication();
	}

	public MainApplication() throws Exception {
		addAnalysis();
		
		List<String> fileLines;
		fileLines = Files.readAllLines(Paths.get(new File("").getAbsolutePath().concat("\\resources"), "access.log"));

		countTime.printCurrentTime("Start");

		analysisList.forEach(analysis -> {
			new Thread(() -> {
				fileLines.forEach(line -> analysis.collectInformation(line));

				analysis.showInformations();
				countTime.printCurrentTime(analysis.getClass().getSimpleName());
			}).start();
		});
	}

	public void addAnalysis() {
		analysisList.add(new CountVisitDistinctIP());
		analysisList.add(new CountBandwidthFormatFile());
		analysisList.add(new CountTimeNoAccess());
		analysisList.add(new CountSO());
		analysisList.add(new CountBrowser());
		
	}

}
