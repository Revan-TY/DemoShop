package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.MouseActionsUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class HomePage extends BrowserInitialization{

	private By registerLink = By.xpath("//a[@href='/register']");
	private By computerHeader = By.xpath("//div[@class='header-menu']/ul/li/a[@href='/computers']");
	private By booksTab = By.xpath("//ul[@class='top-menu']/li[1]/a[contains(.,'Books')]");
	private By shoppingCartLink = By.xpath("//span[.='Shopping cart']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickRegisterLink() {
		WaitUtility.checkElementIsVisible(driver, registerLink).click();
	}

	public void clickShopingCartLink() {
		WaitUtility.checkElementIsVisible(driver, shoppingCartLink).click();
	}

	public void perForMouseHoveringOnComputer() {// Example To perform Mouse actions
		MouseActionsUtility.mouseHowering(driver, WaitUtility.checkElementIsVisible(driver, computerHeader));
	}

	public void clickOnBooks() {
		WaitUtility.checkElementIsVisible(driver, booksTab).click();
	}

}
