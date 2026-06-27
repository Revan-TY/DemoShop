package com.qa.demoshop.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoshop.utilities.DropDownUtility;
import com.qa.demoshop.utilities.WaitUtility;

public class CheckoutPage extends BrowserInitialization {

	private By billingAddressHeader = By.xpath("//h2[.='Billing address']");
	private By countryDropdown = By.id("BillingNewAddress_CountryId");
	private By billingNewAddress_City = By.id("BillingNewAddress_City");
	private By billingNewAddress_Address1 = By.id("BillingNewAddress_Address1");
	private By billingNewAddress_ZipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
	private By billingNewAddress_PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
	private By billingNewAddress_ContinueBtn = By
			.xpath("//div[@id='billing-buttons-container']/input[@title='Continue' and @value='Continue']");
	private By shippingAddressContinueBtn = By.xpath("//input[@onclick='Shipping.save()']");
	private By shippingMethodContinueBtn = By.xpath("//input[@onclick='ShippingMethod.save()']");
	private By paymentMethodContinueBtn = By.xpath("//input[@onclick='PaymentMethod.save()']");
	private By paymentInformationContinueBtn = By.xpath("//input[@onclick='PaymentInfo.save()']");
	private By confirmOrderBtn = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void enterBillingAddress(String country, String city, String address1, String zipCode, String phoneNumber) {
		WaitUtility.checkElementContainsText(driver, billingAddressHeader, "Billing Address");
		DropDownUtility.selectByVisibleText(driver.findElement(countryDropdown), country);
		driver.findElement(billingNewAddress_City).sendKeys(city);
		driver.findElement(billingNewAddress_Address1).sendKeys(address1);
		driver.findElement(billingNewAddress_ZipPostalCode).sendKeys(zipCode);
		driver.findElement(billingNewAddress_PhoneNumber).sendKeys(phoneNumber);
		driver.findElement(billingNewAddress_ContinueBtn).click();
	}

	public void clickOnShippingAddressContinue() {
		WaitUtility.checkElementIsVisible(driver, shippingAddressContinueBtn).click();
	}

	public void clickOnShippingMethodContinue() {
		WaitUtility.checkElementIsVisible(driver, shippingMethodContinueBtn).click();
	
	}

	public void clickOnPaymentMethodContinue() {
		WaitUtility.checkElementIsVisible(driver, paymentMethodContinueBtn).click();
	}

	public void clickOnPaymentInformationContinue() {
		WaitUtility.checkElementIsVisible(driver, paymentInformationContinueBtn).click();
	}

	public void clickOnConfirmOrder() {
		WaitUtility.checkElementIsVisible(driver, confirmOrderBtn).click();
	}
	
}
