package com.qa.demoshop.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoshop.base.BasePage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CheckoutTest extends BasePage {

	static Logger log = LogManager.getLogger(CheckoutTest.class);

	@Test
	@Epic("e-commerce")
	@Story("valid checkout")
	@Feature("checkout")
	@Description("user valid checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Revan")
	public void checkoutProduct() {
		String rEmail = "virat" + RandomStringUtils.randomAlphanumeric(5) + "@gamil.com";
		home.clickRegisterLink();
		register.registerUser("MALE", "admin", "adminer", rEmail, "admin@567", "admin@567");
		log.info("user is registered successfully");
		Allure.step("user is registered successfully");
		home.clickOnBooks();
		bookpage.clickAddToCartOfFistProduct();
		log.info("product added to the cart successfully");
		Allure.step("product added to the cart successfully");
		home.clickShopingCartLink();
		cartPage.SelectCountryByVisibleText("India");
		cartPage.clickTermsOfService();
		cartPage.clickOnCheckOut();
		log.info("click on checkout button successfully");
		Allure.step("click on checkout button successfully");
		checkout.enterBillingAddress("India", "Banglore", "raj", "560010", "98765478768");
		checkout.clickOnShippingAddressContinue();
		log.info("Shipping added successfully");
		Allure.step("Shipping added successfully");
		checkout.clickOnShippingMethodContinue();
		log.info("selected shipped method ");
		Allure.step("selected shipped method ");
		checkout.clickOnPaymentMethodContinue();
		log.info("select payment method ");
		Allure.step("select payment method ");
		checkout.clickOnPaymentInformationContinue();
		log.info("confirmed payment information");
		Allure.step("confirmed payment information");
		checkout.clickOnConfirmOrder();
		log.info("order confirmed");
		Allure.step("order confirmed");
		Assert.assertEquals(thankyou.getSuccessMessage(), "Your order has been successfully processed!");

	}

}
