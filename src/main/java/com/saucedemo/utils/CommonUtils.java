package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.base.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils extends BasePage {

	public static void launchBrowserAndNavigateToApp() {
		WebDriverManager.chromiumdriver().setup();
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
	
	public static String captureScreenshot(Method method) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/screenshots/"+method.getName()+"_"+new SimpleDateFormat("yyyyMMdd_HH").format(new Date())+".png");
		String failedScreenshotPath=dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return failedScreenshotPath;
	}

}
