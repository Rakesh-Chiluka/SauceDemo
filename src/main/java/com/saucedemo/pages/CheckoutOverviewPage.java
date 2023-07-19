package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.saucedemo.utils.CommonUtils;

public class CheckoutOverviewPage extends CommonUtils {
	// By locators
	private final By BY_PRODUCTNAME = By.xpath("//div[@class='inventory_item_name']");
	private final By BY_PRODUCTDESCRIPTION = By.xpath("//div[@class='inventory_item_desc']");
	private final By BY_PRODUCTPRICE = By.xpath("//div[@class='inventory_item_price']");
	private final By BY_QUANTITY = By.xpath("//div[@class='cart_quantity']");
	private final By BY_FINISHBUTTON = By.xpath("//button[@id='finish']");

	// Action methods
	public String getQuantity() {
		return getText(BY_QUANTITY);
	}

	public String getProductName() {
		return getText(BY_PRODUCTNAME);
	}

	public String getProductDescription() {
		return getText(BY_PRODUCTDESCRIPTION);
	}

	public String getProductPrice() {
		return getText(BY_PRODUCTPRICE);
	}

	public CheckoutCompletePage clickFinishButton() {
		click(BY_FINISHBUTTON);
		return new CheckoutCompletePage();
	}

}
