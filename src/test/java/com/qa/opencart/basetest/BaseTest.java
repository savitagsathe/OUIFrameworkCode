package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistartionPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ResultsPage resultsPage;
	public ProductInfoPage productInfoPage;
	public RegistartionPage registartionPage;
	
	public SoftAssert softAssert;
	
	
	@BeforeTest
	public void setUp() {
		//i have to initialize the driver which is already initialized in driverFactory class.So we have to create the DriverFactoty class object
		df=new DriverFactory();//driver from the initDriver method will store here and pass the same here.
        prop=df.initProp();
		driver= df.initDriver(prop);        
        loginPage=new LoginPage(driver);
        //softAssert=new SoftAssert();//otherwise it will give nullPointerException
	}

	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
