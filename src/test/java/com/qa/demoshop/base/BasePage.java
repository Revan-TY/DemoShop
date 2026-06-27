package com.qa.demoshop.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.demoshop.browserfactory.DriverFactory;
import com.qa.demoshop.pagelayers.BooksPage;
import com.qa.demoshop.pagelayers.CheckoutPage;
import com.qa.demoshop.pagelayers.HomePage;
import com.qa.demoshop.pagelayers.RegisterPage;
import com.qa.demoshop.pagelayers.ShoppingCartPage;
import com.qa.demoshop.pagelayers.ThankyouPage;
import com.qa.demoshop.utilities.PropertyUtility;

public class BasePage {
	WebDriver driver;
	public HomePage home;
	public RegisterPage register;
	public BooksPage bookpage;
	public ShoppingCartPage cartPage;
	public CheckoutPage checkout;
	public ThankyouPage thankyou;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional String browser) throws IOException {

		if (browser.isEmpty()) {
			browser = PropertyUtility.getProperty("browserName");
		}
		driver = DriverFactory.initDriver(browser, Boolean.parseBoolean(PropertyUtility.getProperty("headless")));
		driver.manage().window().maximize();
		driver.get(PropertyUtility.getProperty("testUrl"));
		home = new HomePage(driver);
		register = new RegisterPage(driver);
		bookpage = new BooksPage(driver);
		cartPage = new ShoppingCartPage(driver);
		checkout = new CheckoutPage(driver);
		thankyou = new ThankyouPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();

	}

}
