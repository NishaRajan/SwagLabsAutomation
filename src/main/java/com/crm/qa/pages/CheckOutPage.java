package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CheckOutPage extends TestBase {
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public CheckOutPage(){
		PageFactory.initElements(driver,this);
	}
	
	public OverViewPage enterDetailsFromSheet(String ftname,String ltname,String pcode) {
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		postalcode.sendKeys(pcode);
		continueBtn.click();
		return new OverViewPage();
	}
	public OverViewPage enterDetails() {
		firstname.sendKeys("Snow");
		lastname.sendKeys("White");
		postalcode.sendKeys("123456");
		continueBtn.click();
		return new OverViewPage();
	}

}
