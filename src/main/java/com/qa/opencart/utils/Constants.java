package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
	//static is using bcoz i dont want to create the unnecessary object of final
	public static final int DEFAULT_TIME_OUT=5;
	public static final String LOGIN_PAGE_TITLE="Your Store";
	public static final String LOGIN_PAGE_URL = "/opencart/";
	public static final String ACC_PAGE_TITLE="My Account";
	public static final List<String> EXP_ACCOUNTS_SECTION_LIST=new ArrayList<String>(Arrays.asList("My Account", 
			"My Orders","My Affiliate Account", "Newsletter"));
	public static final int IMAC_IMAGE_COUNT = 4;
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Haas Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
	

}
