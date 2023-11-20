package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void getLoginPageTitleTest() {
		String title=loginPage.getTitle();
		System.out.println("Actaul page title is:"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getLoginPageUrlTest() {
		String url=loginPage.getCurrentPageUrl();
		System.out.println("Actaul page url is:"+url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	@Test(priority=3)
	public void verifyMyAccountDropDownMenuTest() {
		loginPage.verifyMyAccountDropDownMenu();
	}
	
	@Test(priority=4)
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority=5)
	public void isRegisterLinkExistTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Test(priority=6)
	public void doLoginPageTest() {
		loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}

}
