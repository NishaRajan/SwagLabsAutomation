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
import com.crm.qa.util.TestUtil;

public class OverViewPageTest extends TestBase
{
	LoginPage login;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OverViewPage overViewPage;
	OrderCompletePage orderCompletePage;
	TestUtil testUtil;

	public OverViewPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
		login = new LoginPage();
		homePage = login.login(prop.getProperty("username"),prop.getProperty("password"));
		cartPage = homePage.addToCartClick();
		checkOutPage = cartPage.checkout();
		testUtil = new TestUtil();
		overViewPage = checkOutPage.enterDetails();
		}
	@Test
	public void paymentInfoDisplayed() {
		Boolean info = overViewPage.checkPresenceOfPaymentInformation();
		Assert.assertTrue(info);
	}
	@Test
	public void shippingInfoDisplayed() {
		Boolean shipinfo = overViewPage.checkPresenceOfShippingInfo();
		Assert.assertTrue(shipinfo);
	}
	@Test
	public void finishBtnClick() {
		orderCompletePage = overViewPage.BtnClick();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
