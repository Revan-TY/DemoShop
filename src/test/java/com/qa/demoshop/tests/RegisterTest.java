package com.qa.demoshop.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoshop.base.BasePage;
import com.qa.demoshop.dataproviders.RegisterDataProvider;
import com.qa.demoshop.utilities.FakeDataGenerator;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("e-commerce")
public class RegisterTest extends BasePage {

	@Test(priority = 0)
	@Story("verify register page")
	@Feature("register")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Revan")
	public void verifyRegisterPage() {
		home.clickRegisterLink();
		Assert.assertEquals(register.getRegisterHeader(), "Register");
		System.out.println("====[ VERIFIED REGISTER PAGE====");
		
	}

	@Test(priority = 1 )
	public void registerShopper() {
		home.clickRegisterLink();
		String rEmail = "virat" + RandomStringUtils.randomAlphanumeric(5) + "@gamil.com";
		register.registerUser("MALE", "admin", "adminer", rEmail, "admin@567", "admin@567");
		Assert.assertEquals(register.getSuccessMsg(), "Your registration completed");
		System.out.println("=======[" + register.getSuccessMsg() + "]======");
	}

	@Test(priority = 3, dataProvider = "registerdata", dataProviderClass = RegisterDataProvider.class, enabled = false)
	public void registerMultipleShopper(String gender, String fn, String ln, String email, String pass, String cpass) {
		home.clickRegisterLink();
		register.registerUser(gender, fn, ln, email, pass, cpass);
		Assert.assertEquals(register.getSuccessMsg(), "Your registration completed");
		System.out.println("====[" + register.getSuccessMsg() + "]===");

	}

	@Test(enabled = false)
	public void mouseHoveringOnComputer() throws InterruptedException {
		// Example to perform mouse actions
		home.perForMouseHoveringOnComputer();

	}

	@Test(enabled = false)
	public void generateFakeData() {

		System.out.println(FakeDataGenerator.getFistName());
		System.out.println(FakeDataGenerator.getlastName());
		System.out.println(FakeDataGenerator.getEmail());
		String pass = FakeDataGenerator.getPassword();
		System.out.println(pass);
		System.out.println(pass);
	}

}
