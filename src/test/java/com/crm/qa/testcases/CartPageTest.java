package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	
	@Test(priority = 1)
	public void checkPresenceOfCartItem() {
		Boolean value = cartPage.checkCart();
		Assert.assertTrue(value);
	}
	@Test(priority = 2)
	public void checkOutFromCart() {
		checkOutPage = cartPage.checkout();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
