package com.qa.opencart.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

	public static String highlight;
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	/**
	 * this method is use to intialize a webdriver
	 *
	 * @parambrowserName
	 * @return will return the driver
	 */

	public WebDriver init_Driver(Properties prop) {

		String browserName =prop.getProperty("browser");
		System.out.println("browser name is " + browserName);

		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			/* ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");*/
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println(" Please pass the right browser" + browserName);
		}
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
return driver;

	}

	/**
	 * This method is use to initialize the Properties
	 * @return will return properties prop reference
	 */
	public Properties init_prop() {
		prop = new Properties();
		/*
        ./ means from  current project directory you traverse
		 */
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return prop;

	}
}
