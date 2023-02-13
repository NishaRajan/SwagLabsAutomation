package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement loginLogo;
	
	@FindBy(xpath="//div[@class='bot_column']")
	WebElement loginImg;
	
	public LoginPage(){
	PageFactory.initElements(driver,this);	
	}
	
	public String validateLoginpageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatecrmImage() {
		return loginImg.isDisplayed();
}
	public HomePage login(String un,String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
	}
			
	

}
