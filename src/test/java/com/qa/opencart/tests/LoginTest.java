package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.Base1;
import com.qa.opencart.pages.Login1;
import com.qa.opencart.utils.Constants;

public class LoginTest extends Base1 {

	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String title = loginPage1.getLoginPageTitle();
		System.out.println("Actual Page title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void getCurentPageUrlTest() {
		String url = loginPage1.getCurentPageUrl();
		System.out.println("Login page url is:" + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}

	@Test(priority = 4)
	public void verifyForgotPwdlinkExistTest() {
		Assert.assertTrue(loginPage1.verifyForgotPwdlinkExist());
	}

	@Test(priority = 3)
	public void verifyMyAccountDropDownMenuTest() {
		loginPage1.verifyMyAccountDropDownMenu();
	}

	@Test(priority = 5)
	public void verifyRegisterLinkExistTest() {
		Assert.assertTrue(loginPage1.verifyRegisterLinkExist());
	}

	@Test(priority = 6)
	public void doLoginTest(String un, String pwd) {
		loginPage1.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
}
