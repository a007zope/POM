package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	@BeforeClass
	public void setupRegistration()
	{
		registrationPage =loginPage.goToRegisterPage();
	}
	
	
	public String getRandomEmail()
	{
		Random randomGenerator = new Random();
		
		String email ="aprilautomation"+randomGenerator.nextInt(1000)+"@gmail.com";
		System.out.println(email);
		
		return email;
		
	}

	@DataProvider
	public Object [][] getRegisterData(){
	return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}

	@Test(dataProvider ="getRegisterData")
	public void userRegistrationTest(String firstName, String lastName,String telePhone,String password,String subscribe)
	{
		//Assert.assertTrue(registrationPage.accountRegistration("prashant", "LN", "pr3@yopmail.com", "9099777","test@123","yes"));
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName, getRandomEmail(), telePhone, password, subscribe));
	}
}
