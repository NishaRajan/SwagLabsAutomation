package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialisation();
	    loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title =loginPage.validateLoginpageTitle();
		Assert.assertEquals(title,"Swag Labs");
	}
	
	@Test(priority=2)
	public void logoImageTest() {
		boolean image = loginPage.validatecrmImage();
		Assert.assertTrue(image);
		}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
