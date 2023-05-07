package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AccountsPage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    private By header = By.cssSelector("div#logo a");

    private By accountsSections = By.cssSelector("div#content h2");
    private By searchField = By.name("search");
    private By searchButton = By.cssSelector("div#search button");

    private By logOutLink = By.linkText("Logout");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getaccountPageTitle() {
        return elementUtil.doGetTitleWithFraction(com.qa.opencart.utils.Constants.ACCOUNTS_PAGE_TITLE, com.qa.opencart.utils.Constants.DEFAULT_TIMEOUT);
    }

    public Boolean getAccountsPageHeader() {
        return elementUtil.doIsDisplayed(header);
    }

    public boolean isLogoutLinkExist() {
        return elementUtil.doIsDisplayed(logOutLink);
    }

    public void logout() {
        if (isLogoutLinkExist()) {
            elementUtil.doClick(logOutLink);
        }
    }

    public List<String> getAccountSecList() {
        List<WebElement> accSecList = elementUtil.waitForElementsToBeVisible(accountsSections, 10);

        List<String> accSecValList = new ArrayList<String>();

        for (WebElement e : accSecList) {
            String text = e.getText();
            accSecValList.add(text);
        }
        return accSecValList;
    }

    public boolean isSearchExist() {
        return elementUtil.doIsDisplayed(searchField);
    }

    public SearchResultsPage doSearch(String productName) {
        System.out.println("Searching the product" + productName);
        elementUtil.doSendKeys(searchField, productName);
        elementUtil.doClick(searchButton);
        return new SearchResultsPage(driver);
    }


}
