package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class Login1 {
	private WebDriver driver;
	ElementUtil elementUtil;
	
//page locator-poOR
	private By emailId=By.id("input-email");
    private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotpwdLink= By.linkText("Forgotten Password");
	private By registerLink= By.linkText("Register");
	private By accountDropDown = By.xpath("//div[@id='top-links']//li//span[text()='My Account']");
	private By loginMenu = By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a[text()='Login']");
	
	//Page constructor :
	public Login1(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page Actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public String getCurentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyForgotPwdlinkExist() {
		return driver.findElement(forgotpwdLink).isDisplayed();
	}
	
	public boolean verifyRegisterLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public AccountPage1 doLogin(String un,String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountPage1(driver);
		//driver.findElement(emailId).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginBtn).click();
	}
	
	public void verifyMyAccountDropDownMenu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(accountDropDown);

		elementUtil.selectDropDownWithoutSelect(loginMenu, "Login");
	}
	
}




