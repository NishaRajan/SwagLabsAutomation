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
import com.crm.qa.pages.OrderCompletePage;
import com.crm.qa.pages.OverViewPage;

public class OrderCompletePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OverViewPage overViewPage;
	OrderCompletePage orderCompletePage;
	
	public OrderCompletePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = homePage.addToCartClick();
		checkOutPage = cartPage.checkout();
		overViewPage = checkOutPage.enterDetails();
		orderCompletePage = overViewPage.BtnClick();
		}
	@Test(priority = 1)
	public void thankYouMessagedisplayed() {
		Boolean msg = orderCompletePage.messageDisplayed();
		Assert.assertTrue(msg);
	}
	@Test(priority = 2)
	public void ponyExpressImageDisplayed() {
		Boolean img = orderCompletePage.imageDisplayed();
		Assert.assertTrue(img);
	}
	@Test(priority = 3)
	public void backHomeBtnClick() {
		homePage = orderCompletePage.btnClick();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
