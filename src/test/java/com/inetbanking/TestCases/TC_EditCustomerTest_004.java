package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.EditCustomerPage;
import com.inetbanking.PageObject.loginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCustomer() throws IOException, InterruptedException {

		loginPage lp = new loginPage(driver);

		lp.setUserName(username);
		log.info("Entered username");
		
		lp.setPassword(password);
		log.info("entered password");

		lp.clickSubmit();
		log.info("chicked sumitbtn");

		EditCustomerPage ed = new EditCustomerPage(driver);
		Thread.sleep(5000);
		
		ed.ClickEditCustomer();
		log.info("clicked editcustomer");
		driver.navigate().refresh();
		
		try{Thread.sleep(2000);
		ed.ClickEditCustomer();
		log.info("clicked editcustomer");}
		catch(Exception e) {
			e.getMessage();
		}
		
		Thread.sleep(5000);
		ed.EnterCusID("78051");
		log.info("Enerted customerID");
		
        ed.ClickEditCustomer();
		
		ed.ClickeditSumit();
		log.info("Sumited");
		
		Thread.sleep(5000);
		ed.editCity("Musiri");
		log.info("edited city");
		
		ed.editsumit();
		log.info("final sumit");
		driver.switchTo().alert().accept();

		Assert.assertEquals(driver.getTitle(), "");

		if (driver.getTitle().equals("")) {

			log.info("editCustomer test pass");
			Assert.assertTrue(true);
		} else {
			CaptureScreen(driver, "editCustomer");
			log.info("editCustomer test fail");
			Assert.assertTrue(false);
		}

	}
}
