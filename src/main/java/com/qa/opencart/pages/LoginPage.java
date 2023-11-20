package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;// its not pointing to driver=new ChormeDriver. driverFactory(for initialise
								// chrome drver) and this driver is different.Its value is null. Only for
								// loginPage.
	ElementUtil elementUtil;

	// 1.By locators-Page Object(PO)-Object Repository(OR)-
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	By accountDropDown = By.xpath("//div[@id='top-links']//li//span[text()='My Account']");
	By loginMenu = By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a[text()='Login']");

	private By loginbutton = By.xpath("//input[@value='Login']");
	private By forgotpwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// 2.Page Constructor : Every time we have to perfrom the action e.g :
	// click,enter the text and so on.for thatt i need driver for that we have
	// create the page constructor
	// my job is you take the Webdriver as holding parameter and through the
	// constructor we will give the webdriver .So u dont need to worry about how
	// exactly you are getting
	// the driver.So we have to create the public constructor not private otherwise
	// you will not create the object of this class.Constructor expecting one driver
	// we have supply
	// driver to the constructor .To supply the private driver to this constructor
	// we have to use "this keyword".We are following SRP(single resposibility
	// principle) this class
	// is not responsible for initialise the driver its a driveFactory class
	// responsibility. means particular class is only responsible for specific task

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3.Page Actions/methods/features:

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
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
		// return new LoginPage(driver);

		/*
		 * List<WebElement> loginMenu=driver.findElements(By.xpath(
		 * "//div[@id='top-links']/ul/li[2]/ul/li[2]/a[text()='Login']"));
		 * 
		 * for(WebElement e:loginMenu) { String text=e.getText();
		 * if(text.equals("Login")) { e.click(); break; } }
		 */

	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotpwdLink);
	}

	public boolean isRegisterLinkExist() {
		return elementUtil.doIsDisplayed(registerLink);
	}
	
	public RegistartionPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistartionPage(driver);
	}

	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginbutton);
		return new AccountsPage(driver);
		/*
		 * driver.findElement(emailId).sendKeys(un);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginbutton).click();
		 */
	}
}









/*
 * here r 3 things we have to write 1.By locatore-Page Objects/Object repository
 * -All loactors should be private in nature according to POM
 * 
 * //2.Page Constructor: everytime i have to perform action for that i want
 * driver.Through the constructor we give driver and same driver we have to pass
 * .So use this keyword here we are following the SRP(single responsibility
 * principle).
 * 
 * //3.page actions/methods/features:These actions should be called by testNG so
 * should be public in nature
 * 
 * Now Go to the BaseTest.java
 */
