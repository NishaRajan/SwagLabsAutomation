package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
	    loginPage = new LoginPage();
	    homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void sortByPrice() {
		Boolean value = homePage.selectLowPrice();
		Assert.assertTrue(value);
	}
	@Test(priority = 2)
	public void addToCart() {
		cartPage = homePage.addToCartClick();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
