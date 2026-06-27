package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class BooksPage extends BrowserInitialization{
	
	private By firstBook = By.xpath("(//input[@value='Add to cart'])[1]");
	public BooksPage(WebDriver driver) {
		super(driver);
	}
	public void clickAddToCartOfFistProduct() {
		WaitUtility.checkElementIsVisible(driver, firstBook).click();
	}

}
