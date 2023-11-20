package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("div #search button");
	private By logoutLink=By.linkText("Logout");
	private By accSecHeader=By.cssSelector("div#content h2");
	
	
    public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String accPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.ACC_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean isSearchFieldExist() {
		return elementUtil.doIsDisplayed(search);
	}
	
	public List<String> getAccountSecList() {
		
		List<WebElement>secList=elementUtil.getElements(accSecHeader);
		List<String> secHeaderList=new ArrayList<String>();
		for(WebElement e: secList) {
			secHeaderList.add(e.getText());
		}
		return secHeaderList;
	}

	public ResultsPage doSearch(String productName) {
		System.out.println("ProductName is :"+productName);
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchIcon);
		return new ResultsPage(driver);
		
	}
	
}
