package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;




public class RegistrationPage {
		
private WebDriver driver;
private ElementUtil elementUtil;

public RegistrationPage(WebDriver driver)
{
	this.driver = driver;
	elementUtil = new ElementUtil(driver); 
}

private By email = By.id("input-email");
private By firstName= By.id("input-firstname");
private By lastName = By.id("input-lastname");
private By telePhone = By.id("input-telephone");
private By passWord = By.id("input-password");
private By confirmPassword = By.id("input-confirm");
private By radioButtonYes = By.cssSelector("div>label>input[value ='1'][name='newsletter']");
private By radioButtonNo = By.cssSelector("div>label>input[value ='0'][name='newsletter']");
private By agreeCheckBox = By.cssSelector("input[type='checkbox']");
private By submitButton = By.cssSelector("input[type='submit']");
private By successMessage = By.cssSelector("div#content h1");
private By registerLink = By.linkText("Register");
private By logoutLink = By.linkText("Logout");

public boolean accountRegistration(String firstName, String lastName,String email,String telePhone,String password,String subscribe)
{
	elementUtil.doSendKeys(this.firstName,firstName);
	elementUtil.doSendKeys(this.lastName,lastName);
	elementUtil.doSendKeys(this.email,email);
	elementUtil.doSendKeys(this.telePhone,telePhone);
	elementUtil.doSendKeys(passWord,password);
	elementUtil.doSendKeys(confirmPassword,password);
	
	if(subscribe.equals("yes"))
	{
		elementUtil.doClick(radioButtonYes);
	}
	else {
	elementUtil.doClick(radioButtonNo);		
		}
	
	elementUtil.doClick(agreeCheckBox);
	elementUtil.doClick(submitButton);
	String message =	elementUtil.waitForElementToBeVisible(successMessage, 5, 1000).getText();	
	
	if(message.contains(Constants.REGISTER_SUCCESS_MESSAGE))
	{	
	elementUtil.doClick(logoutLink);
	elementUtil.doClick(registerLink);
		return true;
	}
   return false;
	
}
}






