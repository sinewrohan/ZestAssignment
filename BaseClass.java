package com.zest.assigmnment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brcc.cs.objectrepository.LoginXpath;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chromedriver.exe", "C:\\Users\\guptaro\\eclipse-workspace\\SeleniumDummy\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
	  }
	
	@Test(priority=1)
	public void CreateLoginTest() throws Exception {
		
		String inputdata[][]=null;		
		PageFactory.initElements(driver, FbLogin.class);
		inputdata= ExcelLib.getExcelFile(Constant.loginData, Constant.LoginDataSheet1Input);
		FbLogin.username.sendKeys(inputdata[1][0]);
		FbLogin.pass.sendKeys(inputdata[1][1]);	
	}
	@Test(priority=2)
	public void CreatePostTest() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.postStatus("Hello world");
	}
	
	  @AfterMethod
	  public void closingBrowser() {
		  driver.close();
	  }	
}
