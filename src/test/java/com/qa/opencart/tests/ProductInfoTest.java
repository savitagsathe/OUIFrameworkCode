package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.Map;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;

public class ProductInfoTest extends BaseTest
{
	
	@BeforeClass
	public void productInfoPageSetUp() {
		loginPage.verifyMyAccountDropDownMenu();
		accountsPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void productHeaderTest() {
		resultsPage=accountsPage.doSearch("macbook");
		productInfoPage=resultsPage.selectProduct("MacBook Pro");
		String actHeader=productInfoPage.getProductHeaderText();
		AssertJUnit.assertEquals(actHeader, "MacBook Pro");
	}
	
	@DataProvider
	public Object[][] getImageData() {
		return new Object[][] {
			
			{"macBook","MacBook Pro",4},
			{"imac","iMac", 3},
			{"Apple", "Apple Cinema 30\"",6}
		};
	}
	
	
	@Test(dataProvider ="getImageData")
	public void productImageCountTest(String productName,String mainProductName, int imageCount) {
		resultsPage=accountsPage.doSearch(productName);
		productInfoPage=resultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductImagesCount(), imageCount);
	}
	
	
	@Test
	public void productMetaDataTest() {
		resultsPage=accountsPage.doSearch("macBook");
		productInfoPage=resultsPage.selectProduct("MacBook Pro");
		Map<String, String>actProdMap=productInfoPage.getProductMetaData();
		actProdMap.forEach((k,v)->System.out.println(k+ ":"+ v));
		/* here if 1st asssertion got failed all the other assertion will get failed thats why its called hard assertion.So we have to use SoftAssert ref. create in basetest
		-when we have multiple assertion to validate then use softAssertion and if we have single assetion then use hard assert
		Assert.assertEquals(actProdMap.get("ProductName"), "MacBook Pro");
		Assert.assertEquals(actProdMap.get("Brand"), "Apple");*/
		
		softAssert.assertEquals(actProdMap.get("ProductName"), "MacBook Pro");
		softAssert.assertEquals(actProdMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProdMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProdMap.get("Reward Points"), "800");
		softAssert.assertAll();//mandatory it will tell the how many pass and how many fail
		
}

}