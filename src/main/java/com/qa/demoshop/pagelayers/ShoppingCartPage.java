package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.DropDownUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class ShoppingCartPage extends BrowserInitialization{

	private By countryDropDown = By.id("CountryId");
	private By checkout = By.id("checkout");
	private By termsofservice = By.id("termsofservice");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void SelectCountryByVisibleText(String countryName) {
		DropDownUtility.selectByVisibleText
		(WaitUtility.checkElementIsVisible(driver, countryDropDown), countryName);
	}

	public void clickOnCheckOut() {
		WaitUtility.checkElementIsVisible(driver, checkout).click();
	}

	public void clickTermsOfService() {
		WaitUtility.checkElementIsVisible(driver, termsofservice).click();
	}
}
