package com.comcst.crm.generic.baseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JSONUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcst.crm.objectrepository.HomePage;
import com.comcst.crm.objectrepository.LoginPage;

public class BaseClass {
	public DataBaseUtility dbLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JSONUtility juLib = new JSONUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wbLib = new WebDriverUtility();



	public WebDriver driver=null;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		System.out.println("=============Connect to DB and Report Config==========");
		dbLib.getDBConnection();
		System.out.println("==============Connected to DB=======================");		
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {
		System.out.println("================Let's Launch the browser===============");
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		if(BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equals("edge"))
			driver =new EdgeDriver();
		else if(BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		sdriver = driver;

		UtilityClassObject.setDriver(driver);   //sharing the static variable for parallel execution
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("===============Let's Login to Browser================");
		//String URL = flib.getDataFromPropertiesFile("url");
		//String USERNAME = flib.getDataFromPropertiesFile("username");
		//String PASSWORD = flib.getDataFromPropertiesFile("password");
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String USERNAME  = System.getProperty("userName", fLib.getDataFromPropertiesFile("userName"));
		String PASSWORD = System.getProperty("passWord", fLib.getDataFromPropertiesFile("passWord"));

		driver.get(URL);
		wbLib.maximizeWindow(driver);
		wbLib.waitForPageToLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("=================Test Execution Begins now===============");
	}

	@AfterMethod(alwaysRun = true)
	public void congifAM() {
		System.out.println("============LogOut the Browser===============");

		HomePage hp = new HomePage(driver);
		hp.signOut();
		driver.quit();
		System.out.println("============LogOut the Browser===============");
	}
	@AfterSuite (alwaysRun =  true)
	public void configAS() {
		System.out.println("====disconnect DB and report backup====");
		
		dbLib.closeDBconn();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
	}
}
