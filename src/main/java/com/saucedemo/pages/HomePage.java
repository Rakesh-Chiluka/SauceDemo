package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.saucedemo.utils.CommonUtils;

public class HomePage extends CommonUtils {
	// By locators
	private final By BY_PRODUCTNAME = By.xpath("//div[text()='Sauce Labs Backpack']");
	private final By BY_PRODUCTDESCRIPTION = By.xpath("//div[text()='Sauce Labs Backpack']/following::div[1]");
	private final By BY_PRODUCTPRICE = By.xpath("//div[text()='Sauce Labs Backpack']/following::div[3]");

	// Action methods
	public String getProductName() {
		return getText(BY_PRODUCTNAME);
	}

	public String getProductDescription() {
		return getText(BY_PRODUCTDESCRIPTION);
	}

	public String getProductPrice() {
		return getText(BY_PRODUCTPRICE);
	}

	public ProductDetailsPage clickOnProductLinkAndNavigatesToProductDetailsPage() {
		click(BY_PRODUCTNAME);
		return new ProductDetailsPage();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}