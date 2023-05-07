package com.qa.opencart.pages;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {

private WebDriver driver;
public ElementUtil elementUtil;

private By productHeader = By.xpath("//div[@id='content']//h1");
private By productImages = By.cssSelector("ul.thumbnails a");
private By productMetadata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
private By productPricedata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");

private Map<String,String> productInfoMap;

private By qty = By.id("input-quantity");

private  By addToCartBtn = By.id("button-cart");

public ProductInfoPage(WebDriver driver)
{
    this.driver = driver;
    elementUtil = new ElementUtil(driver);
}

public String getProductHeader() {
String productHeaderName = elementUtil.doGetText(productHeader);
    System.out.println("the product header is "+productHeaderName);
   return productHeaderName;
}

public int getProductImagesCount()
{
     return elementUtil.waitForElementsToBeVisible(productImages,10).size();
}

public Map<String, String> getProductInfo()
{
    productInfoMap= new LinkedHashMap<String, String>();
    productInfoMap.put("name",getProductHeader());
    getProductMetaData();
    getProductPriceData();
    return productInfoMap;
}

private void getProductMetaData()
{
    List<WebElement> metaDataList =elementUtil.getElements(productMetadata);


    /**
     * Brand: Apple
     * Product Code: Product 18
     * Reward Points: 800
     * Availability: In Stock
     */

    for(WebElement e : metaDataList)
    {
        String text =e.getText();
          String meta[] = text.split(":");
                  String metaKey= meta[0].trim();
                  String metaValue =meta[1].trim();
                  productInfoMap.put(metaKey,metaValue);
    }
}
    private void getProductPriceData()
    {
             List<WebElement> metaPriceList= elementUtil.getElements(productPricedata);
        /**
         * $2,000.00
         * Ex Tax: $2,000.00
         */
       String price = metaPriceList.get(0).getText();
          String exPrice =metaPriceList.get(1).getText();
          productInfoMap.put("price",price);
          productInfoMap.put("ExTaxPrice",exPrice);
    }












}
