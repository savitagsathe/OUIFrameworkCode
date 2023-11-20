package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void regPageSetUp() {
		loginPage.verifyMyAccountDropDownMenu();
		registartionPage = loginPage.navigateToRegisterPage();

	}
	public String getRandomNumber() {
		Random random=new Random();
		String email="testautomation"+random.nextInt(5000)+"@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object data[][] = null;
		try {
			data = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "getRegTestData")
	public void RegistrationTest(String firsname, String lastname, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(registartionPage.registration(firsname,lastname,getRandomNumber(), telephone, password,
						 subscribe));

	}

}