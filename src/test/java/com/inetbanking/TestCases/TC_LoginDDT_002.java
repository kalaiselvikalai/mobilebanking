package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.loginPage;
import com.inetbanking.Utilities.ReadExcelFile;
import com.inetbanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass

{
	// ReadExcelFile rs = new ReadExcelFile();

	@Test(dataProvider = "loginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {

		loginPage lp = new loginPage(driver);
		lp.setUserName(user);
		log.info("user name provided");
		lp.setPassword(pwd);
		log.info("password provided");
		lp.clickSubmit();
		// rs.readExcelData(4);
		Thread.sleep(3000);

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();

			Assert.assertTrue(false);
			log.info("Login test fail");

			if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				System.out.println("Screenshot not taken");

			} else {
				CaptureScreen(driver, "loginDDT");

			}
		} else {
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() throws IOException // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {
		String path = "C:\\Users\\Admin\\eclipse-workspace\\inetbankingV1\\src\\test\\java\\com\\inetbaning\\TestData\\XlsloginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}

}
