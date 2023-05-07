package com.qa.opencart.tests;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {

    DriverFactory df ;
    WebDriver driver;
    LoginPage loginPage;
    AccountsPage accountsPage;
  SearchResultsPage searchResultsPage;
ProductInfoPage productInfoPage;
RegistrationPage registrationPage;

    Properties prop;
    SoftAssert softAssert;
    @BeforeTest
    public void setUp()
    {
        df = new DriverFactory();
        prop =df.init_prop();
        driver =df.init_Driver(prop);
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productInfoPage = new ProductInfoPage(driver);
        softAssert = new SoftAssert();
    }
    @AfterTest
    public void tearDown()
    {
      //driver.quit();
    }


}
