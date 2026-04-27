package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.factory;
import com.qa.opencart.pages.AccountPage1;
import com.qa.opencart.pages.Login1;

public class Base1 {
	public WebDriver driver;
	public Properties prop;
	public factory df;
	public Login1 loginPage1;
	public AccountPage1 accPage;
	
	@BeforeTest
	public void setUp() {
		df=new factory();
		prop=df.initProp();
	    driver=df.initDriver(prop);
	    loginPage1=new Login1(driver);
	}

	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
