package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement bikeLight;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean checkCart() {
		return bikeLight.isDisplayed();
	}
	public CheckOutPage checkout() {
		 checkoutBtn.click();
		 return new CheckOutPage();
	}

}
