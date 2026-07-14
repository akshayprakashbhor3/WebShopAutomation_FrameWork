package org.GenricLibary;

import java.time.Duration;

import org.POMrepository.BAsePage;
import org.POMrepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements FrameWorkConstant
{
	public static WebDriver driver;
@BeforeClass
public void browserStep()
	{
		String browservalue = Flib.getPropertyValue(properties_path_main,"browser");
		String url = Flib.getPropertyValue(properties_path_main,"Url");
		
		if(browservalue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		else {
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
		
	}
@BeforeMethod
public void login() {
	String email =Flib.getPropertyValue(excel_path_main,"email");
	String password = Flib.getPropertyValue(excel_path_main,"password");
	
	BAsePage basePage = new BAsePage(driver);
	basePage.getLoginLink().click();
	
	LoginPage logIn = new LoginPage(driver);
	logIn.getEmailTextbox().sendKeys(email);
	logIn.getPasswordTextBox().sendKeys(password);
	logIn.getLoginButton().click();
	
	
	
	
}
@AfterMethod
public void Logout()
{
	BAsePage basepage = new BAsePage(driver);
	basepage.getLogOutLink().click();
	
}
@AfterClass
public void closeBrowser() {
	driver.close();
}

}
