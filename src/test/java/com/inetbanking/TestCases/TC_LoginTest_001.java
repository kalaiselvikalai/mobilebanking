package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.inetbanking.PageObject.loginPage;


import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	

	
	
@Test	
public void loginTest() throws InterruptedException, IOException {
	
	//driver.get(baseURL);
	
	log.info("URL is open");
	
	loginPage lp=new loginPage(driver);
	

	
	lp.setUserName(username);
	log.info("Entered username");
	
	lp.setPassword(password);
	log.info("Entered Password");
	
	lp.clickSubmit();
	
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		log.info("Login test pass");
	}
	else
	{
		CaptureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		log.info("Login test fail");
	}
}	
	

}
