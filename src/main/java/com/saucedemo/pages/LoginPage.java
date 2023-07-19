package com.saucedemo.pages;

import org.openqa.selenium.By;
import com.saucedemo.utils.CommonUtils;

public class LoginPage extends CommonUtils {
	// By Locators
	private final By BY_USERNAME = By.id("user-name");
	private final By BY_PASSWORD = By.id("password");
	private final By BY_LOGINBUTTON = By.id("login-button");
	private final By BY_LOGINLOGO = By.xpath("//div[@class='login_logo']");

	// Action methods
	public void login() {
		enterValue(BY_USERNAME, properties.getProperty("username"));
		enterValue(BY_PASSWORD, properties.getProperty("password"));
		click(BY_LOGINBUTTON);
	}

	public String getLogoText() {
		return getText(BY_LOGINLOGO);
	}

}
