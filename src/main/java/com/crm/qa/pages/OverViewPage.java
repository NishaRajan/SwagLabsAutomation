package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class OverViewPage extends TestBase{
	@FindBy(className="summary_info_label")
	WebElement paymentInformation;
	
	@FindBy(className="summary_info_label")
	WebElement shippingInfo;
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	public OverViewPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkPresenceOfPaymentInformation() {
		return paymentInformation.isDisplayed();
	}
	public boolean checkPresenceOfShippingInfo() {
		return shippingInfo.isDisplayed();
	}
	public OrderCompletePage BtnClick() {
		finishBtn.click();
		return new OrderCompletePage();
	}

}
