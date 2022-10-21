package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname="mystorereport"+timestamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportname);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		ReadConfig rc=new ReadConfig();
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("os:", "windows 11");
		reports.setSystemInfo("browser:", rc.getBrowser());
		reports.setSystemInfo("username:", "bhushan1211");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listner Report Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onStart(ITestContext context) {	
		System.out.println("onStart method started");
		configureReport();
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		reports.flush();
	}
	
		public void onTestStart(ITestResult result) {
			System.out.println("New Test Started" +result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println("onTestSuccess Method" +result.getName());
			test=reports.createTest(result.getName());
			test.log(Status.PASS,MarkupHelper.createLabel("name of failed test case is :"+result.getName(),ExtentColor.GREEN));
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("onTestFailure Method" +result.getName());
			test=reports.createTest(result.getName());
			test.log(Status.FAIL,MarkupHelper.createLabel("name of failed test case is :"+result.getName(),ExtentColor.RED));
		
			String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
			
			File screenshotFile=new File(screenshotpath);
			
			if(screenshotFile.exists())
			{
				test.fail("Captured screenshot is below"+test.addScreenCaptureFromPath(screenshotpath));
			}
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("onTestSkipped Method" +result.getName());
			test=reports.createTest(result.getName());
			test.log(Status.SKIP,MarkupHelper.createLabel("name of failed test case is :"+result.getName(),ExtentColor.YELLOW));
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
		}



}
