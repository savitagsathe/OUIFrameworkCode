package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.Base1;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPageTest1 extends Base1{
	@BeforeClass
	public void accPageSetUp() {
		accPage=loginPage1.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void accPageTitleTest() {
		String title= accPage.accPageTitle();
		System.out.println("Account page titile is:"+title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
	}
	
	@Test
	public void accPageLogoutlinkTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageSearchTest() {
		Assert.assertTrue(accPage.isSearchFieldExist());
	}
	
	@Test
	public void accPageSecHeaderTest() {
	List<String> actSecList=accPage.getAccountSecList();
	System.out.println(actSecList);
	Assert.assertEquals(actSecList,Constants.EXP_ACCOUNTS_SECTION_LIST);
	}
	
	
}
