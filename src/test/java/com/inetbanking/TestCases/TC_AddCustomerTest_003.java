package com.inetbanking.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.loginPage;
import com.inetbanking.PageObject.AddCustomerPage;
import com.inetbanking.PageObject.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException, AWTException {
		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		log.info("User name is provided");
		lp.setPassword(password);
		log.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		//// *[@id="ad_iframe"]

		log.info("providing customer details....");

		addcust.custName("Kalai");
		addcust.custgender("Female");
		addcust.custdob();

		Thread.sleep(6000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomstring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		log.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			log.info("test case passed....");

		} else {
			log.info("test case failed....");
			CaptureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}
}
