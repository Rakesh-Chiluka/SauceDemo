package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.saucedemo.utils.CommonUtils;

public class CheckoutCompletePage extends CommonUtils {
	// By locators
	private final By BY_IMAGE = By.xpath("//img[@alt='Pony Express']");
	private final By BY_THANKYOUMESSAGE = By.xpath("//h2[@class='complete-header']");
	private final By BY_ORDERDISPATCHMESSAGE = By.xpath("//div[@class='complete-text']");
	private final By BY_BACKTOHOMEBUTTON = By.xpath("//button[@id='back-to-products']");

	// Action methods
	public boolean isImageDisplayed() {
		return false;
	}

	public String getThankYouMessage() {
		return getText(BY_THANKYOUMESSAGE);
	}

	public String getOrderDispatchMessage() {
		return getText(BY_ORDERDISPATCHMESSAGE);
	}

	public void clickBackToHomeButton() {
		click(BY_BACKTOHOMEBUTTON);
	}

	public boolean isCompleteImageDisplayed() {
		return isElementDisplayed(BY_IMAGE);
	}

}
