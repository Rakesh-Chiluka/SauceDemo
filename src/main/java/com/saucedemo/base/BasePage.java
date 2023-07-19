package com.saucedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.utils.CommonUtils;
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
	}

	@BeforeMethod
	public void setUp() {
		Reporter.log("Launch browser and Navigate to Application");
		CommonUtils.launchBrowserAndNavigateToApp();

		Reporter.log("Login to the Application");
		LoginPage loginPage = new LoginPage();
		Assert.assertEquals(loginPage.getLogoText(), "Swag Labs");
		loginPage.login();
	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("Browser is closed");
		driver.quit();
	}

}
