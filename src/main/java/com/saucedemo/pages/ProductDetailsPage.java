package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.saucedemo.utils.CommonUtils;

public class ProductDetailsPage extends CommonUtils {
	// By locators
	private final By BY_PRODUCTNAME = By.xpath("//div[@class='inventory_details_name large_size']");
	private final By BY_PRODUCTDESCRIPTION = By.xpath("//div[@class='inventory_details_desc large_size']");
	private final By BY_PRODUCTPRICE = By.xpath("//div[@class='inventory_details_price']");
	private final By BY_ADDTOCARTBUTTON = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	private final By BY_QUANTITYADDEDTOCART = By.xpath("//span[@class='shopping_cart_badge']");
	private final By BY_SHOPPINGCARTLINK = By.xpath("//a[@class='shopping_cart_link']");

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

	public void clickOnAddToCartButton() {
		click(BY_ADDTOCARTBUTTON);
	}

	public String getQuantityFromAddedToCart() {
		return getText(BY_QUANTITYADDEDTOCART);
	}

	public ShoppingCartPage clickOnShoppingCartLink() {
		click(BY_SHOPPINGCARTLINK);
		return new ShoppingCartPage();
	}
}
