package com.qa.demoshop.utilities;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

	static Faker faker = new Faker();

	public static String getFistName() {
		return faker.name().firstName();
	}

	public static String getlastName() {
		return faker.name().lastName();
	}

	public static String getEmail() {
		return faker.internet().emailAddress();
	}

	public static String getPassword() {
		return faker.internet().password(6, 8, true, true);
	}

//	public static String fakeNumber()
//	{
//		    String number = faker.number().digits(1);
//		    
//		    if(number>5)
//		    {
//		    	return "MALE";
//		    }
//		    return "FEMALE";
//	}

}
