package com.comcst.crm.generic.listenerutility;


import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcst.crm.generic.baseClassUtility.BaseClass;


public class ListenerImplementaionClass implements ITestListener, ISuiteListener{

	ExtentSparkReporter spark;
	ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("===Report configuration===");

		//spark report--->configuration of the report Started
		String date = new Date().toString().replace(" ","_").replace(":",".");
//		File path = new File("./ExtentReports/Reports"); 
		spark  =new ExtentSparkReporter("./ExtentReports/Reports"+date+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("CRM Application==> CreateCOntatc Test");
		spark.config().setReportName("Contatc Create Test");

		//environmant Information
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("===Report backup===");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+"=====STARTED!!!!====");
		UtilityClassObject.setTest(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====SUCCESS!!!!====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
String time = new Date().toString().replace(" ", "_").replace(":", ".");
		
		String testName = result.getMethod().getMethodName()+time;
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
			
		//capture the screenshot attached to extent report
		String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(srcFile, testName);
		test.log(Status.FAIL, result.getThrowable());
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAILED!!!!====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"=====SKIPPED!!!!====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAILED!!!!====");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAILED WITH TIMEOUT!!!!====");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("====TEST START====");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("====TEST FINISH====");
	}



}
