package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver ;
    private ElementUtil elementUtil;

    private By productResults = By.cssSelector("div.caption a");

    public SearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public int  getProductsListCount() {
          int resultCount =  elementUtil.waitForElementsToBeVisible(productResults,10,2000).size();
        System.out.println("the search product count is"+resultCount);
           return resultCount;
    }

    public ProductInfoPage selectProduct(String mainProductName) {
        System.out.println("the main productname is " + mainProductName);
      List<WebElement> searchList =  elementUtil.waitForElementsToBeVisible(productResults,10,2000);

     for(WebElement e : searchList)
     {
         String text =e.getText();
         if(text.equals(mainProductName))
         {
             e.click();
             break;
         }
     }
       return new ProductInfoPage(driver);
    }






}
