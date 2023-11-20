package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;



public class AccountsPageTest extends BaseTest{
	
@BeforeClass
public void accPageSetUp() {
	loginPage.verifyMyAccountDropDownMenu();
	accountsPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
@Test
public void accPageTitleTest() {
	String title=accountsPage.accPageTitle();
	System.out.println("Actual page title is:"+title);
	Assert.assertEquals(title,Constants.ACC_PAGE_TITLE);
	
}
	
@Test
public void accPageLogoutLinkTest() {
	Assert.assertTrue(accountsPage.isLogoutLinkExist());
}

@Test
public void accPageSearchFieldExistTest() {
	Assert.assertTrue(accountsPage.isSearchFieldExist());
}


@Test()
public void accPageSectionHeaderTest() {
	List<String>actSecList=accountsPage.getAccountSecList();
	System.out.println("Actual section list is: "+actSecList);
	Assert.assertEquals(actSecList, Constants.EXP_ACCOUNTS_SECTION_LIST);
}

@DataProvider
public Object[][] productData() {
	return new Object[][] {
		{"macBook"},
		{"imac"},
		{"Apple"}
	};
}


@Test(dataProvider ="productData")
public void searchTest(String productName) {//i havent wrote this parameter to this method
	resultsPage=accountsPage.doSearch(productName); //and relapce that parameter here
	Assert.assertTrue(resultsPage.getSearchProductListCount()>0);
}

@DataProvider
public Object[][] productSelectData() {
	return new Object[][] {
		{"macBook","MacBook Air"},
		{"imac", "iMac"},
		{"Apple", "Apple Cinema 30\""} //escape cahracter denote the for inch we have include it
	};
}

@Test(dataProvider ="productSelectData")
public void selectProductTest(String productName,String mainProductName) {
	resultsPage=accountsPage.doSearch(productName);
	resultsPage.selectProduct(mainProductName);
}
	
	
	
	

}
