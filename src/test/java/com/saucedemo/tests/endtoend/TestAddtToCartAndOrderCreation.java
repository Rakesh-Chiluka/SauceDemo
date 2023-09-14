package com.saucedemo.tests.endtoend;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutCompletePage;
import com.saucedemo.pages.CheckoutInformationPage;
import com.saucedemo.pages.CheckoutOverviewPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductDetailsPage;
import com.saucedemo.pages.ShoppingCartPage;
import com.saucedemo.utils.CommonUtils;
import com.saucedemo.utils.ExtentUtils;

public class TestAddtToCartAndOrderCreation extends CommonUtils {

	@Test
	public void OrderCreationTest1() {
		String homePageUrl = "https://www.saucedemo.com/inventory.html";
		String productName = "Sauce Labs Backpack";
		String productDescritption = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
		String productPrice = "$29.99";
		String quantity = "1";
		String firstName = "Rakesh";
		String lastName = "Chiluka";
		String zipCode = "500092";
		String thankYouMessage = "Thank you for your order!";
		String orderDispatchMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		
//		ExtentUtils.createTest("Order Creation test1");
		Reporter.log("Login to the Application");
		LoginPage loginPage = new LoginPage();
		Assert.assertEquals(loginPage.getLogoText(), "Swag Labs");
		loginPage.login();

		Reporter.log("User navigates to home page and verifies Product name, description and Price");
		HomePage homePage = new HomePage();
		Assert.assertEquals(homePage.getProductName(), productName);
		Assert.assertEquals(homePage.getProductDescription(), productDescritption);
		Assert.assertEquals(homePage.getProductPrice(), productPrice);

		Reporter.log(
				"User navigates to product details page by clicking on Product link and verifies Product name, description and Price");
		ProductDetailsPage productDetailsPage = homePage.clickOnProductLinkAndNavigatesToProductDetailsPage();
		Assert.assertEquals(productDetailsPage.getProductName(), productName);
		Assert.assertEquals(productDetailsPage.getProductDescription(), productDescritption);
		Assert.assertEquals(productDetailsPage.getProductPrice(), productPrice);

		Reporter.log("User clicks on Add to cart button and verifies the product quantity");
		productDetailsPage.clickOnAddToCartButton();
		Assert.assertEquals(productDetailsPage.getQuantityFromAddedToCart(), quantity);

		Reporter.log(
				"User navigates to Shopping cart page by clicking on shopping cart link and verifies Product name, description, Price and quantity ");
		ShoppingCartPage shoppingCartPage = productDetailsPage.clickOnShoppingCartLink();
		Assert.assertEquals(shoppingCartPage.getProductName(), productName);
		Assert.assertEquals(shoppingCartPage.getProductDescription(), productDescritption);
		Assert.assertEquals(shoppingCartPage.getProductPrice(), productPrice);
		Assert.assertEquals(shoppingCartPage.getQuantity(), quantity);

		Reporter.log("User navigates to Checkout Informaion page by clicking on Checkout button");
		CheckoutInformationPage checkoutInformationPage = shoppingCartPage
				.clickOnCheckoutButtonAndNavigatesToCheckoutInformationPage();

		Reporter.log(
				"User enters customer details like firstname, Lastname and Zipcode in Checkout Information page and clicks on continue button");
		CheckoutOverviewPage checkOutOverViewPage = checkoutInformationPage.enterCustomerDetails(firstName, lastName,
				zipCode);

		Reporter.log(
				"User navigates to Checkout overview page and verifies Product name, description, Price and quantity");
		Assert.assertEquals(checkOutOverViewPage.getProductName(), productName);
		Assert.assertEquals(checkOutOverViewPage.getProductDescription(), productDescritption);
		Assert.assertEquals(checkOutOverViewPage.getProductPrice(), productPrice);
		Assert.assertEquals(checkOutOverViewPage.getQuantity(), quantity);

		Reporter.log(
				"User navaigates to Checkout complete page and verifies complete image, Thank you message and Order dispatch message ");
		CheckoutCompletePage checkoutCompletePage = checkOutOverViewPage.clickFinishButton();
		Assert.assertTrue(checkoutCompletePage.isCompleteImageDisplayed());
		Assert.assertEquals(checkoutCompletePage.getThankYouMessage(), thankYouMessage);
		Assert.assertEquals(checkoutCompletePage.getOrderDispatchMessage(), orderDispatchMessage);

		Reporter.log("User navigates to Home page by clicking on Back to home button and verifies the current url");
		checkoutCompletePage.clickBackToHomeButton();
		Assert.assertEquals(homePage.getCurrentUrl(), homePageUrl);
		Assert.assertTrue(false);
	}

	@Test
	public void OrderCreationTest2() {
		//ExtentUtils.createTest("Order creation test2");
		System.out.println("Order creation 2 is implemented");

	}
}
