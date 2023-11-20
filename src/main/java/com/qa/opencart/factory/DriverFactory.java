package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public  OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public static final Logger LOG = Logger.getLogger(DriverFactory.class);

	/*
	 * @author savita //always good practice write author name
	 */

	public WebDriver initDriver(Properties prop) {
		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight");
		String browser = prop.getProperty("browser").trim();
		System.out.println("Browser name is:" + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Projects\\Ballistix Project\\softwares\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co=new ChromeOptions();
			co.setBinary("C:\\Users\\Admin\\Desktop\\Projects\\Ballistix Project\\softwares\\chrome-win64\\chrome.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			//tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			//driver = new FirefoxDriver(OptionsManager.getFireFoxOptions());
			 //tlDriver.set(new FirefoxDriver (optionsManager.getChromeOptions()));
		}

		else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
			//tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser name....." + browser);
		}

		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
		/*
		 * getDriver().manage().window().maximize();
		 * getDriver().manage().deleteAllCookies();
		 * getDriver().get(prop.getProperty("url"));
		 * 
		 * return getDriver();
		 */
	}

	public synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip=null;

		String env = System.getProperty("env");
		if (env == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Running on environment" +env);

			try {
				switch (env.toLowerCase()) {

				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;

				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;

				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;

				default:
					System.out.println("Please pass the right environment..."+env);
					break;

				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 * @return 
	 */

	public String gateScreenShot() {
		File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
