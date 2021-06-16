package com.automation.livelo.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ReportTest {
	static ExtentTest test;
	static ExtentReports report;

	public static void startRelatorio() {

		String dateName = new SimpleDateFormat("dd-MM-yyyy hh").format(new Date());
		String nomePasta = "LIVELO_AUTOMACAO_" + dateName;


		report = new ExtentReports(
				"..\\livelo\\target\\reports\\" + nomePasta + "\\" + "LIVELO_AUTOMACAO_" + "REPORT.html", false);

	}
	
	public static void startCenario(String nameScenario) {
		test = report.startTest(nameScenario);
	}

	public static void setLogStatus(LogStatus log, String msg) {
		test.log(log, msg);
	}

	public static void endRelatorio() {
		report.endTest(test);
		report.flush();
	}

}
