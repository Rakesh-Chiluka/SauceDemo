package com.saucedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.utils.CommonUtils;
import com.saucedemo.utils.ExtentUtils;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.saucedemo.pages.LoginPage;

public class BasePage {
	public static WebDriver driver;
	public static Properties properties;
	public static WebDriverWait wait;

	@BeforeSuite
	public void initiaLize() {
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentUtils.setUpExtentReports();
	}
	
	@BeforeClass
	public void createParentReport() {
		String className=getClass().getName();
		ExtentUtils.createTest(className);
	}	

	@BeforeMethod
	public void setUp(Method method) {
		Reporter.log("Launch browser and Navigate to Application");
		CommonUtils.launchBrowserAndNavigateToApp();
		ExtentUtils.createTest(method.getName());

	}

	@AfterMethod
	public void tearDown(ITestResult result, Method method) {
		if(result.getStatus()==ITestResult.FAILURE) {
			ExtentUtils.logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- Test case failed", ExtentColor.RED));
			ExtentUtils.logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test case failed", ExtentColor.RED));
			ExtentUtils.logger.fail("Test case is failed screenshot is below"+ExtentUtils.logger.addScreenCaptureFromPath(CommonUtils.captureScreenshot(method)));
		}
		Reporter.log("Browser is closed");
		driver.quit();
	}
	
	@AfterClass
	public void endParentReport() {
		ExtentUtils.endReport();
	}
	
	@AfterSuite
	public void endReport() {
		ExtentUtils.extent.flush();
	}

}
