package com.saucedemo.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.base.BasePage;

public class CommonUtils extends BasePage {

	public static void launchBrowserAndNavigateToApp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	public static WebElement findElement(By by) {
		WebElement element = null;
		try {
			element = driver.findElement(by);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public static void enterValue(By by, String value) {
		try {
			waitForElementToBeVisible(by);
			findElement(by).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void click(By by) {
		try {
			waitForElementToBeVisible(by);
			findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getText(By by) {
		String text = null;
		try {
			waitForElementToBeVisible(by);
			text = findElement(by).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static boolean isElementDisplayed(By by) {
		boolean flag = false;
		try {
			waitForElementToBeVisible(by);
			flag = findElement(by).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean waitForElementToBeVisible(By by) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(properties.getProperty("loadTime"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
