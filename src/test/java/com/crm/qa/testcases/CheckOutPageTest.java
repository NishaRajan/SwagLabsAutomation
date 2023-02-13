package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.CheckOutPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.OverViewPage;
import com.crm.qa.util.TestUtil;

public class CheckOutPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OverViewPage overViewPage;
	TestUtil testUtil;
	String sheetName="contacts";
	
	public CheckOutPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		cartPage = homePage.addToCartClick();
		checkOutPage = cartPage.checkout();
		
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][]data= TestUtil.getTestData(sheetName);
		return data;	
	}
	@Test(dataProvider = "getCRMTestData")
	public void enterUserDetailsFromSheet(String firstname, String lastname,String postalcode) {
	
	overViewPage = checkOutPage.enterDetailsFromSheet(firstname,lastname,postalcode);
	}
	@Test
	public void enterUserDetails() {
		overViewPage = checkOutPage.enterDetails();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
