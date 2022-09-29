package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.PageObject.NewAccountPage;
import com.inetbanking.PageObject.loginPage;

import junit.framework.Assert;

@Test
public class TC_NewAccountTest_005 extends BaseClass {

	public void CreateNewAccount() throws IOException, InterruptedException {
		log.info("URL lanuched");
		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		log.info("Entered username");

		lp.setPassword(password);
		log.info("entered password");

		lp.clickSubmit();
		log.info("chicked sumitbtn");

		NewAccountPage na = new NewAccountPage(driver);

		na.clickNewAccount();
		//driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(500);
		try {
			na.clickNewAccount();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(500);
		log.info("Creating new Account Details Providing......");
		na.entercustomerID("78051");
		na.EnterdepositAmount("500");
		na.clickbtn();
		String text = na.gettext();
		if (text.equals("Account Generated Successfully!!!")) {
			log.info("CreateNewAccount Test is passed");
			Assert.assertTrue(true);
		} else {
			CaptureScreen(driver, "CreateNewAccount");
			log.info("CreateNewAccount Test is Failed");
			Assert.assertTrue(false);
		}
	}

}
