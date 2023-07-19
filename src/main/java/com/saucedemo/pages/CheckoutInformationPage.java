package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.saucedemo.utils.CommonUtils;

public class CheckoutInformationPage extends CommonUtils {
	// By locators
	private final By BY_FIRSTNAME = By.xpath("//input[@id='first-name']");
	private final By BY_LASTNAME = By.xpath("//input[@id='last-name']");
	private final By BY_ZIPCODE = By.xpath("//input[@id='postal-code']");
	private final By BY_CONTINUEBUTTON = By.xpath("//input[@id='continue']");

	// Action methods
	public CheckoutOverviewPage enterCustomerDetails(String firstName, String lastName, String zipCode) {
		enterValue(BY_FIRSTNAME, firstName);
		enterValue(BY_LASTNAME, lastName);
		enterValue(BY_ZIPCODE, zipCode);
		click(BY_CONTINUEBUTTON);
		return new CheckoutOverviewPage();
	}

}
