package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtils {
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	public void satrtReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dire") + "test-output/ExtentSparkReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Hostname", "KITS_Auto_Tests");
		extent.setSystemInfo("Username", "rakesh@kits");
		extent.setSystemInfo("Environment", "TeamCI");

		spark.config().setDocumentTitle("Title of the Report");
		spark.config().setReportName("Name of the report");
		spark.config().setTheme(Theme.STANDARD);
	}
}
