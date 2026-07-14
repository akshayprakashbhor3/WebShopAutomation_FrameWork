package org.GenricLibary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("[test Case "+ result.getName()+" has Started]",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[test Case "+ result.getName()+" has Successfully Executed]",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("[TestCase "+result.getName()+" has Failed");
		
		String time = LocalDateTime.now().toString();
		String dateTime = time.replaceAll(":", "-");
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./ErrorShot/" + result.getName()+ dateTime +".png");
	try {
		FileHandler.copy(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("[test Case "+ result.getName()+" has Skipped]",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("[test Case "+ result.getName()+" has Failed With Some Percentage]",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("[test Case "+ result.getName()+" has Failed Due To TimeOut]",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("<test Case> "+ context.getName()+" has Successfully Started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("<test Case> "+ context.getName()+" has Successfully Finishsed",true);
	}
	

}
