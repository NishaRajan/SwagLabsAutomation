package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[@class='title']")
	WebElement heading;
	
	@FindBy(className="product_sort_container")
	WebElement select;
	
	@FindBy(className="inventory_item_name")
	WebElement lowpriceitem;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement bikeLight;
	
	@FindBy(className="shopping_cart_badge")
	WebElement cartLabel;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean selectLowPrice() {
		Select ddown= new Select(select);
		ddown.selectByIndex(2);
		return lowpriceitem.isDisplayed();
		}
	public CartPage addToCartClick() {
		bikeLight.click();
		cartLabel.click();
		return new CartPage();
	}

}
