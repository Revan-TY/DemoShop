package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.WaitUtility;

public class RegisterPage extends BrowserInitialization {

	private By gender_male = By.id("gender-male");
	private By gender_female = By.id("gender-female");
	private By firstName_TF = By.id("FirstName");
	private By lastName_TF = By.id("LastName");
	private By email_TF = By.name("Email");
	private By password_TF = By.id("Password");
	private By ConfirmPassword_TF = By.id("ConfirmPassword");
	private By registerButton = By.id("register-button");
	private By successMsg = By.xpath("//div[@class='result']");
	private By registerHeader = By.xpath("//div[@class='page-title']/h1");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void registerUser(String gender, String fistname, String lastname, String email, String password,
			String confirmPassword) {
		if (gender.equals("MALE")) {
			WaitUtility.checkElementIsVisible(driver, gender_male).click();
		} else if (gender.equals("FEMALE")) {
			WaitUtility.checkElementIsVisible(driver, gender_female).click();
		}
		driver.findElement(firstName_TF).sendKeys(fistname);
		driver.findElement(lastName_TF).sendKeys(lastname);
		driver.findElement(email_TF).sendKeys(email);
		driver.findElement(password_TF).sendKeys(password);
		driver.findElement(ConfirmPassword_TF).sendKeys(confirmPassword);
		driver.findElement(registerButton).click();

	}

	public String getSuccessMsg() {
		return WaitUtility.checkElementIsVisible(driver, successMsg).getText();
	}

	public String getRegisterHeader() {
		return WaitUtility.checkElementIsVisible(driver, registerHeader).getText();

	}
}
