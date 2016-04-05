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
		analysisList.add(new CountVisitDistinctIP());
		analysisList.add(new CountSO());
		analysisList.add(new CountBrowser());
		analysisList.add(new CountBandwidthFormatFile());
		analysisList.add(new CountTimeNoAccess());

		countTime.begin();
		
		List<String> fileLines = Files
				.readAllLines(Paths.get(new File("").getAbsolutePath().concat("\\resources"), "access.log"));

		fileLines.forEach(line -> {
			analysisList.forEach(analysis -> analysis.collectInformation(line));
		});
		
		analysisList.forEach(analysis -> analysis.showInformations());
		
		countTime.close();
	}

}
