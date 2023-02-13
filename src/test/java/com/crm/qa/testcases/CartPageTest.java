package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.CheckOutPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	
	
	public CartPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		cartPage = homePage.addToCartClick();	
		}
	
	public void checkPresenceOfCartItem() {
		Boolean value = cartPage.checkCart();
		Assert.assertTrue(value);
	}
	
	public void checkOutFromCart() {
		checkOutPage = cartPage.checkout();
	}

}
