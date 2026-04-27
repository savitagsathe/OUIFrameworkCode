package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class factory {
	public static WebDriver driver;
	public static String  highlight;
	public Properties prop;
	
	public WebDriver initDriver(Properties prop) {
		highlight=prop.getProperty("highlight");
		String browser=prop.getProperty("browser").trim();
		System.out.println("Browser name is:"+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
			
		}
		else
		{
			System.out.println("Please pass the correct browser name:"+browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		return driver;
	}
	
	public Properties initProp() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\savitas\\eclipse-workspace\\Open cart\\OUIFrameworkCode\\src\\test\\resources\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}
