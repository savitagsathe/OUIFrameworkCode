package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistartionPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheck = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessg = By.cssSelector("div #content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistartionPage(WebDriver driver) {
		//this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public boolean registration(String firsName, String lastName, String email,String telephone, String password,
			String subscribe) {
		fillRegForm(firsName, lastName, email,telephone, password);
		selectSubscriOption(subscribe);
		selectAgreeAndContinue();
		return getRegistrationStatus();
		

	}

	private boolean getRegistrationStatus() {
		String mesg = elementUtil.doGetText(successMessg);

		if (mesg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
	

	private void selectSubscriOption(String subscribe) {
		if (subscribe.equalsIgnoreCase("yes")) {
			elementUtil.doClick(subscribeYes);
		}
		elementUtil.doClick(subscribeNo);
	}

	public void selectAgreeAndContinue() {
		elementUtil.doClick(agreeCheck);
		elementUtil.doClick(continueButton);

	}

	public void fillRegForm(String firsName, String lastName,String email, String telephone, String password) {

		elementUtil.doSendKeys(this.firstName, firsName);
		elementUtil.doSendKeys(this.lastName, lastName);
		
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);

	}
}
