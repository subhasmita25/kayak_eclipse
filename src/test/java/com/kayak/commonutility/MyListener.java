package com.kayak.commonutility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.kayak.scripts.SuperScript;

public class MyListener implements ITestListener
{
	

	public void onFinish(ITestContext result) {
		System.out.println("Name of the test case finished is "+result.getName());		
		
	}

	public void onStart(ITestContext result) {
		System.out.println("Name of the test case started is "+result.getName());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result1) {
		//String name = result1.getName();
		EventFiringWebDriver e=new EventFiringWebDriver(SuperScript.driver);
		
		File destinationFile=new File("./screenshot/failed/"+System.currentTimeMillis()+".png");
		try
		{
			FileUtils.copyFile(e.getScreenshotAs(OutputType.FILE), destinationFile);
		} 
		catch (Exception e1)
		{
			System.out.println(e1.getMessage());	
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result3) {
		System.out.println("The successed test case name is "+result3.getName());	
		//String name = result3.getName();
		
		EventFiringWebDriver e=new EventFiringWebDriver(SuperScript.driver);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy h-m-s");
        Date date = new Date();

		File destinationFile=new File("./screenshot/passed/"+dateFormat.format(date)+".png");
		try {
			FileUtils.copyFile(e.getScreenshotAs(OutputType.FILE), destinationFile);
		} 
		catch (WebDriverException e1) {
			e1.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
