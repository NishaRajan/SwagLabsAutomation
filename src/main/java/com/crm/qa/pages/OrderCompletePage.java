package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class OrderCompletePage extends TestBase {
	@FindBy(xpath="//h2[contains(text(),'THANK YOU')]")
	WebElement thankyoulabel;
	
	@FindBy(className="pony_express12345")
	WebElement img;
	
	@FindBy(id="back-to-products")
	WebElement backHomeBtn;
	
	public OrderCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean messageDisplayed() {
		return thankyoulabel.isDisplayed();
	}
	
	public boolean imageDisplayed() {
		return img.isDisplayed();
	}
	
	public HomePage btnClick() {
		backHomeBtn.click();
		return new HomePage();
	}

}
