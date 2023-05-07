package com.qa.opencart.pages;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //1 Declare a private driver
    private WebDriver driver;
    private ElementUtil elementUtil;

    // 2 Create the page constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //3 By locators

    private By emailID = By.id("input-email");
    private By passWord = By.id("input-password");
    private By login = By.cssSelector("input[value =\"Login\"]");

    private By registerLink = By.linkText("Register");
    private By forgotPasswordLink = By.linkText("Forgotten Password");

    private By LoginErrMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");

    public String getLoginPageTitle() {
        return elementUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIMEOUT);
    }

    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isForgotPasswordLinkExist() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public boolean isRegisterLinkExist() {
        return driver.findElement(registerLink).isDisplayed();
    }

    public AccountsPage doLogin(String userName, String Password) {
        System.out.println("login with : " + userName + " : " + Password);
        elementUtil.doSendKeys(emailID, userName);
        elementUtil.doSendKeys(passWord, Password);
        elementUtil.doClick(login);
        return new AccountsPage(driver);
    }

    public Boolean doLoginWithWrongCredentials(String userName, String Password)
    {
        System.out.println("login with wrong credentials : " + userName + " : " + Password);
        elementUtil.doSendKeys(emailID, userName);
        elementUtil.doSendKeys(passWord, Password);
        elementUtil.doClick(login);
       String errorMessage =  elementUtil.doGetText(LoginErrMessage);
        System.out.println(errorMessage);
        if(errorMessage.contains(Constants.LOGIN_ERROR_MESSAGE))
        {
            System.out.println("login failed");
            return false;
        }
        return true;


    }
    
    public RegistrationPage goToRegisterPage()
    {
    	elementUtil.doClick(registerLink);
    	
    	return new RegistrationPage(driver);
    	
    }


}
