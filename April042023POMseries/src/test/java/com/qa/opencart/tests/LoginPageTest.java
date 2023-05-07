package com.qa.opencart.tests;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginPageUrlTest() {
        String actualUrl = loginPage.getLoginPageUrl();
        Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
    }

    @Test(priority = 3)
    public void forgotPasswordLinkTest() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
    }

    @Test(priority = 4)
    public void isRegisterLinkExistTest() {
        Assert.assertTrue(loginPage.isRegisterLinkExist());
    }

    @Test(priority = 5)
    public void doLoginTest() {
        accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    Assert.assertEquals(accountsPage.getaccountPageTitle(),Constants.ACCOUNTS_PAGE_TITLE);
    }



}

